package programmers2;

//블록 게임
public class problem_29 {

	public static void main(String[] args) {
		int board[][] = { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 7 }, { 0, 0, 0, 0, 0, 0, 7 },
				{ 0, 0, 0, 0, 0, 7, 7 }, { 0, 0, 0, 0, 0, 4, 0 }, { 0, 0, 0, 0, 0, 4, 0 }, { 0, 0, 0, 0, 0, 4, 4 } };

		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
		int N = board.length;
		boolean check = false;
		int answer = 0;
		while (!check) {
			check = true;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= 2; j++) {
					if (i - j >= 0) {
						if (down_block(board, N, i, i - j)) {
							answer++;
							check = false;
						}
					}
				}
			}

			//print(board);
		}

		return answer;
	}

	private static boolean down_block(int[][] board, int N, int fy, int sy) {
		boolean check = false;
		int fx = 0;
		int fn = 0;

		while (true) {
			if (fx >= N)
				break;

			if (board[fx][fy] != 0) {
				fn = board[fx][fy];
				break;
			}

			fx += 1;
		}

		if (fx != 0)
			board[fx - 1][fy] = fn;

		int sx = 0;
		int sn = 0;

		while (true) {
			if (sx >= N)
				break;

			if (board[sx][sy] != 0) {
				sn = board[sx][sy];
				break;
			}

			sx += 1;
		}

		if (sx != 0)
			board[sx - 1][sy] = sn;

		if (fn != 0 || sn != 0) {

			if (find_horizen(board, N) || find_vertical(board, N)) {
				check = true;
			}
		}

		if (fx != 0)
			board[fx - 1][fy] = 0;

		if (sx != 0)
			board[sx - 1][sy] = 0;

		return check;
	}

	private static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean find_horizen(int[][] board, int N) {

		// 가로 직사각형
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j <= N - 3; j++) {
				if (board[i][j] != 0) {
					int num = board[i][j];
					if (horizen(board, num, i, j)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private static boolean horizen(int[][] board, int num, int axis_x, int axis_y) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[axis_x + i][axis_y + j] != num)
					return false;
			}
		}

		// 제거
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				board[axis_x + i][axis_y + j] = 0;
			}
		}

		return true;
	}

	private static boolean find_vertical(int[][] board, int N) {

		// 가로 직사각형
		for (int i = N - 3; i >= 0; i--) {
			for (int j = 0; j <= N - 2; j++) {
				if (board[i][j] != 0) {
					int num = board[i][j];
					if (vertical(board, num, i, j)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private static boolean vertical(int[][] board, int num, int axis_x, int axis_y) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				if (board[axis_x + i][axis_y + j] != num)
					return false;
			}
		}

		// 제거
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				board[axis_x + i][axis_y + j] = 0;
			}
		}

		return true;
	}
}
