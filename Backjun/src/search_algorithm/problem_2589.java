package search_algorithm;

import java.util.*;
import java.io.*;

//º¸¹°¼¶

public class problem_2589 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = tmp.charAt(j);
		}

		simulation(map, N, M);
	}

	private static void simulation(char[][] map, int N, int M) {
		int answer  =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					int tmp = find_distance(map, i, j, N, M);
					answer = Math.max(tmp, answer);
				}
			}
		}
		
		System.out.println(answer);
	}

	private static int find_distance(char[][] map, int x, int y, int N, int M) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		int[][] board = new int[N][M];
		boolean [][] visited = new boolean[N][M];
		visited[x][y] = true;
		
		int big= 0;
		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 'W')
					continue;

				visited[nx][ny] = true;
				board[nx][ny] = board[cur.x][cur.y] + 1;
				big = Math.max(board[nx][ny], big);
				q.add(new Point(nx,ny));
			}
		}
		return big;
	}
	private static void print(int [][] board, int N , int M) {
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < M ; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
