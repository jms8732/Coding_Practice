package others;

/*
 * 소수의 연속합
 * 소수를 구하기 위해 에라토스테네스 체를 이용
 * 구한 소수를 투 포인터를 이용하여 값을 구한다
 */

import java.util.*;
import java.io.*;

public class problem_1644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 에라토스테네스 체
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

				if (sum <= n) { // 합이 n과 동일하거나 작은 경우
					if (sum == n)
						ans++;
				} else // 합 > n
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
