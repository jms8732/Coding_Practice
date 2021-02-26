package dp;

/*
 * 2xn Ÿ�ϸ�
 * ��ȭ���� �̿��ؼ� ������ �ذ��Ѵ�
 */
import java.util.*;

public class problem_11726 {
	static int MOD = 10007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] cache = new int[n + 1];

		if (n == 1)
			System.out.println(1);
		else {
			cache[1] = 1;
			cache[2] = 2;

			for (int i = 3; i <= n; i++) {
				cache[i] = (cache[i - 1] + cache[i - 2]) % MOD;
			}

			System.out.println(cache[n]);
		}
	}
}
