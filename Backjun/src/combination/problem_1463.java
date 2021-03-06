package combination;

//1로 만들기
import java.util.*;

public class problem_1463 {
	static int N;
	static int[] dp;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		/*
		 * 런타임 에러가 발생하는 것을 방지하기 위해 배열의 크기를 문제에서 주어진 최댓값 10^6으로 설정한다.
		 */
		dp = new int[1000001]; 
		dp[2]= 1;
		dp[3] =1;
		int result = 0;
		
		
		if(N == 2 || N == 3)
			result = 1;
		else if(N != 1)
			result = dfs(4);
		
		System.out.println(result);
		
	}
	
	private static int dfs(int target) {
		if(target > N)
			return dp[N];
		
		if(dp[target] != 0) //해당 인덱스를 만들 수 있는 최소의 개수를 반환
			return dp[target];
		
		int result = Integer.MAX_VALUE;
		
		if(target % 2 == 0) result = Math.min(result, dfs(target/2)+1); //2으로 나눠지는 경우
		if(target % 3 == 0) result = Math.min(result, dfs(target/3)+1); //3으로 나눠지는 경우
		
		result = Math.min(result, dfs(target-1)+1); //1로 뺏을 경우
		dp[target] = result; //해당 인덱스의 최소로 만들 수 있는 개수를 배열에 저장한다.
		result = dfs(target+1); //다음 인덱스로 넘어간다.
		
		return result;
	}
}
