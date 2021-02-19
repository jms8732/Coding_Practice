package dp;

/*
 * 피자 (small)
 * 만족도를 메모이제이션하여 진행
 */
import java.util.*;

public class problem_14606 {
	static int[] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		cache = new int[n + 1];

		System.out.println(dp(n));
	}

	private static int dp(int T) {
		if (T == 1)
			return 0;

		if (cache[T] != 0)
			return cache[T];

		int ret = 0;

		for (int i = 1; i <= T / 2; i++) {
			int left = i;
			int right = T - left;

			ret = Math.max(ret, left * right + dp(right));
		}

		return cache[T] = ret;
	}
}
