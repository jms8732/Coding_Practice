package others;

/*
 * 화산쇄설류
 * 화산이 있는 곳은 시간이 0, 그 외의 시간은 문제에서 제공한 수식으로 계산한다.
 */
import java.util.*;
import java.io.*;

public class problem_16569 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		Volcano[][] vol = new Volcano[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int height = Integer.parseInt(st.nextToken());

				vol[i][j] = new Volcano(height, Integer.MAX_VALUE);
			}
		}

		// x,y 지점의 화산을 기준으로 최소 시간을 구한다.
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int t = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if (x == j && k == y)
						vol[j][k].time = 0; //화산이 있는 곳은 시간이 0
					else {
						int lamd = Math.abs(x - j) + Math.abs(y - k);
						vol[j][k].time = Math.min(vol[j][k].time, t + lamd);
					}
				}
			}
		}

		//print(vol);
		simulation(X - 1, Y - 1, M, N, vol);
	}

	private static void print(Volcano[][] vol) {
		System.out.println();
		for (int i = 0; i < vol.length; i++) {
			for (int j = 0; j < vol[i].length; j++) {

				System.out.print(vol[i][j].time + " ");
			}
			System.out.println();
		}
	}

	private static void simulation(int x, int y, int m, int n, Volcano[][] vol) {
		int currentTime = 1;
		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };

		boolean[][] visited = new boolean[m][n];

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[x][y] = true;

		int ansTime = 0, ansHeight = vol[x][y].height;

		while (!q.isEmpty()) {
			Queue<Point> temp = new LinkedList<>(q);
			q.clear();
			while (!temp.isEmpty()) {
				Point cur = temp.poll();

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + ud[i];
					int ny = cur.y + rl[i];

					// 배열을 벗어난 경우
					if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny])
						continue;

					if (vol[nx][ny].time > currentTime) {
						// 화산쇄설류가 덮기 전일 경우
						if (ansHeight < vol[nx][ny].height) {
							ansHeight = vol[nx][ny].height;
							ansTime = currentTime;
						}
						visited[nx][ny] = true;
						q.add(new Point(nx, ny));
					}
				}
			}

			currentTime++; // 시간 증가
		}

		System.out.println(ansHeight + " " + ansTime);
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static class Volcano {
		int height, time;

		public Volcano(int h, int t) {
			this.height = h;
			this.time = t;
		}
	}
}
