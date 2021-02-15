package dp;

/*
 * 피보나치 수 4
 * N이 10000일 경우, long, int형의 범위를 벗어난다.
 * 따라서, 더 큰 수를 담을 수 있는 BigInteger를 이용한다.
 */

import java.util.*;
import java.math.*;

public class problem_10826 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		if (N == 0)
			System.out.println(0);
		else {
			BigInteger[] fibo = new BigInteger[N+1];
			fibo[0] = new BigInteger("0");
			fibo[1] = new BigInteger("1");

			for (int i = 2; i <= N; i++) {
				fibo[i] = fibo[i-1].add(fibo[i-2]);
			}

			System.out.println(fibo[N]);
		}
	}
}
