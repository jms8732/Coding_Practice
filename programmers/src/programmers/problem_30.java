package programmers;
//타일 장식물
public class problem_30 {
	public static void main(String[] args) {
		long result = solution(5);
		System.out.println(result);
	}

	public static long solution(int N) {
		long answer = 0;
		long dp[] = new long[N+1];
		dp[0] = 4;
		dp[1] = 6;
		
		for(int i = 2; i < N ; i++) {
			dp[i] = dp[i-1]+ dp[i-2];
		}
		
		return dp[N-1];
		
	}
}
