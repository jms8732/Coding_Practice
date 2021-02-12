package dp;

/*
 * �Ǽ�
 * �Ǻ���ġ ������ ����, ���� �ڸ��� ǥ���ϱ� ���ؼ� 10���� ���� �������� ������ �ȴ�.
 */
import java.util.*;

public class problem_8394 {
	public static void main(String[] args0) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] cache = new int[N];
		cache[0] = 1;
		cache[1] = 2;

		for (int i = 2; i < N; i++)
			cache[i] = (cache[i - 1] + cache[i - 2]) % 10;

		System.out.println(cache[N - 1]);
	}
}
