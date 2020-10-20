package programmers2;

/*
 * 3xN
 * 백준 문제 2133과 동일한 문제
 * bitmask + dp를 이용해서 문제를 해결한다.
 */
public class problem_35 {
	public static int solution(int n) {
		if (n % 2 == 0) { //홀수 일 경우, 타일을 깔 수 없다.
			int[][] cache = new int[n][1 << 3]; //cache에는 경우의 수를 저장한다.
			int mod = 1000000007;
			
			//n이 2일 경우 개수가 3개여야하는데 그러기 위해서는 110, 011, 000 의 값이 1이여야 한다.
			cache[0][3] = cache[0][6] = cache[0][0] = 1; 

			for (int i = 1; i < n; i++) {
				cache[i][7] = ((cache[i - 1][0] + cache[i - 1][3]) % mod + cache[i - 1][6]) % mod;
				cache[i][4] = cache[i - 1][6];
				cache[i][6] = (cache[i - 1][1] + cache[i - 1][7]) % mod;
				cache[i][3] = (cache[i-1][4] + cache[i-1][7]) % mod;
				cache[i][1] = cache[i-1][6];
				cache[i][0] = cache[i-1][7];
			}
			
			return cache[n-1][7];
		} else
			return 0;
	}
}
