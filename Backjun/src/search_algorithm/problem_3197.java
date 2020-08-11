package search_algorithm;

//백조의 호수
import java.util.*;
import java.io.*;

public class problem_3197 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] pool = new char[N][M];

		List<Point> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				if (line.charAt(j) == 'L')
					list.add(new Point(i, j));
				pool[i][j] = line.charAt(j);
			}
		}

		System.out.println(simulation(pool, N, M, list));
	}

	private static int simulation(char[][] pool, int N, int M, List<Point> list) {
		int days = 0;
		boolean[][] visited = new boolean[N][M];
		boolean[][] swan_visited = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		Queue<Point> swan = new LinkedList<>();

		swan.add(new Point(list.get(0).x,list.get(0).y));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (pool[i][j] == '.' || pool[i][j] == 'L') {
					q.add(new Point(i, j));
				}
			}
		}

		while (true) {
			swan = move_swan(pool, swan_visited, N, M, list.get(1).x, list.get(1).y, swan);
			if(swan == null)
				break;
			
			q = melting(q, pool, N, M, visited);
			days++;
		}
		return days;
	}

	private static Queue<Point> melting(Queue<Point> q, char[][] pool, int N, int M, boolean[][] visited) {
		Queue<Point> ret = new LinkedList<>();

		while (!q.isEmpty()) {
			Point cur = q.poll();
			visited[cur.x][cur.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				if (pool[nx][ny] == 'X') {
					ret.add(new Point(nx, ny));
					pool[nx][ny] = '.';
					continue;
				}

				q.add(new Point(nx, ny));
			}
		}

		return ret;
	}

	// 백조가 다른 백조에게 도달 할 수 있는 지 판단하는 메소드
	private static Queue<Point> move_swan(char[][] pool, boolean[][] visited, int N, int M, int endX, int endY,
			Queue<Point> swan) {
		Queue<Point> ret = new LinkedList<>();

		while (!swan.isEmpty()) {
			Point cur = swan.poll();
			visited[cur.x][cur.y] = true;
			if (cur.x == endX && cur.y == endY)
				return null;

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				if (pool[nx][ny] == 'X') {
					ret.add(new Point(nx, ny));
					continue;
				}
				swan.add(new Point(nx, ny));
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
