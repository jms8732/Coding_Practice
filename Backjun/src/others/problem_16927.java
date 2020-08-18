package others;

//배열 돌리기 2
import java.util.*;
import java.io.*;

public class problem_16927 {
	static int ud[] = { 1, 0, -1, 0 };
	static int rl[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] array = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int startX = 0, startY = 0;
		while (N != startX && M != startY) {
			int mod = size(N- startX, M- startY);
			int r= R % mod;

			for (int i = 0; i < r; i++) {
				rotate(array, startX, startY, N, M);
			}
			N -= 1;
			M -= 1;
			startX++;
			startY++;
		}
		print(array);
	}

	private static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void rotate(int[][] array, int startX, int startY, int N, int M) {
		int previous = array[startX][startY];
		
		int x = startX;
		int y = startY;
		
		for (int i = 0; i < 4; i++) {
			while (true) {
				int nx = startX + ud[i];
				int ny = startY + rl[i];

				if (nx < x || nx >= N || ny < y || ny >= M)
					break;

				int temp = array[nx][ny];
				array[nx][ny] = previous;
				previous = temp;

				startX = nx;
				startY = ny;
			}
		}
	}

	private static int size(int N, int M) {
		int ret = 0;
		for (int i = 2; i <= N; i++) {
			ret += 2;
		}

		for (int j = 2; j <=M; j++)
			ret += 2;

		return ret;
	}
}
