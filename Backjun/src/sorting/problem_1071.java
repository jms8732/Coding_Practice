package sorting;

/*
 * 소트
 * binary search를 이용하여 구현
 *
 * 1. 현재 숫자를 얻는다.
 * 2. binary search를 이용하여 현재 숫자 + 1의 값이 존재한지 파악한다.
 * 3. 없을 경우, 현재 숫자를 모두 출력한다. 이때, lower bound와 upper bound를 이용하여 범위를 구한 뒤, 출력한다.
 * 4. 있을 경우, 현재 숫자 + 2 부터 1000 범위 내에 숫자가 존재한지 파악한다. 숫자가 존재할 경우, 현재 숫자의 범위 모두를 출력하고, 현재 숫자 + 2 이상의 수는 한번만 출력한다.
 * 5. 현재 숫자 + 2 이상의 수가 없는 경우, 현재 숫자 + 1의 값을 출력한다.
 */
import java.util.*;
import java.io.*;

public class problem_1071 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(list);

		while (!list.isEmpty()) {
			int current = list.get(0);

			int lo = lower_bound(list, current);
			int hi = upper_bound(list, current);
			// 존재하지 않을 경우
			if (Collections.binarySearch(list, current + 1) < 0) {
				print(lo, hi, list);
			} else {
				boolean check = false;
				for (int j = current + 2; j < 1001; j++) {
					if (Collections.binarySearch(list, j) >= 0) {
						print(lo, hi, list);
						lo = lower_bound(list, j);
						hi = lo + 1;
						print(lo, hi, list);
						check = true;
						break;
					}
				}

				if (!check) {
					lo = lower_bound(list, current + 1);
					hi = upper_bound(list, current + 1);

					print(lo, hi, list);
				}
			}
		}
	}

	private static void print(int lo, int hi, List<Integer> list) {
		for (int i = lo; i < hi; i++) {
			System.out.print(list.get(i) + " ");
		}

		int diff = hi - lo;

		for (int i = 0; i < diff; i++)
			list.remove(lo);
	}

	private static int lower_bound(List<Integer> list, int target) {
		int left = 0;
		int right = list.size();

		while (left < right) {
			int mid = (left + right) / 2;

			if (list.get(mid) < target) {
				left = mid + 1;
			} else
				right = mid;
		}

		return left;
	}

	private static int upper_bound(List<Integer> list, int target) {
		int left = 0;
		int right = list.size();

		while (left < right) {
			int mid = (left + right) / 2;

			if (list.get(mid) <= target) {
				left = mid + 1;
			} else
				right = mid;
		}

		return left;
	}
}
