package dp;
import java.util.*;

public class problem_9465 {
	static int[][] stickers;
	static int[][] dp;
	static int size;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int test = scanner.nextInt();
		
		for(int i =0 ; i < test ; i++) {
			size = scanner.nextInt();
			stickers = new int[2][size];
			for(int [] temp : stickers)
				Arrays.fill(temp, -1);
			dp = new int[size][3];
			for(int [] temp : dp) {
				Arrays.fill(temp, -1);
			}
			for(int j = 0 ; j < stickers.length; j++) {
				for(int k = 0 ; k< stickers[j].length;k++) {
					int tmp = scanner.nextInt();
					stickers[j][k] = tmp;
				}
			}
			int result = f(0,0);
			System.out.println(result);
		}
	}
	static int f(int c, int status) {
		if(c == size )
			return 0;
		if(dp[c][status] != -1)
			return dp[c][status];
		int result = f(c+1,0);
		if(status != 1) result = Math.max(result,f(c+1,1)+stickers[0][c]);
		if(status != 2) result = Math.max(result, f(c+1,2) + stickers[1][c]);
		
		dp[c][status ] =result;
		return result;
	}
	
}
