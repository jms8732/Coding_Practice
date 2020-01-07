package dp;

//Á¦°ö¼öÀÇ ÇÕ

import java.util.*;

public class problem_1699 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		
		int [] dp = new int[100001];
		dp[1] = 1;
		long start = System.currentTimeMillis();
		for(int i = 2 ; i <= N ; i++) {
			int pow = (int)Math.pow(i,2);
			if(pow <=N)
				dp[pow] = 1;
			
			if(dp[i] == 0)
				dp[i] = min(dp,i);
		}
		long end = System.currentTimeMillis();
		System.out.println("time : " + (end-start)/1000.0);
		System.out.println(dp[N]);
	}
	
	private static int min(int [] dp, int N) {
		int sqrt = (int)Math.sqrt(N);
		int min = Integer.MAX_VALUE;
		
		for(int i= sqrt ; i >= 1 ; i--) {
			int pow = (int)Math.pow(i, 2);
			min = Math.min(min,dp[pow]+dp[N-pow]);
		}
		return min;
	}
}
