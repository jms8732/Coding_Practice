package dp;
import java.util.*;

public class problem_2156 {
	static long[] dp;
	static int [] array;
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		
		int N = scanner.nextInt();
		dp = new long[N+1];
		array = new int[N+1];
		for(int i =1 ; i <= N ; i++) {
			int tmp = scanner.nextInt();
			array[i] = tmp;
		}
		long result = f(N);
		System.out.println(result);
	}
	static long f(int n) {
		if(n == 1)
			return array[n];

		dp[1] = array[1];
		dp[2] = array[1]+array[2];
		for(int i = 3; i <= n ;i++) {
			long result = dp[n-1];
			result = Math.max(result,(array[i-1]+array[i] +dp[i-3]));
			result= Math.max(result, dp[i-2]+array[i]);
			dp[i] = Math.max(dp[i-1], result);
		}
			
		return dp[n];
	}
}
