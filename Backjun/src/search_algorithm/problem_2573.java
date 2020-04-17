package search_algorithm;

//빙산 1:30 -> 1:04 (26분 소요)

import java.util.*;
import java.io.*;

public class problem_2573 {
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] ice = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simulation(ice, N, M);
	}

	private static void simulation(int[][] ice, int N, int M) {
		List<List<Point>> totalIce = new ArrayList<>();

		int year = 0;
		while (true) {
			searchIce(totalIce, ice, N, M);

			if (totalIce.size() >= 2) {
				break;
			}
			
			if(totalIce.isEmpty()) {
				System.out.println(0);
				System.exit(0);;
			}

			ice = meltingIce(totalIce.get(0), ice, N, M);
		//	print(ice);
			year++;
			totalIce.clear();
		}

		System.out.println(year);
	}
	
	private static void print(int[][] ice) {
		for(int i =0 ; i < ice.length ; i++) {
			for(int j =0 ; j < ice[i].length ; j++) {
				System.out.print(ice[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int [][] meltingIce(List<Point> list, int[][] ice, int N, int M) {
		
		int [][] tmp = new int[N][M];
		
		for (Point cur : list) {
			int zero_count = 0;

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				// 배열의 범위를 벗어나거나 0이 아닌 부분을 만날 경우
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || ice[nx][ny] != 0)
					continue;

				zero_count++;
			}

			int cur_value = ice[cur.x][cur.y];

			cur_value -= zero_count;

			if (cur_value < 0)
				cur_value = 0;

			tmp[cur.x][cur.y] = cur_value;
		}
		
		return tmp;
	}

	private static void searchIce(List<List<Point>> totalIce, int[][] ice, int N, int M) {
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && ice[i][j] != 0) {
					List<Point> tmp = new ArrayList<>();
					tmp.add(new Point(i, j));
					search(i, j, ice, visited, N, M, tmp);

					totalIce.add(tmp);
				}
			}
		}
	}

	// DFS를 이용하여 연결된 빙산들을 탐색
	private static void search(int x, int y, int[][] ice, boolean[][] visited, int N, int M, List<Point> tmp) {

		for (int i = 0; i < 4; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || ice[nx][ny] == 0)
				continue;

			tmp.add(new Point(nx, ny));
			visited[nx][ny] = true;
			search(nx, ny, ice, visited, N, M, tmp);
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
