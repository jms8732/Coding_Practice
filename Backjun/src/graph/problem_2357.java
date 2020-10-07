package graph;

/*
 * �ּڰ��� �ִ�
 * 
 * ���׸�Ʈ Ʈ���� �̿�
 * 1. �������� �ּڰ��� �ִ��� ������ Ŭ���� �迭�� �����Ѵ�.
 * 2. ���� ���� ���� �ּڰ��� �ִ��� ã�� ���ؼ� Ž���� �����Ѵ�.
 */

import java.util.*;
import java.io.*;

public class problem_2357 {
	static int[] array;
	static Node[] min_max_array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		array = new int[N];
		min_max_array = new Node[N * 4];

		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(br.readLine());

		for (int i = 1; i < min_max_array.length; i++)
			min_max_array[i] = new Node();

		init(0, N - 1, 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			for (long l : find_max_min(0, N - 1, 1, a, b)) {
				System.out.print(l + " ");
			}
			System.out.println();
		}
	}

	private static long[] find_max_min(int start, int end, int idx, int left, int right) {
		if (right < start || left > end) // ������ ���� ���
			return null;

		if (left <= start && end <= right) // ���� �ȿ� ������ ���
			return new long[] { min_max_array[idx].min, min_max_array[idx].max };

		int mid = (start + end) / 2;

		long cur_min = Integer.MAX_VALUE, cur_max = 0;
		
		long[] temp = find_max_min(start, mid, idx * 2, left, right);

		if (temp != null) {
			cur_min = Math.min(cur_min, temp[0]);
			cur_max = Math.max(cur_max, temp[1]);
		}

		temp = find_max_min(mid + 1, end, idx * 2 + 1, left, right);

		if (temp != null) {
			cur_min = Math.min(cur_min, temp[0]);
			cur_max = Math.max(cur_max, temp[1]);
		}
		
		return new long[] { cur_min, cur_max };

	}

	// ���� ���� �ִ�, �ּڰ��� �ʱ�ȭ�ϴ� �޼ҵ�
	private static Node init(int start, int end, int idx) {
		if (start == end) {
			return min_max_array[idx] = new Node(array[start], array[start]);
		}

		int mid = (start + end) / 2;
		long temp_min = Integer.MAX_VALUE, temp_max = 0;
		Node temp = init(start, mid, idx * 2);

		temp_min = Math.min(temp_min, Math.min(temp.max, temp.min));
		temp_max = Math.max(temp_max, Math.max(temp.max, temp.min));

		temp = init(mid + 1, end, idx * 2 + 1);

		temp_min = Math.min(temp_min, Math.min(temp.max, temp.min));
		temp_max = Math.max(temp_max, Math.max(temp.max, temp.min));

		min_max_array[idx].max = temp_max;
		min_max_array[idx].min = temp_min;

		return min_max_array[idx];
	}

	private static class Node {
		long min, max;

		public Node() {
		}

		public Node(long mn, long mx) {
			this.min = mn;
			this.max = mx;
		}
	}
}
