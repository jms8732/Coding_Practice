package dp;

import java.util.*;

public class problem_11053 {
	static int[] dp;
	static int[] array;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		array = new int[1001];
		dp = new int[N+1];

		for (int i = 1; i <= N; i++) {
			int tmp = scanner.nextInt();
			array[i] = tmp;
		}
		Arrays.fill(dp, 1);
		int result = f(N);
		System.out.println(result);
	}
	static int f(int n) {
		if(n ==1)
			return 1;
		
		for(int i = 2 ; i <= n  ;i++) {
			for(int j =1 ; j < i ; j++) {
				if(array[i] > array[j] && dp[i] <= dp[j])
					dp[i]= dp[j]+1;
				else if(array[i] == array[j])
					dp[i] = dp[j];

			}
		}
		int result = 0;
		for(int i =1 ; i<=n ; i++) {
			result = Math.max(result, dp[i]);
		}
		
		return result;
	}

}
