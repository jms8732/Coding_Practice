package graph;

/*
 * 버블 소트
 * Merge sort를 이용하여 문제를 접근한다.
 * Bubble sort 방식으로 진행할 경우 O(n^2) 시간 복잡도로 인해 시간 초과가 발생한다.
 */
import java.util.*;
import java.io.*;

public class problem_1517 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			array[i] = Integer.parseInt(st.nextToken());

		System.out.println(divide(0, n - 1, array));

	}

	private static long divide(int left, int right, int[] array) {
		if (left < right) {
			long ret = 0;
			int mid = (left + right) / 2;

			ret += divide(left, mid, array);
			ret += divide(mid + 1, right, array);

			return ret += merge(left, right, array);
		}

		return 0;
	}

	private static long merge(int left, int right, int[] array) {
		long ret = 0;
		int len = (right - left) + 1;

		int[] temp = new int[len];
		int idx = 0;
		int l = left;
		int m = ((left + right) / 2);
		int r = m + 1;

		/*
		 * Swap은 좌 -> 우로 Swap되는 부분만 횟수를 센다.
		 */
		while (l <= m && r <= right) {
			if (array[l] <= array[r]) {
				temp[idx++] = array[l++];
			} else {
				ret += Math.abs(m - l + 1); //Swap 횟수를 세는 부분, Merge Sort는 가운데를 기준으로 현재 배열의 값과 비교하면서 Swap을 진행하기 때문에
				temp[idx++] = array[r++];
			}
		}

		if (l > m) {
			for (int i = r; i <= right; i++) {
				temp[idx++] = array[i];
			}
		} else {
			for (int i = l; i <= m; i++) {
				temp[idx++] = array[i];
			}
		}

		System.arraycopy(temp, 0, array, left, len);

		return ret;
	}
}
