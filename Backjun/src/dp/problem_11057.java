package dp;

//������ ��
import java.util.*;
public class problem_11057 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int MOD = 10007;
		int [][] dp = new int[N][10];
		
		Arrays.fill(dp[0], 1);
		
		for(int i= 1 ; i< N ; i++) {
			dp[i][9] =1;
			for(int j = 8 ; j >= 0 ; j--) {
				dp[i][j] = (dp[i-1][j] + dp[i][j+1]) % MOD;
			}
		}
		int answer = 0;
		for(int i = 0 ; i < 10 ; i++) {
			answer = (answer+dp[N-1][i])%MOD;
		}
		
		System.out.println(answer);
	}
}
