package search_algorithm;

//탈출
import java.io.*;
import java.util.*;

public class problem_3055 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] forest = new char[R][C];
		int startX = 0, startY = 0;
		int endX = 0, endY = 0;
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				if (tmp.charAt(j) == 'S') {
					startX = i;
					startY = j;
				}

				if (tmp.charAt(j) == 'D') {
					endX = i;
					endY = j;
				}
				forest[i][j] = tmp.charAt(j);
			}
		}

		simulation(forest, R, C, startX, startY, endX, endY);
	}

	private static void simulation(char[][] forest, int R, int C, int startX, int startY, int endX, int endY) {
		Queue<Point> q = new LinkedList<>();
		Queue<Point> w = new LinkedList<>();

		boolean[][] visited = new boolean[R][C];
		int[][] board = new int[R][C];

		q.add(new Point(startX, startY, 0));
		visited[startX][startY] = true;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (forest[i][j] == '*')
					w.add(new Point(i, j, 0));
			}
		}

		String ans = "KAKTUS";
		while (!q.isEmpty()) {
			// 물을 먼저 퍼뜨린다.
			w = waterflood(R, C, forest, w);
			q = move(R, C, forest, board, visited, q);
			//print(forest, visited);
		}
		if (board[endX][endY] != 0)
			ans = Integer.toString(board[endX][endY]);

		System.out.println(ans);

	}

	private static void print(char[][] forest, boolean[][] visited) {
		for (int i = 0; i < forest.length; i++) {
			for (int j = 0; j < forest[i].length; j++) {
				System.out.print(forest[i][j]);
			}
			System.out.println();
		}
		System.out.println();

	}

	private static Queue<Point> move(int R, int C, char[][] forest, int[][] board, boolean[][] visited,
			Queue<Point> q) {
		Queue<Point> next = new LinkedList<>();

		while (!q.isEmpty()) {
			Point cur = q.poll();

			forest[cur.x][cur.y] = '.';
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				// 배열 범위 밖이거나 방문한 곳, 돌맹이 있는 부분 제외
				if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || forest[nx][ny] == 'X')
					continue;

				// 물이 있는 곳 제외
				if (forest[nx][ny] == '*')
					continue;

				if (board[nx][ny] == 0)
					board[nx][ny] = cur.c + 1;
				else
					board[nx][ny] = Math.min(board[nx][ny], cur.c + 1);

				forest[nx][ny] = 'S';
				visited[nx][ny] = true;
				next.add(new Point(nx, ny, cur.c + 1));
			}
		}

		return next;
	}

	private static Queue<Point> waterflood(int R, int C, char[][] forest, Queue<Point> w) {
		Queue<Point> ans = new LinkedList<>();

		while (!w.isEmpty()) {
			Point cur = w.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C || forest[nx][ny] != '.')
					continue;

				ans.add(new Point(nx, ny, 0));
				forest[nx][ny] = '*';
			}
		}

		return ans;
	}

	private static class Point {
		int x, y, c;

		public Point(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
