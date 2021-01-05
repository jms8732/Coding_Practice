package dp;

/*
 * 합분해
 * 중복 조합이므로 brute force를 이용하면 시간 초과가 발생한다.
 * 따라서, 중복 연산을 제거하기 위해 DP를 이용한다.
 * 
 * 중복 연산는 현재 합을 만드는데 구성요소인 K 값 원소들이다.
 * 
 */
import java.util.*;

public class problem_2225 {
	static int cache[][], MOD = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		cache = new int[N + 1][K];

		for (int[] c : cache)
			Arrays.fill(c, -1);

		System.out.println(dp(N, K - 1));
		sc.close();

	}

	private static int dp(int sum, int depth) {
		if (depth == -1) {
			if (sum == 0)
				return 1;

			return 0;
		}

		if (cache[sum][depth] != -1)
			return cache[sum][depth];

		int ret = 0;

		for (int i = 0; i <= sum; i++)
			ret = (ret + dp(sum - i, depth - 1)) % MOD;

		return cache[sum][depth] = ret;
	}
}
