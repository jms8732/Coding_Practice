package programmers1;

//°Å½º¸§ µ· 37.5

public class problem_15 {
	public static void main(String[] args) {
		long result = solution(2000);
		System.out.println(result);
	}

	public static long solution(int n) {
		long[] dp = new long[2001];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
		}

		return dp[n] % 1234567;

	}

}
