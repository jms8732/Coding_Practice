package search_algorithm;

//Å»¿Á
import java.util.*;
import java.io.*;

public class problem_9376 {
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			char[][] jail = new char[N + 2][M + 2];

			List<Point> prisoner = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				String temp = br.readLine();
				for (int k = 0; k < M; k++) {
					if (temp.charAt(k) == '$') {
						prisoner.add(new Point(j + 1, k + 1, 0));
					}
					jail[j + 1][k + 1] = temp.charAt(k);
				}
			}

			bfs(jail, N + 2, M + 2, prisoner);
		}
	}

	private static void bfs(char[][] jail, int N, int M, List<Point> prisoner) {

		int[][] door1 = bfs(jail, N, M, 0, 0);

		int x1 = prisoner.get(0).x;
		int y1 = prisoner.get(0).y;

		int x2 = prisoner.get(1).x;
		int y2 = prisoner.get(1).y;

		int[][] door2 = bfs(jail, N, M, x1, y1);
		int[][] door3 = bfs(jail, N, M, x2, y2);

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (jail[i][j] != '*') {
					int result = door1[i][j] + door2[i][j] + door3[i][j];

					min = Math.min(min, jail[i][j] == '#' ? result - 2 : result);
				}
			}
		}

		System.out.println(min);
	}

	private static int[][] bfs(char[][] jail, int N, int M, int x, int y) {
		int[][] door = new int[N][M];

		for (int[] d : door) {
			Arrays.fill(d, -1);
		}

		Deque<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 0));
		door[x][y] = 0;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];
				int door_count = cur.door_count;

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || jail[nx][ny] == '*')
					continue;

				if (door[nx][ny] > -1)
					continue;

				door[nx][ny] = door_count;
				if (jail[nx][ny] == '#') {
					door[nx][ny]++;
					q.addLast(new Point(nx, ny,door[nx][ny]));
				} else {
					door[nx][ny] = door_count;
					q.addFirst(new Point(nx, ny, door[nx][ny]));
				}
			}
		}

		return door;
	}

	private static void print(int[][] jail) {
		for (int i = 0; i < jail.length; i++) {
			for (int j = 0; j < jail[i].length; j++) {
				System.out.print(jail[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static class Point {
		int x, y, door_count;

		public Point(int x, int y, int dc) {
			this.x = x;
			this.y = y;
			this.door_count = dc;
		}
	}

}
