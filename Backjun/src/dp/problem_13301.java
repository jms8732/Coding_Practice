package dp;

/*
 * Ÿ�� ��� ��
 * �Ǻ���ġ ������ N���� ������ ���簢���� �� ���� ���̸� ���Ѵ�.
 * ������ �� ���� tile[N] + tile[N-1]�� ���ϸ� �ȴ�.
 */

import java.util.*;

public class problem_13301 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		long[] tile = new long[81];

		tile[1] = 1;
		tile[2] = 1;

		for (int i = 3; i <= 80; i++)
			tile[i] = tile[i - 2] + tile[i - 1];

		System.out.println((tile[N] + tile[N-1]) * 2 + tile[N] * 2);
	}
}
