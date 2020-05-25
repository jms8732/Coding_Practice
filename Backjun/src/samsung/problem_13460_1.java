package samsung;

//구슬 탈출 2
import java.util.*;
import java.io.*;

public class problem_13460_1 {
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
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}

		simulation(map, N, M);
	}

	private static void simulation(char[][] map, int N, int M) {
		Queue<Point> q = new LinkedList<>();
		boolean[][][][] visited = new boolean[N][M][N][M];

		int rx = 0, ry = 0, bx = 0, by = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					bx = i;
					by = j;
					map[i][j] = '.';
				}
			}
		}

		q.add(new Point(rx, ry, bx, by, 0));
		visited[rx][ry][bx][by] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			// print(cur, map);
			for (int i = 0; i < 4; i++) {
				if (i == 0 || i == 2)
					move_updown(visited, map, cur, q, N, M, i);
				else
					move_leftright(visited, map, cur, q, N, M, i);
			}
		}
		System.out.println(-1);
	}


	private static void print(Point cur, char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (cur.rx == i && cur.ry == j)
					System.out.print('R');
				else if (cur.bx == i && cur.by == j)
					System.out.print('B');
				else
					System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void move_leftright(boolean[][][][] visited, char[][] map, Point cur, Queue<Point> q,
			int N, int M, int dir) {
		int cur_rx = cur.rx, cur_ry = cur.ry, cur_bx = cur.bx, cur_by = cur.by;

		int cur_count = cur.count;
		
		boolean escape_r = false, escape_b = false;
		// 빨간색 공 굴리기
		while (true) {
			cur_ry += rl[dir];

			if (map[cur_rx][cur_ry] == 'O') {
				escape_r = true;
				break;
			}

			if (map[cur_rx][cur_ry] == '#') {
				cur_ry -= rl[dir];
				break;
			}
		}

		// 파란색 공 굴리기
		while (true) {
			cur_by += rl[dir];

			if (map[cur_bx][cur_by] == 'O') {
				escape_b = true;
				break;
			}

			if (map[cur_bx][cur_by] == '#') {
				cur_by -= rl[dir];
				break;
			}
		}

		// 만약 공의 x좌표가 같은 경우
		if (cur_rx == cur_bx && cur_ry == cur_by) {
			int r_dis = Math.abs(cur_ry - cur.ry);
			int b_dis = Math.abs(cur_by - cur.by);

			if (r_dis < b_dis)
				cur_by -= rl[dir];
			else
				cur_ry -= rl[dir];
		}

		// 해당 좌표 아직 방문하지 않은 경우
		if (visited[cur_rx][cur_ry][cur_bx][cur_by] || escape_b)
			return;

		cur_count += 1;

		if (escape_r && cur_count <= 10) {
			System.out.println(cur_count);
			System.exit(0);
		}

		if (cur_count > 10) {
			System.out.println(-1);
			System.exit(0);
		}

		visited[cur_rx][cur_ry][cur_bx][cur_by] = true;
		q.add(new Point(cur_rx, cur_ry, cur_bx, cur_by,cur_count));
	}

	private static void move_updown(boolean[][][][] visited, char[][] map, Point cur, Queue<Point> q,
			int N, int M, int dir) {
		int cur_rx = cur.rx, cur_ry = cur.ry, cur_bx = cur.bx, cur_by = cur.by;
		int cur_count = cur.count;
		
		boolean escape_r = false, escape_b = false;

		// 빨간색 공 굴리기
		while (true) {
			cur_rx += ud[dir];

			if (map[cur_rx][cur_ry] == 'O') {
				escape_r = true;
				break;
			}

			if (map[cur_rx][cur_ry] == '#') {
				cur_rx -= ud[dir];
				break;
			}
		}

		// 파란색 공 굴리기
		while (true) {
			cur_bx += ud[dir];

			if (map[cur_bx][cur_by] == 'O') {
				escape_b = true;
				break;
			}

			if (map[cur_bx][cur_by] == '#') {
				cur_bx -= ud[dir];
				break;
			}
		}

		// 만약 공의 y좌표가 같은 경우
		if (cur_ry == cur_by && cur_rx == cur_bx) {
			int r_dis = Math.abs(cur_rx - cur.rx);
			int b_dis = Math.abs(cur_bx - cur.bx);

			if (r_dis < b_dis)
				cur_bx -= ud[dir];
			else
				cur_rx -= ud[dir];
		}

		// 해당 좌표 아직 방문하지 않은 경우와 파란색 구슬이 구멍을 통해 떨어진 경우
		if (visited[cur_rx][cur_ry][cur_bx][cur_by] || escape_b)
			return;

		cur_count += 1;
		
		if (escape_r && cur_count <= 10) {
			System.out.println(cur_count);
			System.exit(0);
		}

		if (cur_count > 10) {
			System.out.println(-1);
			System.exit(0);
		}

		visited[cur_rx][cur_ry][cur_bx][cur_by] = true;
		q.add(new Point(cur_rx, cur_ry, cur_bx, cur_by,cur_count));
	}

	private static class Point {
		int rx, ry, bx, by;
		int count = 0;

		public Point(int rx, int ry, int bx, int by, int c) {
			this.rx = rx;
			this.by = by;
			this.ry = ry;
			this.bx = bx;
			this.count = c;
		}
	}
}
