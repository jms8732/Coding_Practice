package search_algorithm;

//บา
import java.util.*;
import java.io.*;

public class problem_5427 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jms8732\\Desktop\\F.in"));
		int tc = Integer.parseInt(br.readLine());

		StringTokenizer st = null;

		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			int startX = 0, startY = 0;

			Queue<Point> fire = new LinkedList<>();
			char[][] building = new char[h+2][w+2];

			for (char[] c : building)
				Arrays.fill(c, '.');

			for (int j = 1; j <= h; j++) {
				String tmp = br.readLine();
				for (int k = 0; k < w; k++) {
					if (tmp.charAt(k) == '@') {
						startX = j;
						startY = k + 1;
					} else if (tmp.charAt(k) == '*') {
						fire.add(new Point(j, k + 1));
					}
					building[j][k + 1] = tmp.charAt(k);
				}
			}

			escape(building, w+2, h+2, startX, startY, fire);
		}
	}

	private static void escape(char[][] building, int w, int h, int startX, int startY, Queue<Point> fire) {
		Queue<Point> move = new LinkedList<>();

		boolean[][] visited = new boolean[h][w];
		visited[startX][startY] = true;
		move.add(new Point(startX, startY));

		int time = 0;
		boolean possible = false;
		while (!move.isEmpty()) {

			fire = burnning(w, h, fire, building);
			move = move(w, h, move, visited, building);

			if (!move.isEmpty() && move.peek().x == -1 && move.peek().y == -1) {
				possible = true;
				break;
			}
			time++;
		}

		if (possible)
			System.out.println(time);
		else
			System.out.println("IMPOSSIBLE");
	}

	private static Queue<Point> move(int w, int h, Queue<Point> move, boolean[][] visited, char[][] building) {
		Queue<Point> tmp = new LinkedList<>();

		while (!move.isEmpty()) {
			Point cur = move.poll();

			if (cur.x == 0 || cur.x == h - 1 || cur.y == 0 || cur.y == w - 1) {
				tmp.clear();
				tmp.add(new Point(-1, -1));
				return tmp;
			}

			building[cur.x][cur.y] = '.';

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= h || ny < 0 || ny >= w)
					continue;

				if (visited[nx][ny])
					continue;

				if (building[nx][ny] == '*' || building[nx][ny] == '#')
					continue;

				visited[nx][ny] = true;
				building[nx][ny] = '@';
				tmp.add(new Point(nx, ny));
			}
		}

		return tmp;
	}

	private static Queue<Point> burnning(int w, int h, Queue<Point> fire, char[][] building) {
		Queue<Point> tmp = new LinkedList<>();

		while (!fire.isEmpty()) {
			Point cur = fire.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx <= 0 || nx >= h-1 || ny <= 0 || ny >= w-1)
					continue;

				if (building[nx][ny] == '*' || building[nx][ny] == '#')
					continue;

				building[nx][ny] = '*';
				tmp.add(new Point(nx, ny));
			}
		}

		return tmp;
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
