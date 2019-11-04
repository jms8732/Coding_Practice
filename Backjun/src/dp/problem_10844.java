package dp;

import java.util.*;

public class problem_10844 {
	static long[][] dp;
	static long mod = 1000000000;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		dp = new long[101][10];
		Arrays.fill(dp[1], 1);
		dp[2][1] = 2;
		long result = f(N);
		System.out.println(result);
	}

	static long f(int n) {
		if (n == 1)
			return 9;
		long total = 0;
		for (int i = 2; i <= n; i++) {
			for (int j = 9; j >= 1; j--) {
				if (j == 1 && i != 2)
					dp[i][j] = dp[i - 2][j] % mod + dp[i - 1][j + 1] % mod;
				else if (j == 9)
					dp[i][j] = dp[i - 1][j - 1] % mod;
				else if (j >= 2 && j < 9)
					dp[i][j] = dp[i - 1][j + 1] % mod + dp[i - 1][j-1] % mod;
				if(i == n) {
					total += (dp[i][j] % mod);
					total %= mod;
				}
			}
		}
		return total;
	}
}
