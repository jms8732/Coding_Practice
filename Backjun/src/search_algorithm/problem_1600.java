package search_algorithm;

//¸»ÀÌ µÇ°íÇÂ ¿ø¼þÀÌ
import java.util.*;
import java.io.*;

public class problem_1600 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };
	static int[] d_ud = { -2, -1, 1, 2, 2, 1, -1, 2 };
	static int[] d_rl = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		simulation(map, 0, 0, k, N, M);
	}

	private static void simulation(int[][] map, int startX, int startY, int k, int N, int M) {
		Queue<monkey> q = new LinkedList<>();
		int[][] score = new int[M][N];
		boolean[][][] visited = new boolean[M][N][k + 1];

		q.add(new monkey(startX, startY, k, 0));

		for (int i = 0; i < k; i++)
			visited[0][0][i] = true;

		int answer = -1;
		while (!q.isEmpty()) {
			monkey cur = q.poll();

			if (cur.x == M - 1 && cur.y == N - 1) {
				System.out.println(score[M-1][N-1]);
				System.exit(0);
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny][cur.k] || map[nx][ny] == 1)
					continue;

				if (score[nx][ny] == 0)
					score[nx][ny] = cur.move + 1;
				else
					score[nx][ny] = Math.min(cur.move + 1, score[nx][ny]);

				visited[nx][ny][cur.k] = true;
				q.add(new monkey(nx, ny, cur.k, cur.move + 1));

			}

			if (cur.k > 0) {
				for (int i = 0; i < 8; i++) {
					int nx = cur.x + d_ud[i];
					int ny = cur.y + d_rl[i];

					if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny][cur.k] || map[nx][ny] == 1)
						continue;

					if (score[nx][ny] == 0)
						score[nx][ny] = cur.move + 1;
					else
						score[nx][ny] = Math.min(cur.move + 1, score[nx][ny]);

					visited[nx][ny][cur.k - 1] = true;
					q.add(new monkey(nx, ny, cur.k - 1, cur.move + 1));
				}
			}
		}
		System.out.println(answer);
	}

	private static void print(int[][] board, int N, int M) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
					System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static class monkey {
		int x, y, k, move;

		public monkey(int x, int y, int k, int m) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.move = m;
		}
	}
}
