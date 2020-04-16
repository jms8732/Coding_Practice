package search_algorithm;

//토마토
import java.util.*;
import java.io.*;

public class problem_7569 {
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };
	static int tb[] = { 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int H = Integer.parseInt(st.nextToken());

		int[][][] tomato = new int[N][M][H];

		Queue<Point> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][H];

		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < M; j++) {
					String tmp = st.nextToken();
					if (tmp.equals("1")) {
						q.add(new Point(i, j, h));
					}
					tomato[i][j][h] = Integer.parseInt(tmp);
				}
			}
		}

		int day = -1;
		while (!q.isEmpty()) {
			q = simulation(tomato, visited, N, M, H, q);
			//print(tomato, N, M, H);
			day++;
		}

		if (isFinish(tomato, N, M, H))
			System.out.println(day);
		else
			System.out.println(-1);
	}

	private static Queue<Point> simulation(int[][][] tomato, boolean[][][] visited, int N, int M, int H,
			Queue<Point> q) {

		Queue<Point> ans = new LinkedList<>();
		while (!q.isEmpty()) {
			Point cur = q.poll();

			// 상하좌우
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				// 배열 범위 밖이거나 이미 방문한 곳일 경우
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][cur.h] || tomato[nx][ny][cur.h] == -1 
						|| tomato[nx][ny][cur.h]== 1 )
					continue;

				visited[nx][ny][cur.h] = true;
				tomato[nx][ny][cur.h] = 1;
				ans.add(new Point(nx, ny, cur.h));
			}

			// 위 아래
			for (int i = 0; i < 2; i++) {
				int nh = cur.h + tb[i];

				// 배열 범위 밖이거나 이미 방문한 곳인 경우
				if (nh < 0 || nh >= H || visited[cur.x][cur.y][nh] || tomato[cur.x][cur.y][nh] == -1
						|| tomato[cur.x][cur.y][nh]== 1)
					continue;

				visited[cur.x][cur.y][nh] = true;
				tomato[cur.x][cur.y][nh] = 1;
				ans.add(new Point(cur.x, cur.y, nh));

			}
		}

		return ans;
	}

	private static void print(int[][][] tomato, int N, int M, int H) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					System.out.print(tomato[j][k][i] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	private static boolean isFinish(int[][][] tomato, int N, int M, int H) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (tomato[j][k][i] == 0)
						return false;
				}
			}
		}

		return true;
	}

	private static class Point {
		int x, y, h;

		public Point(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}
}
