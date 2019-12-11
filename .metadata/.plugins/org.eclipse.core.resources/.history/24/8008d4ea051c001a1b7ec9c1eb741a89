package dp;
import java.util.*;
public class problem_11057 {
	static int dp[][];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		dp = new int[N+1][10];
		Arrays.fill(dp[1], 1);
		int result = f(N);
		System.out.println(result);
	}
	static int f(int n) {
		if(n == 1)
			return 10;
		int total = 0;
		for(int i = 2 ; i <= n ; i++) {
			for(int j = 9 ; j >=0 ; j--) {
				if(j == 9)
					dp[i][j] = 1;
				else {
					dp[i][j] = dp[i-1][j] %10007 + dp[i][j+1] % 10007; 
				}
				if(i == n)
					total += dp[i][j] % 10007;
				total %= 10007;
			}
		}
		return total;
	}
} 
