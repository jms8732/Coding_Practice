package programmers1;
//����
import java.util.*;

public class problem_10 {
	static int max = 10000000;
	public static void main(String[] args) {
		int [][] result = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		System.out.println(solution(5,result));
	}

	public static int solution(int n, int[][] results) {
		int [][] board=  new int[n][n];
		for(int i [] : board) {
			Arrays.fill(i, max);
		}
		
		for(int i =0 ; i < results.length ; i++) {
			int x = results[i][0]-1;
			int y = results[i][1]-1;
			board[x][y] = 1;
		}
		
		for(int i =0 ; i< board.length ; i++) {
			board[i][i] = 0;
		}
		
		for(int i =0 ; i < n ; i++) {
			for(int j =0 ; j< n ; j++) {
				for(int k = 0 ; k < n ; k++) {
					if(board[j][k] > board[j][i] + board[i][k])
						board[j][k] = board[j][i] + board[i][k];
				}
			}
		}
		
		boolean [] member = new boolean[n];
		Arrays.fill(member, true);
		for(int i =0 ; i< n; i++) {
			for(int j =0 ;  j< n ; j++) {
				if(board[i][j] == max && board[j][i] == max)
				{
					member[i] = false;
					break;
				}
			}
		}
		int count = 0;
		for(int i =0 ; i< member.length ; i++) {
			if(member[i])
				count++;
		}
		
		return count;
	}

}
