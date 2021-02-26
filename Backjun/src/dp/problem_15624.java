package dp;

/*
 * 피보나치 수 7
 * 피보나치 수열 구할 때 사용하는 방식으로 접근하면 된다
 */
import java.util.*;

public class problem_15624 {
	static int MOD = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if (n == 0)
			System.out.println(0);
		else if (n == 1) {
			System.out.println(1);
		} else {
			int[] cache = new int[n + 1];
			cache[1] = 1;

			for (int i = 2; i <= n; i++) {
				cache[i] = (cache[i - 1] + cache[i - 2]) % MOD;
			}
			
			System.out.println(cache[n]);
		}
	}
}
