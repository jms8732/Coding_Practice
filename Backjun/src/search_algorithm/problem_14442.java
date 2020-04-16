package search_algorithm;

//벽 부수고 이동하기 2 1:30 -> 41:14 (49분 소요)
import java.util.*;
import java.io.*;

public class problem_14442 {
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}

		simulation(map, N, M, K);
	}

	private static void simulation(char[][] map, int N, int M, int K) {
		boolean[][][] visited = new boolean[N][M][K + 1];
		boolean finish = false;
		int[][] board = new int[N][M];
		Queue<Point> q = new LinkedList<>();
		int answer = -1;
		// 시작 지점도 개수에 포함이 되므로 1을 넣는다.
		q.add(new Point(0, 0, 1, 0));
		visited[0][0][0] = true;
		board[0][0] = 1;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (cur.x == N - 1 && cur.y == M - 1)
				finish = true;

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];
				int wall = cur.wall;

				// 배열 범위 밖이거나 방문한 곳이 있는 경우
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][wall])
					continue;

				// 다음 좌표에 벽이 있는 경우
				if (map[nx][ny] == '1') {
					if (wall >= K)
						continue;
					wall += 1;
				}

				visited[nx][ny][wall] = true;

				if (board[nx][ny] == 0)
					board[nx][ny] = cur.c + 1;
				else
					board[nx][ny] = Math.min(board[nx][ny], cur.c + 1);

				q.add(new Point(nx, ny, cur.c + 1, wall));

			}
		}
		if (finish)
			answer = board[N - 1][M - 1];

		System.out.println(answer);
	}

	private static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static class Point {
		int x, y, c, wall;

		public Point(int x, int y, int c, int w) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.wall = w;
		}
	}
}
