package bitmask;

//��ܼ�
import java.util.*;
import java.io.*;

public class problem_1562 {
	static long[][][] dp;
	static int IMPOSSIBLE = -1;
	static int MOD = 1000000000;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();

		dp = new long[101][10][1 << 10];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				Arrays.fill(dp[i][j], IMPOSSIBLE);
			}
		}

		long result = 0;
		if (N < 10)
			System.out.println(result);
		else {
			for (int i = 9; i >= 1; i--) {
				int bit = 1 << i;
				result = (result + dfs(bit, N - 1, i)) % MOD;
			}

			System.out.println(result);
		}

	}

	private static long dfs(int bit, int N, int cur) {
		if (N == 0) {
			if (bit == (1 << 10) - 1) {
				return 1;
			}
			return 0;
		}

		if (dp[N][cur][bit] != IMPOSSIBLE) {
			return dp[N][cur][bit];
		}

		int left = cur - 1;
		int right = cur + 1;

		long lv = 0, rv = 0;

		if (left >= 0)
			lv = dfs(bit | (1 << left), N - 1, left) % MOD;
		if (right <= 9)
			rv = dfs(bit | (1 << right), N - 1, right) % MOD;

		dp[N][cur][bit] = (lv + rv) % MOD;

		return dp[N][cur][bit];

	}
}
