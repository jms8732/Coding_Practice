package dp;

/*
 * �պ���
 * �ߺ� �����̹Ƿ� brute force�� �̿��ϸ� �ð� �ʰ��� �߻��Ѵ�.
 * ����, �ߺ� ������ �����ϱ� ���� DP�� �̿��Ѵ�.
 * 
 * �ߺ� ����� ���� ���� ����µ� ��������� K �� ���ҵ��̴�.
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
