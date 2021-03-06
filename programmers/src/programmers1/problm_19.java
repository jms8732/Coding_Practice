package programmers1;

//�����Ա�
public class problm_19 {
	public static void main(String[] args) {
		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		int result = solution(land);
		System.out.println(result);
	}

	public static int solution(int[][] land) {
		int[][] dp = new int[land.length][4];
		int depth = 0;

		System.arraycopy(land[0], 0, dp[0], 0, 4);
		for (int i = 1; i < land.length; i++) {
			for(int j =0 ; j< 4 ; j++) {
				dp[i][j] = big(i,j,dp,land);
			}
		}
		int answer = 0;
		for (int i = 0; i < 4; i++) {
			answer = Math.max(answer, dp[dp.length - 1][i]);
		}

		return answer;
	}
	private static int big(int i, int j, int [][] dp, int [][] land) {
		int big = 0;
		big = Math.max(land[i][j], dp[i][j]);
		switch(j) {
		case 0:
			big = Math.max(big,land[i][j] + dp[i-1][j+1]);
			big = Math.max(big,land[i][j] + dp[i-1][j+2]);
			big = Math.max(big,land[i][j] + dp[i-1][j+3]);
			break;
		case 1:
			big = Math.max(big,land[i][j] + dp[i-1][j-1]);
			big = Math.max(big,land[i][j] + dp[i-1][j+1]);
			big = Math.max(big,land[i][j] + dp[i-1][j+2]);
			break;
		case 2:
			big = Math.max(big,land[i][j] + dp[i-1][j-2]);
			big = Math.max(big,land[i][j] + dp[i-1][j-1]);
			big = Math.max(big,land[i][j] + dp[i-1][j+1]);
			break;
		case 3:
			big = Math.max(big,land[i][j] + dp[i-1][j-3]);
			big = Math.max(big,land[i][j] + dp[i-1][j-2]);
			big = Math.max(big,land[i][j] + dp[i-1][j-1]);
			break;
		}
		
		
		return big;
	}
}
