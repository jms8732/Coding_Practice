package dp;

/*
 * ĭ��� ����
 * n�� 12�����̹Ƿ� �޸� �ʰ��� �߻����� �ʴ´�.
 */
import java.util.*;

public class problem_4779 {
	static String[] cache;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			int n = sc.nextInt();
			n = (int) Math.pow(3, n);
			cache = new String[n + 1];

			System.out.println(dp(n));
		}
	}

	private static String dp(int N) {
		if (N == 1)
			return "-";

		if (cache[N] != null)
			return cache[N];

		StringBuilder sb = new StringBuilder();

		sb.append(dp(N / 3));

		for (int i = 0; i < N / 3; i++)
			sb.append(" ");

		sb.append(dp(N / 3));

		return cache[N] = sb.toString();
	}
}
