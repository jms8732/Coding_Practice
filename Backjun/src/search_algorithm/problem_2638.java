package search_algorithm;

/*
 * 치즈(DFS + BFS)
 * 치즈의 외각과 내부를 판단하기 위해서는 가장자리를 기준으로 하여 BFS 탐색을 진행한다
 * 가장자리를 기준으로 한 이유는 치즈를 가장자리에 둘 수 없기 때문이다.
 *
 */
import java.util.*;
import java.io.*;

public class problem_2638 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] cheeze = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				cheeze[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.print(calculateTime(N, M, cheeze));
	}

	private static int calculateTime(int N, int M, int[][] cheeze) {
		int time = 0;
		while (true) {
			if (isDisappearAll(cheeze))
				break;

			meltingCheeze(N, M, cheeze);
			//print(cheeze);
			time++;
		}

		return time;
	}

	private static void print(int[][] cheeze) {
		System.out.println();
		for (int[] i : cheeze) {
			for (int j : i)
				System.out.print(j + " ");
			System.out.println();
		}
	}

	private static void meltingCheeze(int N, int M, int[][] cheeze) {
		// 우선 치즈의 가장자리를 찾는다.
		boolean[][] outline = new boolean[N][M];
		Queue<Point> outlinePoint = checkOutline(N, M, outline, cheeze);

		Queue<Point> delete = new LinkedList<>();

		while (!outlinePoint.isEmpty()) {
			Point current = outlinePoint.poll();

			int count = 0;
			for (int i = 0; i < 4; i++) {
				int nx = current.x + ud[i];
				int ny = current.y + rl[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || cheeze[nx][ny] == 1)
					continue;

				if (outline[nx][ny])
					count++;
			}

			// 적어도 2면이 외각과 맞닿기 때문에 해당 좌표에 존재하는 치즈는 삭제
			if (count >= 2) {
				delete.add(new Point(current.x, current.y));
			}
		}

		while (!delete.isEmpty()) {
			Point cur = delete.poll();

			cheeze[cur.x][cur.y] = 0;
		}

	}

	private static Queue<Point> checkOutline(int N, int M, boolean[][] visited, int[][] cheeze) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		Queue<Point> ret = new LinkedList<>();
		while (!q.isEmpty()) {
			Point current = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + ud[i];
				int ny = current.y + rl[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
					continue;

				visited[nx][ny] = true;

				// 치즈의 외각 좌표
				if (cheeze[nx][ny] == 1) {
					ret.add(new Point(nx, ny));
					continue;
				}

				q.add(new Point(nx, ny));
			}
		}

		return ret;
	}

	// 치즈가 다 사라졌는 지 판단하는 메소드
	private static boolean isDisappearAll(int[][] cheeze) {
		for (int i[] : cheeze) {
			for (int j : i)
				if (j != 0)
					return false;
		}

		return true;
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
