package greedy;

/*
 * ��Ʈ
 * binary search�� �̿��Ͽ� ����
 *
 * 1. ���� ���ڸ� ��´�.
 * 2. binary search�� �̿��Ͽ� ���� ���� + 1�� ���� �������� �ľ��Ѵ�.
 * 3. ���� ���, ���� ���ڸ� ��� ����Ѵ�. �̶�, lower bound�� upper bound�� �̿��Ͽ� ������ ���� ��, ����Ѵ�.
 * 4. ���� ���, ���� ���� + 2 ���� 1000 ���� ���� ���ڰ� �������� �ľ��Ѵ�. ���ڰ� ������ ���, ���� ������ ���� ��θ� ����ϰ�, ���� ���� + 2 �̻��� ���� �ѹ��� ����Ѵ�.
 * 5. ���� ���� + 2 �̻��� ���� ���� ���, ���� ���� + 1�� ���� ����Ѵ�.
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
			// �������� ���� ���
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
