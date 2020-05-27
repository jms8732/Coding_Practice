package samsung;

//스타트와 링크
import java.util.*;
import java.io.*;

public class problem_14889_1 {
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = Integer.MAX_VALUE;
		for (int i = 1; i < 1 << N; i++) {
			if (Integer.bitCount(i) % (N/2) == 0) {
				answer = Math.min(calculate(i,N),answer);
				
			}
		}
		
		System.out.println(answer);
	}

	private static int calculate(int t, int N) {
		boolean [] team = new boolean[N];
		
		for(int i =0 ; i < N ; i++) {
			if( (t & 1<< i) == 1<<i)
				team[i] = true;
		}
		
		int a_team = 0, b_team =0;
		
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < N ; j++) {
				if(team[i] && team[j]){
					a_team += board[i][j];
				}
				
				if(!team[i] && !team[j])
					b_team += board[i][j];
			}
		}
		
		return Math.abs(a_team - b_team);
	}
}
