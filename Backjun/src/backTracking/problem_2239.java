package backTracking;

//½ºµµÄí

import java.util.*;
import java.io.*;

public class problem_2239 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] board = new int[9][9];

		int zero_Count = 0;
		for (int i = 0; i < 9; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < 9; j++) {
				if (tmp.charAt(j) - '0' == 0)
					zero_Count++;

				board[i][j] = tmp.charAt(j) - '0';
			}
		}

		backtracking(board,0, zero_Count);
	}

	private static void backtracking(int[][] board,int next, int zeroCount) {
		if (zeroCount == 0) {
			print(board);
			System.exit(0);

		}
		
		for (int i = next; i < 9 * 9; i++) {
			int x = i / 9;
			int y = i % 9;
			
			if (board[x][y] == 0) {
				for (int select = 1; select <= 9; select++) {
					if (isRow_ok(select, x, board) && isCol_ok(select, y, board) && isBoard_ok(select, x, y, board)) {
						board[x][y] = select;
						//print(board);
						backtracking(board,i+1, zeroCount - 1);
						board[x][y] = 0;

					}
				}
				
				return;
			}
		}
	}

	private static void print(int[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean isRow_ok(int select, int r, int[][] board) {
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == select)
				return false;
		}

		return true;
	}

	private static boolean isCol_ok(int select, int c, int[][] board) {
		for (int i = 0; i < 9; i++) {
			if (board[i][c] == select)
				return false;
		}

		return true;
	}

	private static boolean isBoard_ok(int select, int x, int y, int[][] board) {
		int pivot_x = x / 3;
		int pivot_y = y / 3;

		pivot_x *= 3;
		pivot_y *= 3;

		for (int i = pivot_x; i < pivot_x + 3; i++) {
			for (int j = pivot_y; j < pivot_y + 3; j++) {
				if (board[i][j] == select)
					return false;
			}
		}

		return true;
	}
}
