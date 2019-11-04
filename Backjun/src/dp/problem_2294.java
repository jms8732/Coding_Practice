package dp;

import java.util.*;

public class problem_2294 {
	static int[] array;
	static int small;
	static int total;
	static int impossible = 1000000000;
	static int count;
	static int dp[][] = new int[101][10001];
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		count = scanner.nextInt();
		total = scanner.nextInt();
		array = new int[total+1];
		for(int [] tmp : dp) {
			Arrays.fill(tmp, -1);
		}
		for (int i = 0; i < count; i++) {
			int tmp = scanner.nextInt();
			array[i]= tmp;
		}
		int result = f(0,total);
		if(result == impossible)
			System.out.println("-1");
		else
			System.out.println(result);
	}

	static int f(int idx,int total) {
		if(idx== count)
			return (total == 0 ? 0 : impossible);
		if(dp[idx][total] != -1)
			return dp[idx][total];
		
		int result = f(idx+1,total);
		if(total >= array[idx]) result = Math.min(result, f(idx,total-array[idx])+1);
		dp[idx][total] = result;
		
		return result;
		
	}

}
