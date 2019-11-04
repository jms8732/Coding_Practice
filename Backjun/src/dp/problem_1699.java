package dp;
import java.util.*;

public class problem_1699 {
	static int impossible = 1000000;
	static int [] dp ;
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int N = scanner.nextInt();
		dp = new int[N+1];
		Arrays.fill(dp, -1);
		int result = f(1,N);
		System.out.println(result);
	}
	
	static int f(int idx , int N) {
		if(idx * idx > N )
			return N == 0 ? 0 : impossible;
		if(dp[N] != -1)
			return dp[N];
		
		int result = f(idx+1,N );
		result = Math.min(result, f(idx,N-(idx*idx))+1);
		dp[N] = result;
		
		return result;
		
	}
}
