package search_algorithm;

/*
 * ���� ī�� 2
 * �̺� Ž���� lower bound, upper bound�� �̿��Ѵ�.
 */
import java.util.*;
import java.io.*;

public class problem_10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] card = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(card); // ������������ ����

		int m = Integer.parseInt(br.readLine());

		int[] search_card = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			search_card[i] = Integer.parseInt(st.nextToken());
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i : search_card) {
			int left = left_bound(i, card);
			int right = right_bound(i, card);

			bw.write((right - left)+ " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static int left_bound(int target, int[] card) {
		int left = 0, right = card.length;

		while (left < right) {
			int mid = (left + right) / 2;

			if (card[mid] < target) {
				left = mid + 1;
			} else
				right = mid;
		}

		return left;
	}

	private static int right_bound(int target, int[] card) {
		int left = 0, right = card.length;

		while (left < right) {
			int mid = (left + right) / 2;

			if (card[mid] <= target) {
				left = mid + 1;
			} else
				right = mid;
		}

		return left;
	}
}
