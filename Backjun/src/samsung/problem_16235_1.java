package samsung;

//나무 재테크
import java.util.*;
import java.io.*;

public class problem_16235_1 {
	static Ground[][] ground;
	static int[][] s2d2;
	static int N, K;
	static int[] ud = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] rl = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		ground = new Ground[N][N];
		s2d2 = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				s2d2[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Deque<Integer> t = new LinkedList<>();
				ground[i][j] = new Ground(t, 5);
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int tree_age = Integer.parseInt(st.nextToken());

			ground[x][y].tree.add(tree_age);
		}

		simulation();
	}

	private static void simulation() {
		for (int i = 0; i < K; i++) {
			spring_summer();
			autumn();
			winter();
		}

		int tree_count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tree_count += ground[i][j].tree.size();
			}
		}

		System.out.println(tree_count);
	}

	private static void winter() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ground[i][j].nutri += s2d2[i][j];
			}
		}
	}

	private static void autumn() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int size = ground[i][j].tree.size();
				for (int k = 0; k < size; k++) {
					int cur = ground[i][j].tree.poll();

					if (cur % 5 == 0) {
						grow_tree(i, j);
					}
					ground[i][j].tree.addLast(cur);
				}
			}
		}
	}

	private static void grow_tree(int x, int y) {

		for (int i = 0; i < 8; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;

			ground[nx][ny].tree.addFirst(1);
		}
	}


	private static void spring_summer() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int dead_tree = 0;
				int size = ground[i][j].tree.size();
				for (int k = 0; k < size; k++) {
					int cur = ground[i][j].tree.poll();

					if (cur <= ground[i][j].nutri) {
						ground[i][j].tree.add(cur + 1);
						ground[i][j].nutri -= cur;
					} else
						dead_tree += (cur /2);
				}

				ground[i][j].nutri += dead_tree;
			}
		}
	}

	private static class Ground {
		Deque<Integer> tree;
		int nutri;

		public Ground(Deque<Integer> t, int nutri) {
			this.tree = new LinkedList<>(t);
			this.nutri = nutri;
		}
	}
}
