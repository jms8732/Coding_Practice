package backTracking;

//¸ÂÃçºÁ

import java.util.*;
import java.io.*;

public class problem_1248 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		String line = br.readLine();

		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				board[i][j] = line.charAt(idx++);
			}
		}

		int[] val = new int[N];
		backtracking(0, board, N, val);
	}

	private static void backtracking(int depth, char[][] board, int N, int[] val) {
		if (N == depth) {
			for (int i : val)
				System.out.print(i + " ");

			System.exit(0);
		}

		for (int select = -10; select <= 10; select++) {
			val[depth] = select;
			if (isRight(board, depth, val)) {
				backtracking(depth + 1, board, N, val);
			}
			val[depth] = 0;
		}
	}

	private static boolean isRight(char[][] board, int depth, int[] val) {
		int sum = 0;
		int pivot_y = depth;
		for (int i = depth; i >= 0; i--) {
			sum += val[i];

			if (board[i][pivot_y] == '+' && sum <= 0)
				return false;
			else if (board[i][pivot_y] == '-' && sum >= 0)
				return false;
			else if (board[i][pivot_y] == '0' && (sum < 0 || sum > 0))
				return false;
		}

		return true;
	}
}
