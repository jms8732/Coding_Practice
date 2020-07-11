package programmers2;

import java.util.*;

public class problem_31 {
	static char[][] phone = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' }, { '*', '0', '#' } };
	static int leftX = 3, leftY = 0;
	static int rightX = 3, rightY = 2;
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String h = "right";

		System.out.println(solution(numbers, h));
	}

	public static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numbers.length; i++) {
			int n = numbers[i];
			sb.append(find_hand(n, hand));
		}

		return sb.toString();
	}

	private static String find_hand(int n, String h) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(leftX, leftY));

		int x = 0, y = 0;
		boolean[][] visited = new boolean[4][3];
		int[][] board = new int[4][3];
		int left = 0;

		visited[leftX][leftY] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (phone[cur.x][cur.y] == n + '0') {
				left = board[cur.x][cur.y];
				x = cur.x;
				y = cur.y;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 3 || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				board[nx][ny] = board[cur.x][cur.y] + 1;
				q.add(new Point(nx, ny));
			}
		}
		if(n == 1 || n == 4 || n == 7) {
			leftX = x;
			leftY = y;
			
			return "L";
		}
		
		q.clear();

		q.add(new Point(rightX, rightY));
		visited = new boolean[4][3];
		board = new int[4][3];
		int right = 0;

		visited[rightX][rightY] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (phone[cur.x][cur.y] == n + '0') {
				right = board[cur.x][cur.y];
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= 4 || ny < 0 || ny >= 3 || visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				board[nx][ny] = board[cur.x][cur.y] + 1;
				q.add(new Point(nx, ny));
			}
		}

		if(n == 3|| n ==6 || n==9) {
			rightX= x;
			rightY = y;
			return "R";
		}
		
		if (left < right) {
			leftX = x;
			leftY = y;
			return "L";
		} else if (left == right) {
			if (h.equals("left")) {
				leftX = x;
				leftY = y;

				return "L";
			} else {
				rightX = x;
				rightY = y;
				return "R";
			}
		}

		rightX = x;
		rightY = y;
		return "R";

	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
