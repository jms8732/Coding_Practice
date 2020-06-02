package search_algorithm;

//트리의 높이와 너비
import java.util.*;
import java.io.*;

public class problem_4179 {
	static int ud[] = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N + 2][M + 2];
		for (char[] c : map)
			Arrays.fill(c, '.');

		Queue<Point> q = new LinkedList<>();
		Queue<Point> f = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				if (tmp.charAt(j) == 'J') {
					q.add(new Point(i + 1, j + 1));
				}

				if (tmp.charAt(j) == 'F') {
					f.add(new Point(i + 1, j + 1));
				}

				map[i + 1][j + 1] = tmp.charAt(j);
			}
		}

		simulation(map, N, M, q, f);
	}

	private static void print(char[][] map, int N, int M) {
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M + 2; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void simulation(char[][] map, int N, int M, Queue<Point> m, Queue<Point> f) {

		int time = 0;
		while (true) {
			time++;
			f = fire(f, N, M, map);
			m = move(m, N, M, map);

			if (m.size() == 1) {
				int nx = m.peek().x;
				int ny = m.peek().y;

				if (nx == 0 || nx >= N + 1 || ny == 0 || ny >= M + 1) {
					System.out.println(time);
					System.exit(0);
				}
			}

			if (m.isEmpty())
				break;

			//print(map, N, M);

		}
		System.out.println("IMPOSSIBLE");
	}

	private static Queue<Point> fire(Queue<Point> f, int N, int M, char[][] map) {
		Queue<Point> tmp = new LinkedList<>();

		boolean[][] visited = new boolean[N + 2][M + 2];

		while (!f.isEmpty()) {
			Point cur = f.poll();
			visited[cur.x][cur.y] = true;

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= N + 1 || ny < 0 || ny >= M + 1 || visited[nx][ny] || map[nx][ny] == '#'
						|| map[nx][ny] == 'F')
					continue;

				visited[nx][ny] = true;
				map[nx][ny] = 'F';
				tmp.add(new Point(nx, ny));
			}
		}

		return tmp;
	}

	private static Queue<Point> move(Queue<Point> m, int N, int M, char[][] map) {
		Queue<Point> tmp = new LinkedList<>();
		boolean[][] visited = new boolean[N + 2][M + 2];

		while (!m.isEmpty()) {
			Point cur = m.poll();
			visited[cur.x][cur.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= N + 2 || ny < 0 || ny >= M + 2 || visited[nx][ny] || map[nx][ny] == '#'
						|| map[nx][ny] == 'J' || map[nx][ny] == 'F')
					continue;

				if (nx == 0 || nx >= N + 1 || ny == 0 || ny >= M + 1) {
					tmp.clear();
					tmp.add(new Point(nx, ny));
					return tmp;
				}

				visited[nx][ny] = true;
				map[nx][ny] = 'J';
				tmp.add(new Point(nx, ny));

			}
		}

		return tmp;
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
