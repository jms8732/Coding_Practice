package programmers1;

//�Ž�����
import java.util.*;

public class problem_16 {
	public static void main(String[] args) {
		int [] money = {2,5};
		int result = solution(5,money);
		System.out.println(result);
	}

	public static int solution(int n, int[] money) {
		int [] dp = new int[n+1];
		
		for(int i =0 ; i< money.length ; i++) {
			dp[money[i]] += 1;
			for(int j = money[i]+1; j < dp.length ; j++) {
				dp[j] = dp[j] + dp[j-money[i]] %  1000000007;
			}
		}
		
		return dp[n];
	}
}
