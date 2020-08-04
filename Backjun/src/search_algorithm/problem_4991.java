package search_algorithm;

//로봇 청소기
import java.util.*;
import java.io.*;

public class problem_4991 {
	static int N, M;
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			if(N == 0 && M == 0)
				break;
			
			char[][] map = new char[M][N];
			int startX = 0, startY = 0;
			List<Point> dust = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				String temp = br.readLine();
				for (int j = 0; j < N; j++) {
					if (temp.charAt(j) == 'o') {
						startX = i;
						startY = j;
					}
					if (temp.charAt(j) == '*')
						dust.add(new Point(i, j));

					map[i][j] = temp.charAt(j);
				}
			}

			bfs(map, startX, startY, dust);
		}
	}

	private static void bfs(char[][] map, int startX, int startY, List<Point> dust) {
		Queue<Point> q = new LinkedList<>();
		boolean[][][] visited = new boolean[1 << dust.size()][M][N];
		q.add(new Point(startX, startY, 0, 0));
		visited[0][startX][startY] = true;

		int answer = -1;
		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (Integer.bitCount(cur.d) == dust.size()) {
				if (answer == -1)
					answer = cur.c;
				else
					answer = Math.min(cur.c, answer);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				// 배열의 범위 밖이거나 벽이 존재할 경우
				if (nx < 0 || nx >= M || ny < 0 || ny >= N || map[nx][ny] == 'x' || visited[cur.d][nx][ny])
					continue;

				int cur_dust = cur.d;
				if (map[nx][ny] == '*') {
					for (int j = 0; j < dust.size(); j++) {
						Point temp = dust.get(j);

						if (temp.x == nx && temp.y == ny) {
							cur_dust |= 1 << j;
							break;
						}
					}
				}

				visited[cur_dust][nx][ny] = true;
				q.add(new Point(nx, ny, cur_dust, cur.c + 1));
			}
		}

		System.out.println(answer);
	}

	private static class Point {
		int x, y, d, c;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int d, int c) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}
	}
}
