package samsung;

import java.util.*;

//배열 돌리기 테스트
public class test {
	public static void main(String[] args) {
		int[][] map = { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };

		print(map);
		System.out.println();
		int x = 2, y = 0;

		for (int i = 0; i < 3; i++) {
			// circleRotation(x, y, map);
			reverseCircleRotation(x, y, map);
			print(map);
			System.out.println();
		}

	}

	private static void reverseCircleRotation(int x, int y, int[][] map) {
		// up to down
		while (true) {
			x -= 1;
			int px = x + 1;

			if (x < 0) {
				x += 1;
				break;
			}
			map[px][y] = map[x][y];
		}
		

		// left to right
		while (true) {
			y = y + 1;
			int py = y - 1;

			if (y >= 3) {
				y -= 1;
				break;
			}

			map[x][py] = map[x][y];
		}

		
		// down to up
		while (true) {
			x = x + 1;
			int px = x - 1;
			if (x >= 3) {
				x -= 1;
				break;
			}
			map[px][y] = map[x][y];
		}

		// right to left
		while (true) {
			y -= 1;
			int py = y + 1;
			if (y < 0) {
				y += 1;
				break;
			}
			map[x][py] = map[x][y];
		}
		
		map[2][0] =0; 
	}

	private static void circleRotation(int x, int y, int[][] map) {

		// down to up
		while (true) {
			x = x + 1;
			int px = x - 1;
			if (x >= 3) {
				x -= 1;
				break;
			}
			map[px][y] = map[x][y];
		}
		map[0][0] = 0;

		// left to right
		while (true) {
			y = y + 1;
			int py = y - 1;

			if (y >= 3) {
				y -= 1;
				break;
			}

			map[x][py] = map[x][y];
		}

		// up to down
		while (true) {
			x -= 1;
			int px = x + 1;

			if (x < 0) {
				x += 1;
				break;
			}
			map[px][y] = map[x][y];
		}

		// right to left
		while (true) {
			y -= 1;
			int py = y + 1;
			if (y < 0) {
				y += 1;
				break;
			}
			map[x][py] = map[x][y];
		}

	}

	private static void print(int[][] map) {
		for (int i[] : map) {
			for (int tmp : i)
				System.out.print(tmp + " ");
			System.out.println();
		}
	}
}
