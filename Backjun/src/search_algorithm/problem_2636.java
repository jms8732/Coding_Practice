package search_algorithm;

//ДЎБо
import java.util.*;
import java.io.*;

public class problem_2636 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] cheese = new int[N + 2][M + 2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i + 1][j + 1] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(cheese, N + 2, M + 2);
	}

	private static void bfs(int[][] cheese, int n, int m) {
		int time = 0, cheese_block = 0;

		while (true) {
			int tmp = 0;
			if ((tmp = is_finish(cheese, n, m)) > 0)
				cheese_block = tmp;
			else
				break;

			Queue<Point> q = new LinkedList<>();
			q.add(new Point(0, 0));
			boolean[][] visited = new boolean[n][m];
			visited[0][0] = true;

			while (!q.isEmpty()) {
				Point cur = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + ud[i];
					int ny = cur.y + rl[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) {
						continue;
					}

					visited[nx][ny] = true;
					if (cheese[nx][ny] == 0)
						q.add(new Point(nx, ny));
				}

			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visited[i][j] && cheese[i][j] == 1) {
						cheese[i][j] = 0;
					}
				}
			}

			time++;
		}

		System.out.println(time);
		System.out.println(cheese_block);
	}

	private static void print(int[][] cheese, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(cheese[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int is_finish(int[][] cheese, int n, int m) {
		int ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cheese[i][j] == 1)
					ret++;
			}
		}

		return ret;
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
