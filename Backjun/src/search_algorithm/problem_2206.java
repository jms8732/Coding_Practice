package search_algorithm;

//벽 부수고 이동하기 1:30 -> 48:13(42분 소요)
import java.util.*;
import java.io.*;

public class problem_2206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		searchPath(map, N, M);
	}

	private static void searchPath(int[][] map, int N, int M) {
		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };

		boolean[][][] visited = new boolean[2][N][M];
		int[][] board = new int[N][M];

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1, 0));
		
		visited[0][0][0] = true;
		visited[1][0][0] = true;
		int answer = -1;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (cur.x == N - 1 && cur.y == M - 1) {
				answer = cur.c;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[cur.w][nx][ny])
					continue;

				if (map[nx][ny] == 0 || (cur.w == 0 && map[nx][ny] == 1)) {
					visited[cur.w][nx][ny] = true;

					if (board[nx][ny] == 0)
						board[nx][ny] = cur.c + 1;
					else
						board[nx][ny] = Math.min(cur.c + 1, board[nx][ny]);

					if (map[nx][ny] == 1)
						q.add(new Point(nx, ny, cur.c+1, cur.w + 1));
					else
						q.add(new Point(nx, ny, cur.c+1, cur.w));
				}

			}
		}

		//print(board);

		System.out.println(answer);
	}

	/*
	 * private static void print(int[][] board0) { for (int[] tmp : board0) { for
	 * (int i = 0; i < tmp.length; i++) { System.out.print(tmp[i] + " "); }
	 * System.out.println(); } }
	 */
	private static class Point {
		int x, y, c, w;

		public Point(int x, int y, int count, int wallCount) {
			this.x = x;
			this.y = y;
			this.c = count;
			this.w = wallCount;
		}
	}
}
