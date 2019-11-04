package rotation;

import java.util.*;

public class problem_16926 {
	static int[][] array;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int R = scanner.nextInt();

		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				array[i][j] = scanner.nextInt();
			}
		}
		rotationArray(N, M, R);
		printArray();
	}

	static void rotationArray(int N, int M, int R) {
		for (int i = 0; i < R; i++) {
			int xStart = 0;
			int yStart = 0;
			int s = 0;
			int statusX = 0;
			int statusY = 0;
			int tmpN = N;
			int tmpM = M;
			int[][] tmpArray = new int[tmpN][tmpM];
			do {
				do {

					int nx = 0, ny = 0;
					if (xStart == s && yStart == s) {
						statusX = 1;
						statusY = 0;
					} else if (xStart == tmpN - 1 && yStart == s) {
						statusX = 0;
						statusY = 1;
					} else if (xStart == tmpN - 1 && yStart == tmpM - 1) {
						statusX = -1;
						statusY = 0;
					} else if (xStart == s && yStart == tmpM - 1) {
						statusX = 0;
						statusY = -1;
					}
					nx = xStart + statusX;
					ny = yStart + statusY;
					tmpArray[nx][ny] = array[xStart][yStart];
					xStart = nx;
					yStart = ny;
				} while (xStart != s || yStart != s);
				tmpN = tmpN - 1;
				tmpM = tmpM - 1;
				xStart += 1;
				yStart += 1;
				s = xStart;
			} while (tmpN != xStart && tmpM != yStart);
			array = tmpArray;
		}
	}

	static void printArray() {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
