package search_algorithm;

//통나무 옮기기
import java.util.*;
import java.io.*;

public class problem_1938 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];

		List<Point> b = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();

			for (int j = 0; j < N; j++) {
				if (temp.charAt(j) == 'B')
					b.add(new Point(i, j));
				map[i][j] = temp.charAt(j);
			}
		}

		simulation(map, N, b);
	}

	private static void simulation(char[][] map, int N, List<Point> b) {
		Queue<Node> q = new LinkedList<>();
		boolean[][][] visited = new boolean[2][N][N];
		for (Point p : b) {
			visited[0][p.x][p.y] = true;
		}

		q.add(new Node(b, 0, 0));

		int answer = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			//print(cur.b, cur.c, map);
			if (finish(cur.b, map)) {
				if (answer == 0)
					answer = cur.c;
				else
					answer = Math.min(cur.c, answer);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int count = 0;
				boolean check = false;
				for (Point p : cur.b) {
					int nx = p.x + ud[i];
					int ny = p.y + rl[i];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == '1') {
						check = true;
						break;
					}

					if (visited[cur.status][nx][ny])
						count++;
				}

				if (count == 3 || check)
					continue;

				List<Point> temp = new ArrayList<>();
				for (Point p : cur.b) {
					visited[cur.status][p.x + ud[i]][p.y + rl[i]] = true;
					temp.add(new Point(p.x + ud[i], p.y + rl[i]));
				}

				q.add(new Node(temp, cur.c + 1, cur.status));
			}

			Node tmp = rotate(cur.b, N, cur.c, cur.status, map, visited);

			if (tmp != null)
				q.add(tmp);
		}

		System.out.println(answer);
	}

	private static void print(List<Point> list, int c, char[][] map) {
		System.out.println("Count : " + c);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				boolean check = false;
				for (Point p : list) {
					if (p.x == i && p.y == j) {
						System.out.print("C");
						check = true;
						break;
					}
				}

				if (!check)
					System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean finish(List<Point> list, char[][] map) {
		int count = 0;
		for (Point p : list) {
			if (map[p.x][p.y] == 'E')
				count++;
		}

		if (count == 3)
			return true;

		return false;
	}

	private static Node rotate(List<Point> temp, int N, int c, int status, char[][] map, boolean[][][] visited) {
		Node ret = null;
		int pivot_x = temp.get(1).x;
		int pivot_y = temp.get(1).y;

		for (int i = pivot_x - 1; i < pivot_x + 2; i++) {
			for (int j = pivot_y - 1; j < pivot_y + 2; j++) {
				if (i < 0 || i >= N || j < 0 || j >= N)
					return null;

				for (Point p : temp) {
					if (map[i][j] == '1' && (i != p.x && j != p.y))
						return null;
				}
			}
		}

		List<Point> tmp = new ArrayList<>();
		for (Point p : temp) {
			tmp.add(new Point(p.x - pivot_x, p.y - pivot_y));
		}

		int count = 0;
		for (Point p : tmp) {
			int nx = p.y + pivot_x;
			int ny = p.x + pivot_y;

			if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == '1')
				return null;

			if (visited[(status + 1) % 2][nx][ny])
				count++;
		}

		if (count == 3)
			return null;

		for (Point p : tmp) {
			int nx = p.y + pivot_x;
			int ny = p.x + pivot_y;

			p.x = nx;
			p.y = ny;

			visited[(status + 1) % 2][p.x][p.y] = true;
		}
		

		ret = new Node(tmp, c + 1, (status + 1) % 2);
		return ret;
	}

	private static class Node {
		List<Point> b;
		int c, status;

		public Node(List<Point> b, int c, int s) {
			this.c = c;
			this.status = s;
			this.b = new ArrayList<>();
			for (Point p : b) {
				this.b.add(new Point(p.x, p.y));
			}
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
