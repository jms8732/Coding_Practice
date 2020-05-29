package samsung;

//인구 이동
import java.util.*;
import java.io.*;

public class problem_16234_1 {
	static int[][] country;
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };
	static int L, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		country = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simulation(N);
	}

	private static void simulation(int N) {
		List<List<Point>> union = new ArrayList<>();

		int count = 0;
		while (true) {
			boolean[][] visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						List<Point> tmp = new ArrayList<>();
						tmp.add(new Point(i, j));
						find_union(i, j, tmp, visited, N);
						if (tmp.size() != 1)
							union.add(tmp);
					}
				}
			}

			if (union.isEmpty())
				break;

			count++; // 인구 이동 횟수

			for (List<Point> un : union) {
				int size = un.size();
				int people = 0;
				for (Point p : un) {
					people += country[p.x][p.y];
				}

				int un_people = people / size;

				for (Point p : un) {
					country[p.x][p.y] = un_people;
				}
			}

			union.clear();
		}
		System.out.println(count);
	}

	private static void find_union(int x, int y, List<Point> union, boolean[][] visited, int N) {

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
				continue;

			if (L <= Math.abs(country[x][y] - country[nx][ny]) && Math.abs(country[x][y] - country[nx][ny]) <= R) {
				union.add(new Point(nx, ny));
				find_union(nx, ny, union, visited, N);
			}
		}
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
