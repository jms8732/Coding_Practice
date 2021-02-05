package dp;

/*
 * �Ž��� ��
 * N�׼��� ��, �ּ��� ���� ������ �����ϸ� �ȴ�.
 * 
 */

import java.util.*;

public class problem_14916 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int INF = 10000000;

		int[] charge = new int[N + 1];
		charge[1] = INF;

		for (int i = 2; i <= N; i++) {
			if (i >= 5)
				charge[i] = Math.min(charge[i - 5] + 1, charge[i - 2] + 1);
			else
				charge[i] = Math.min(INF, charge[i - 2] + 1);
		}

		System.out.println(charge[N] == INF ? -1 : charge[N]);
	}
}
