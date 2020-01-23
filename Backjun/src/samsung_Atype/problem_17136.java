package samsung_Atype;

//������ ���̱�
import java.util.*;
import java.io.*;

public class problem_17136 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Node> queue = new LinkedList<>();
		StringTokenizer st = null;
		int N = 10;
		int[][] map = new int[N][N];
		int[] paper = new int[5];

		// ������ �ʱ�ȭ
		for (int i = 0; i < paper.length; i++)
			paper[i] = 5;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] tmpMap = new int[10][10];
		int[] tmpPaper = new int[5];
		copyMap(map, tmpMap);
		System.arraycopy(paper, 0, tmpPaper, 0, paper.length);
		outter: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < paper.length; k++) {
						if (isCovered(i, j, map, paper, k)) {
							queue.add(new Node(map, paper, 1));
							copyMap(tmpMap, map);
							System.arraycopy(tmpPaper, 0, paper, 0, tmpPaper.length);
						}
					}
					break outter;
				}
			}
		}

		int count = bfs(queue);
		System.out.println(count);
	}

	private static int bfs(Queue<Node> queue) {
		int count = -1;
		
		if(queue.isEmpty())
			return 0;
		
		while (!queue.isEmpty()) {
			Node current = queue.poll();

			if (isFinish(current.map)) {
				count = current.count;
				break;
			}

			int[][] tmpMap = new int[10][10];
			int[] tmpPaper = new int[5];
			copyMap(current.map, tmpMap);
			System.arraycopy(current.paper, 0, tmpPaper, 0, current.paper.length);
			outter: for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (current.map[i][j] == 1) {
						for (int k = 0; k < current.paper.length; k++) {
							if (isCovered(i, j, current.map, current.paper, k)) {
								queue.add(new Node(current.map, current.paper, current.count + 1));
								copyMap(tmpMap, current.map);
								System.arraycopy(tmpPaper, 0, current.paper, 0, tmpPaper.length);
							}
						}
						break outter;
					}
				}
			}
		}

		return count;
	}

	private static void copyMap(int[][] src, int[][] dest) {
		int idx = 0;
		for (int[] tmp : src) {
			System.arraycopy(tmp, 0, dest[idx++], 0, tmp.length);
		}
	}

	private static boolean isCovered(int x, int y, int[][] map, int[] paper, int k) {
		if (paper[k] != 0) {
			// �������� ������ ���� ���� �ִٸ� �ش� �������� ũ��� ���̴��� Ȯ���Ѵ�.
			if ((x + k + 1 <=10) && (y + k + 1 <= 10)) {
				for (int i = x; i < x + k + 1; i++) {
					for (int l = y; l < y + k + 1; l++) {
						if (map[i][l] == 0) {
							return false;
						}
					}
				}
				paper[k] -= 1; // ������ ���� �� �����̷� ���´�.
				for (int i = x; i < x + k + 1; i++) {
					for (int l = y; l < y + k + 1; l++) {
						map[i][l] = 0;
					}
				}
				return true;
			}
		}

		return false;
	}

	private static boolean isFinish(int[][] map) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1)
					return false;
			}
		}

		return true;
	}

	private static class Node {
		int[][] map;
		int[] paper;
		int count;

		public Node(int[][] map, int[] paper, int count) {
			this.paper = new int[paper.length];
			System.arraycopy(paper, 0, this.paper, 0, paper.length);
			this.map = new int[10][10];
			int idx = 0;
			for (int tmp[] : map) {
				System.arraycopy(tmp, 0, this.map[idx++], 0, tmp.length);
			}
			this.count = count;
		}

	}
}
