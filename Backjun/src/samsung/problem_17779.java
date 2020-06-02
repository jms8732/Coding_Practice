package samsung;

//게리맨더링 2
import java.util.*;
import java.io.*;

public class problem_17779 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simulation(N, map);
	}

	private static void simulation(int N, int[][] map) {
		int answer = Integer.MAX_VALUE;
		List<Node> tmp = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp = d_list(N, i, j);
				for (Node t : tmp) {

					int[][] dist = new int[N][N];
					int result = divided_dist(map, dist, N, i, j, t.d1, t.d2);
					answer = Math.min(result, answer);
				}
			}
		}

		System.out.println(answer);
	}

	private static List<Node> d_list(int N, int x, int y) {
		List<Node> d_list = new ArrayList<>();
		for (int i = 1; 0 <= y - i && y - i < y; i++) {
			for (int j = 1; y <= j + y && j + y < N; j++) {
				if (x < x + i + j && x + i + j <= N - 1) {
					d_list.add(new Node(i, j));
				}
			}
		}
		return d_list;
	}

	private static int divided_dist(int[][] map, int[][] dist, int N, int x, int y, int d1, int d2) {
		// 5번 선거구
		set_five_dist(dist, N, x, y, d1, d2);

		set_one_dist(dist, N, x, y, d1, d2);
		set_two_dist(dist, N, x, y, d1, d2);
		set_three_dist(dist, N, x, y, d1, d2);
		set_four_dist(dist, N, x, y, d1, d2);

		boolean[][] visited = new boolean[N][N];

		int small = Integer.MAX_VALUE, big = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					int num = dist[i][j];
					int val = people(i, j, visited, N, dist,map, num);
					small = Math.min(small, val);
					big = Math.max(big, val);

				}
			}
		}

		return big - small;

	}

	private static int people(int x, int y, boolean[][] visited, int N,int dist[][], int[][] map, int num) {
		visited[x][y] = true;

		int val = map[x][y];
		for (int i = 0; i < 4; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] ||  dist[nx][ny] != num)
				continue;

			val += people(nx, ny, visited, N,dist, map, num);
		}

		return val;
	}

	private static void set_four_dist(int[][] dist, int N, int x, int y, int d1, int d2) {
		for (int i = x + d2; i < N; i++) {
			for (int j = y - d1 + d2; j < N; j++)
				if (dist[i][j] == 0)
					dist[i][j] = 4;
		}
	}

	private static void set_three_dist(int[][] dist, int N, int x, int y, int d1, int d2) {
		for (int i = x + d1; i < N; i++) {
			for (int j = 0; j < y - d1 + d2; j++)
				if (dist[i][j] == 0)
					dist[i][j] = 3;
		}
	}

	private static void set_two_dist(int[][] dist, int N, int x, int y, int d1, int d2) {
		for (int i = 0; i <= x + d2; i++) {
			for (int j = y + 1; j < N; j++) {
				if (dist[i][j] == 0)
					dist[i][j] = 2;
			}
		}
	}

	private static void set_one_dist(int[][] dist, int N, int x, int y, int d1, int d2) {
		for (int i = 0; i < x + d1; i++) {
			for (int j = 0; j <= y; j++) {
				if (dist[i][j] == 0)
					dist[i][j] = 1;
			}
		}
	}

	private static void set_five_dist(int[][] dist, int N, int x, int y, int d1, int d2) {
		dist[x][y] = 5;
		int start_x = x, start_y = y;

		for (int i = 0; i < d1; i++) {
			int nx = x + 1;
			int ny = y - 1;

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				break;

			dist[nx][ny] = 5;

			x = nx;
			y = ny;
		}

		x = start_x;
		y = start_y;
		for (int i = 0; i < d2; i++) {
			int nx = x + 1;
			int ny = y + 1;

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				break;
			dist[nx][ny] = 5;

			x = nx;
			y = ny;
		}

		x = start_x + d1;
		y = start_y - d1;
		for (int i = 0; i < d2; i++) {
			int nx = x + 1;
			int ny = y + 1;

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				break;

			dist[nx][ny] = 5;

			x = nx;
			y = ny;
		}

		x = start_x + d2;
		y = start_y + d2;
		for (int i = 0; i < d1; i++) {
			int nx = x + 1;
			int ny = y - 1;

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				break;

			dist[nx][ny] = 5;
			x = nx;
			y = ny;
		}

		fill(dist, N);
	}

	private static void fill(int[][] dist, int N) {
		boolean s = false;
		for (int i = 0; i < N; i++) {
			int start = 0, end = 0;
			for (int j = 0; j < N; j++) {
				if (!s && dist[i][j] == 5) {
					start = j;
					s = true;
				}

				if (s && dist[i][j] == 5) {
					end = j;

				}
			}
			Arrays.fill(dist[i], start, end, 5);
			s = false;

		}

	}

	private static void print(int[][] map, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static class Node {
		int d1, d2;

		public Node(int d1, int d2) {
			this.d1 = d1;
			this.d2 = d2;
		}
	}
}
