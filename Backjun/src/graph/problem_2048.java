package graph;

/*
 * 구간 합 구하기
 * 세그먼트 트리를 이용, 트리는 배열을 이용해서 표현한다. 
 * 1) 재귀 함수를 이용하여 구간 합을 구한다.
 * 2) 구간 합을 재귀 함수로 구한다.
 */

import java.util.*;
import java.io.*;

public class problem_2048 {
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

	// 초기 구간의 합을 만들기 위한 메소드
	private static long init(int start, int end, int idx) {
		if (start == end)
			return sum_array[idx] = array[start];

		int mid = (start + end) / 2;
		return sum_array[idx] += init(start, mid, idx * 2) + init(mid + 1, end, idx * 2 + 1);
	}

	// 구간 합을 구하는 메소드
	private static long sum(int start, int end, int idx, int left, int right) {
		if (left > end || start > right) {
			return 0; // 범위를 벗어난 경우
		}

		if (left <= start && end <= right)
			return sum_array[idx]; // 범위에 존재하는 경우

		int mid = (start + end) / 2;
		return sum(start, mid, idx * 2, left, right) + sum(mid + 1, end, idx * 2 + 1, left, right);
	}

	private static void update(int start, int end, int idx, long diff, int tar) {
		if (tar < start || end < tar)
			return; // 범위가 아닌 경우

		sum_array[idx] += diff;

		if (start == end)
			return;

		int mid = (start + end) / 2;

		update(start, mid, idx * 2, diff, tar);
		update(mid + 1, end, idx * 2 + 1, diff, tar);

	}
}
