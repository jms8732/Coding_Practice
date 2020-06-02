package samsung;

//¿¬±¸¼Ò 3
import java.util.*;
import java.io.*;

public class problem_17142_1 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];

		List<Point> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				if (t == 2) {
					list.add(new Point(i, j));
				}

				map[i][j] = t;
			}
		}

		Point virus[] = new Point[list.size()];

		for (int i = 0; i < list.size(); i++) {
			virus[i] = list.get(i);
		}
		Point[] val = new Point[M];

		combination(0, 0, N, M, virus, val, map);
		System.out.println(answer);
	}

	private static void combination(int depth, int next, int N, int M, Point[] virus, Point[] val, int[][] map) {
		if (depth == M) {
			int result = expand_virus(N, map, val);

			if (result != -1) {
				if (answer == -1)
					answer = result;
				else
					answer = Math.min(answer, result);
			}

			return;
		}

		for (int i = next; i < virus.length; i++) {
			val[depth] = virus[i];
			combination(depth + 1, i + 1, N, M, virus, val, map);
		}
	}

	private static int expand_virus(int N, int[][] map, Point[] val) {
		Queue<Point> q = new LinkedList<>();

		int[][] board = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < val.length; i++) {
			visited[val[i].x][val[i].y] = true;
			q.add(val[i]);

		}

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == 1)
					continue;

				visited[nx][ny] = true;
				if (board[nx][ny] == 0)
					board[nx][ny] = board[cur.x][cur.y] + 1;
				else
					board[nx][ny] = Math.min(board[cur.x][cur.y] + 1, board[nx][ny]);

				q.add(new Point(nx, ny));
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0 && map[i][j] == 0)
					return -1;
				else if (map[i][j] != 1 && map[i][j] != 2)
					answer = Math.max(answer, board[i][j]);
			}
		}
		//print(board, N);
		return answer;
	}

	private static void print(int[][] board, int N) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
