package dp;

//ÀÌÄ£¼ö
import java.util.*;
import java.io.*;

public class problem_2193 {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		long [] dp = new long[90];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2 ; i < N ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N-1]);
	}
}
