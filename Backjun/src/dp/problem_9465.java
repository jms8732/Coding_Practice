package dp;

//½ºÆ¼Ä¿
import java.io.*;
import java.util.*;

public class problem_9465 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int k = 0; k < T; k++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[2][N+1];
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[3][N];
			dp[0][0] = map[0][0];
			dp[1][0] = map[1][0];
			
			for(int i = 1; i < N ; i++) {
				dp[0][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1])+map[0][i]);
				dp[1][i] = Math.max(dp[1][i-1],Math.max(dp[0][i-1],dp[2][i-1])+map[1][i]);
				dp[2][i] = Math.max(dp[0][i-1],Math.max(dp[1][i-1], dp[2][i-1]));
			}
			int big = Math.max(dp[0][N-1],Math.max(dp[1][N-1], dp[2][N-1]));
			System.out.println(big);
		}
	}
}