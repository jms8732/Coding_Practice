package dp;

/*
 * �Ǻ���ġ �� 4
 * N�� 10000�� ���, long, int���� ������ �����.
 * ����, �� ū ���� ���� �� �ִ� BigInteger�� �̿��Ѵ�.
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
