package samsung;

//나무 재테크

import java.util.*;
import java.io.*;

public class problem_16235 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] winterEnergy = new int[N][N]; // 겨울에 줄 에너지
		ground g[][] = new ground[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int energy = Integer.parseInt(st.nextToken());
				g[i][j] = new ground();
				winterEnergy[i][j] = energy;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int tree = Integer.parseInt(st.nextToken());
			g[x][y].tree.add(tree);
		}

		long start = System.currentTimeMillis();
		for (int i = 0; i < K; i++) {
			spring_summer(g);
			Autumn(g);
			winter(g, winterEnergy);
		}

		long end = System.currentTimeMillis();
		int aliveTree = 0;

		System.out.println("time : " + (end - start) / 1000.0);

		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[i].length; j++) {
				aliveTree += g[i][j].tree.size();
			}
		}
		System.out.println(aliveTree);

	}

	private static void spring_summer(ground[][] g) {
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[i].length; j++) {
				if (!g[i][j].tree.isEmpty()) {
					int currentEnergy = g[i][j].energy;
					int size = g[i][j].tree.size();
					int deadEnergy = 0;
					
					for (int t = 0; t < size; t++) {
						int treeOld = g[i][j].tree.poll();
						if (treeOld > currentEnergy) {
							// 나무가 양분을 얻지 못하고 죽음
							deadEnergy = deadEnergy + (treeOld / 2);
						} else {
							// 자신의 나이만큼 양분을 먹고 나이 1 증가
							currentEnergy -= treeOld;
							g[i][j].tree.addLast(treeOld+1);
						}
					}

					// 여름, 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분 추가
					g[i][j].energy = currentEnergy + deadEnergy;
				}
			}
		}
	}

	private static void Autumn(ground[][] g) {
		int[] ud = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] rl = { -1, 0, 1, -1, 1, -1, 0, 1 };
		
		
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g[i].length; j++) {
				int size = g[i][j].tree.size();
				
				List<Integer> list =new ArrayList<>(g[i][j].tree);

				for (int k = 0; k < list.size(); k++) {
					int currentTree = list.get(k);
					if (currentTree % 5 == 0) {
						// 번식하는 나무의 나이가 5의 배수인 경우
						for (int n = 0; n < ud.length; n++) {
							int nx = i + ud[n];
							int ny = j + rl[n];

							if (nx < 0 || nx >= g.length || ny < 0 || ny >= g.length) {
								continue;
							}

							// 새로운 나무 추가
							g[nx][ny].tree.addFirst(1);
						}
					}
				}
				
				//g[i][j].setTree(tmpQ);
				//g[i][j].setTree(tmpG[i][j].tree);
			}
		}
		
	}

	private static void winter(ground[][] g, int[][] energy) {
		for (int i = 0; i < energy.length; i++) {
			for (int j = 0; j < energy.length; j++) {
				g[i][j].energy += energy[i][j];
			}
		}
	}

	private static class ground {
		Deque<Integer> tree;
		int energy;

		public ground() {
			this.energy = 5;
			tree = new LinkedList<Integer>(); // 트리를 나이 순으로 오름차순 정렬
		}

		public void setTree(Queue<Integer> queue) {
			this.tree = new LinkedList<>(queue);
		}

	}
}
