package programmers2;

import java.util.*;

//프로그래밍 1
public class problem_16 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };

		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<>();
		int answer = 0;
		int prev = 0;
		for (int i = 0; i < moves.length; i++) {
			int tmp = goDown(moves[i]-1, board);
			if (tmp != 0) {
				if (!stack.isEmpty())
					prev = stack.peek();
				if (prev == tmp) {
					stack.pop();
					answer += 2;
				} else
					stack.add(tmp);
			}
		}

		return answer;
	}

	private static int goDown(int idx, int[][] board) {
		int value = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][idx] != 0) {
				value = board[i][idx];
				board[i][idx] = 0;
				break;
			}
		}

		return value;
	}
}
