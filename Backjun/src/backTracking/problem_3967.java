package backTracking;

//매직 스타
import java.util.*;
import java.awt.Point;
import java.io.*;

public class problem_3967 {
	static int[][][] p = { { { 0, 4 }, { 1, 3 }, { 2, 2 }, { 3, 1 } }, { { 0, 4 }, { 1, 5 }, { 2, 6 }, { 3, 7 } },
			{ { 1, 1 }, { 1, 3 }, { 1, 5 }, { 1, 7 } }, { { 3, 1 }, { 3, 3 }, { 3, 5 }, { 3, 7 } },
			{ { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 } }, { { 1, 7 }, { 2, 6 }, { 3, 5 }, { 4, 4 } }

	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] star = new char[5][9];
		boolean[] visited = new boolean[12];

		List<Point> list = new ArrayList<>();
		for (int i = 0; i < star.length; i++) {
			String temp = br.readLine();
			for (int j = 0; j < star[i].length; j++) {
				if (temp.charAt(j) >= 'A' && temp.charAt(j) <= 'L') {
					visited[temp.charAt(j) - 'A'] = true;
				}

				if (temp.charAt(j) == 'x')
					list.add(new Point(i, j));

				star[i][j] = temp.charAt(j);
			}
		}

		backtracking(star, 0, visited, list);
	}

	private static void backtracking(char[][] star, int n, boolean[] visited, List<Point> list) {
		if (finish(visited)) {
			// x지점에 다 넣은 경우
			if (is_magic_star(star)) {
				for (int i = 0; i < star.length; i++) {
					for (int j = 0; j < star[i].length; j++) {
						System.out.print(star[i][j]);
					}
					System.out.println();
				}
				System.exit(0);
			}
			return;
		}

		for (int j = 'A'; j <= 'L'; j++) {
			if (!visited[j - 'A']) {
				int x=  list.get(n).x;
				int y = list.get(n).y;
				// A~L중 선택되지 않은 알파벳
				visited[j - 'A'] = true;
				star[x][y] = (char) j;
				backtracking(star, n + 1, visited, list);
				visited[j - 'A'] = false;
				star[x][y] = 'x';
			}
		}
	}

	private static void copyArray(char[][] src, char[][] dest) {
		int idx = 0;

		for (char[] s : src) {
			System.arraycopy(src, 0, dest[idx++], 0, s.length);
		}
	}

	private static void print(char[][] star) {
		for (int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[i].length; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean is_magic_star(char[][] star) {
		for (int i = 0; i < p.length; i++) {
			int sum = 4;
			for (int j = 0; j < p[i].length; j++) {
				sum += star[p[i][j][0]][p[i][j][1]] - 'A';
			}

			if (sum != 26)
				return false;
		}
		return true;
	}

	private static boolean finish(boolean[] visited) {
		for (int i = 0; i < visited.length; i++)
			if (!visited[i])
				return false;
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
