package dp;

/*
 * 피보나치 비스무리한 수열
 * 평범한 피보나치 수열, 단, n<=116 이므로 자료형 범위를 벗어날 수 있다.
 */
import java.util.*;
import java.math.*;

public class problem_14495 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		BigInteger[] cache = new BigInteger[n + 1];

		if (n <= 3)
			System.out.println(1);
		else {
			cache[1] = cache[2] = cache[3] = new BigInteger("1");

			for (int i = 4; i <= n; i++) {
				cache[i] = cache[i - 1].add(cache[i - 3]);
			}

			System.out.println(cache[n]);
		}
	}
}
