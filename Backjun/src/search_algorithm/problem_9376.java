package search_algorithm;

/*
 * 탈옥
 * Deque를 이용하여 BFS를 진행한다.
 * 
 */
import java.util.*;
import java.io.*;

public class problem_9376 {
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			char[][] map = new char[R + 2][C + 2];
			fill(R, C, map);

			List<Point> prisoner = new ArrayList<>();
			for (int j = 1; j < R + 1; j++) {
				String temp = br.readLine();
				for (int k = 1; k < C + 1; k++) {
					if (temp.charAt(k - 1) == '$')
						prisoner.add(new Point(j, k, 0));
					map[j][k] = temp.charAt(k - 1);
				}
			}

			// print(map);
			exit(R, C, map, prisoner);
		}
	}

	private static void exit(int R, int C, char[][] map, List<Point> prisoner) {

		int[][] map1 = bfs(R, C, map, prisoner.get(0).x, prisoner.get(0).y);
		int[][] map2 = bfs(R, C, map, prisoner.get(1).x, prisoner.get(1).y);
		int [][] map3 = bfs(R,C,map,0,0);
		
		int answer = Integer.MAX_VALUE;
		for(int i =0 ; i < map.length ; i++) {
			for(int j =0 ; j < map[i].length ; j++) {
				if(map[i][j] != '*' && map1[i][j] != -1) {
					int res = map1[i][j] + map2[i][j] + map3[i][j];
					answer = Math.min(answer, map[i][j] == '#' ? res -2 : res);
				}
			}
		}
		
		System.out.println(answer);
	}

	private static int[][] bfs(int R, int C, char[][] map, int startX, int startY) {
		int[][] board = new int[R + 2][C + 2];

		for (int[] temp : board) {
			Arrays.fill(temp, -1);
		}

		Deque<Point> dq = new LinkedList<>();
		dq.add(new Point(startX, startY, 0));
		board[startX][startY] = 0;

		while (!dq.isEmpty()) {
			Point cur = dq.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];
				int cc = cur.c;

				if (nx <= -1 || nx >= R + 2 || ny <= -1 || ny >= C + 2)
					continue;

				if (map[nx][ny] == '*')
					continue;

				if (board[nx][ny] == -1) {
					if (map[nx][ny] == '.' || map[nx][ny] == '$') {
						board[nx][ny] = cc;
						dq.addFirst(new Point(nx, ny, cc));
					} else if (map[nx][ny] == '#') {
						board[nx][ny] = cc + 1;
						dq.addLast(new Point(nx, ny, cc + 1));
					}
				}
			}

		}

		return board;
	}

	private static void fill(int R, int C, char[][] map) {
		Arrays.fill(map[0], '.');
		Arrays.fill(map[R + 1], '.');

		for (int i = 1; i < R + 1; i++)
			map[i][0] = '.';

		for (int i = 1; i < R + 1; i++)
			map[i][C + 1] = '.';
	}

	private static void print(int[][] map) {
		System.out.println();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static class Point {
		int x, y, c;

		public Point(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
