package others;

/*
 * �Ҽ��� ������
 * �Ҽ��� ���ϱ� ���� �����佺�׳׽� ü�� �̿�
 * ���� �Ҽ��� �� �����͸� �̿��Ͽ� ���� ���Ѵ�
 */

import java.util.*;
import java.io.*;

public class problem_1644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// �����佺�׳׽� ü
		boolean[] prime = new boolean[n + 1];
		List<Integer> prime_list = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (!prime[i]) {
				prime_list.add(i);
				for (int j = i; j <= n; j += i) {
						prime[j] = true;
				}
			}
		}

		Collections.sort(prime_list);
		twoPoint(n, prime_list);
	}

	private static void twoPoint(int n, List<Integer> prime_list) {
		int left_idx = -1, right_idx = -1;
		int sum = 0, ans = 0;
		while (left_idx < prime_list.size()) {
			while (++right_idx < prime_list.size()) {
				sum += prime_list.get(right_idx);

				if (sum <= n) { // ���� n�� �����ϰų� ���� ���
					if (sum == n)
						ans++;
				} else // �� > n
					break;
			}

			while (++left_idx < prime_list.size()) {
				sum -= prime_list.get(left_idx);
				if (sum <= n) {
					if (sum == n)
						ans++;
					break;
				}
			}
		}

		System.out.println(ans);
	}
}
