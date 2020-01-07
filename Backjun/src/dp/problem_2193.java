package dp;

//이친수
import java.util.*;
import java.io.*;

public class problem_2193 {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		long [] dp = new long[90]; //int형으로 하게 되면 overflow가 발생한다.
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2 ; i < N ; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[N-1]);
	}
}
