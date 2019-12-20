package programmers1;
//���� ū ���簢�� ã��

import java.util.*;

public class problem_13 {
	public static void main(String[] args) {
		int[][] board = { { 0,1,1,1 }, { 1, 1,1,1}, { 1, 1,1,1 }, { 0,0,1,0 } };
		int result = solution(board);
		System.out.println(result);
	}

	public static int solution(int[][] board) {
		int[][] tmpBoard = new int[board.length+1][board[0].length+1];
		int big =0 ;
		int idx =1;
		for(int i [] : board) {
			System.arraycopy(i, 0, tmpBoard[idx], 1, i.length);
			idx++;
		}
		
		for(int i = 1; i < tmpBoard.length ; i++) {
			for(int j = 1 ; j< tmpBoard[i].length ; j++) {
				if(tmpBoard[i][j] == 1) {
					//����, �������, ��� �� �� ���� ���� �� +1
					int min = Math.min(tmpBoard[i-1][j-1], tmpBoard[i][j-1]);
					min = Math.min(min, tmpBoard[i-1][j]);
					
					tmpBoard[i][j] = min+1;
					big = Math.max(big, tmpBoard[i][j]);
				}
			}
		}
		
		
		return (int)Math.pow(big, 2);
	}

	
}
