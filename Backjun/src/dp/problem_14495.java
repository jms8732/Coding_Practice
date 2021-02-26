package dp;

/*
 * �Ǻ���ġ �񽺹����� ����
 * ����� �Ǻ���ġ ����, ��, n<=116 �̹Ƿ� �ڷ��� ������ ��� �� �ִ�.
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
