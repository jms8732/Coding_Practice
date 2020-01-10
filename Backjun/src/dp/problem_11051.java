package dp;

//이항 계수2
import java.util.*;
public class problem_11051 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		int MOD = 10007;
		
		int [][] dp = new int[N+1][];
		dp[0] = new int[1];
		dp[0][0] = 1;
		dp[1] = new int[2];
		dp[1][0] = 1;
		dp[1][1] = 1;
		
		for(int i = 2 ; i<= N ; i++) {
			dp[i] = new int[i+1];
			dp[i][0] = 1; //처음에 1
			dp[i][dp[i].length-1] = 1; //마지막에 1
			
			for(int j = 1 ; j< dp[i].length-1; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % MOD;
			}
		}
		
		System.out.println(dp[N][K]);
	}
}
