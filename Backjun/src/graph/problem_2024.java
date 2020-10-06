package graph;

/*
 * ���� �� ���ϱ�
 * ���׸�Ʈ Ʈ���� �̿�, Ʈ���� �迭�� �̿��ؼ� ǥ���Ѵ�. 
 * 1) ��� �Լ��� �̿��Ͽ� ���� ���� ���Ѵ�.
 * 2) ���� ���� ��� �Լ��� ���Ѵ�.
 */

import java.util.*;
import java.io.*;

public class problem_2024 {
	static long[] sum_array, array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		array = new long[N];
		sum_array = new long[N * 4];

		for (int i = 0; i < N; i++) {
			array[i] = Long.parseLong(br.readLine());
		}

		init(0, N - 1, 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) - 1;

			if (a == 1) {
				long c = Long.parseLong(st.nextToken());
				long diff = c - array[b];
				
				array[b] = c;
				update(0,N-1,1,diff,b);
			} else {
				int c = Integer.parseInt(st.nextToken()) - 1;
				System.out.println(sum(0, N - 1, 1, b, c));
			}
		}

	}

	// �ʱ� ������ ���� ����� ���� �޼ҵ�
	private static long init(int start, int end, int idx) {
		if (start == end)
			return sum_array[idx] = array[start];

		int mid = (start + end) / 2;
		return sum_array[idx] += init(start, mid, idx * 2) + init(mid + 1, end, idx * 2 + 1);
	}

	// ���� ���� ���ϴ� �޼ҵ�
	private static long sum(int start, int end, int idx, int left, int right) {
		if (left > end || start > right) {
			return 0; // ������ ��� ���
		}

		if (left <= start && end <= right)
			return sum_array[idx]; // ������ �����ϴ� ���

		int mid = (start + end) / 2;
		return sum(start, mid, idx * 2, left, right) + sum(mid + 1, end, idx * 2 + 1, left, right);
	}

	private static void update(int start, int end, int idx, long diff, int tar) {
		if (tar < start || end < tar)
			return; // ������ �ƴ� ���

		sum_array[idx] += diff;

		if (start == end)
			return;

		int mid = (start + end) / 2;

		update(start, mid, idx * 2, diff, tar);
		update(mid + 1, end, idx * 2 + 1, diff, tar);

	}
}
