package programmers;


//2xn Ÿ�ϸ�
public class problem_12 {
	public static void main(String[] args) {
		int result = solution(4);
		System.out.println(result);

	}
	public static int solution(int n) {
	      int[] dp = new int[n+1]; //n���� ǥ���ؾߵ�
	      long div = 1000000007;
	      dp[1] = 1;
	      dp[2] = 2;
	      
	      for(int i = 3 ; i <= n ; i++) {
	    	  dp[i] = (int)(((dp[i-1] % div)  + (dp[i-2] % div))%div);
	      }
	      
	      return dp[n];
	  }
}
