package samsung;
import java.util.*;

public class problem_14501 {
	static int[][] array;
	static int N;
	static int[] dp;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		array = new int[2][N+1];
		dp = new int[N+1];
		for(int i =1 ; i <= N ; i++) {
			int day = scanner.nextInt();
			int price = scanner.nextInt();
			array[0][i]= day;
			array[1][i] = price;
		}
		int result = f();
		System.out.println(result);
	}
	static int f() {
		int big = 0;
		 for(int i = N ; i >= 1; i--) {
			 int restDay = array[0][i];
			 int price = array[1][i];
			 if((restDay-1) + i > N)
				 dp[i] = big;
			 else
			 {
				 int tmp = 0;
				 if(restDay == 1)
					 tmp = price + big;
				 else if(restDay+i > N){
					 tmp = price;
				 }else {
					 tmp = price + dp[restDay+i];
				 }
				 big = Math.max(big, tmp);
				 dp[i] = big;
			 }
		 }
		 return big;
	}
}
