package graph;

/*
 * 최솟값
 * 전형적인 세그먼트 트리
 */
import java.util.*;
import java.io.*;

public class problem_10686 {
	static long[] tree, array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		tree = new long[N * 4];
		Arrays.fill(tree, Integer.MAX_VALUE);
		array = new long[N];
		for (int i = 0; i < N; i++)
			array[i] = Long.parseLong(br.readLine());

		init(0, N - 1, 1);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			bw.write(find(0, N - 1, 1, a, b) + "\n");
		}
		bw.flush();
	}

	// 범위에 해당되는 최솟값을 찾는다.
	private static long find(int start, int end, int idx, int left, int right) {
		if (right < start || left > end) // 범위를 벗어난 경우
			return Integer.MAX_VALUE;

		// 범위에 속해있을 경우
		if (left <= start && end <= right)
			return tree[idx];

		int mid = (start + end) / 2;
		long temp = Integer.MAX_VALUE;

		temp = Math.min(temp,
				Math.min(find(start, mid, idx * 2, left, right),find(mid + 1, end, idx * 2 + 1, left, right) ));

		return temp;

	}

	// 세그먼트 트리를 만드는 메소드, 재귀 호출을 진행하면서 부모 노드에 범위의 작은 값을 할당한다.
	private static long init(int start, int end, int idx) {
		if (start == end) {
			return tree[idx] = array[start]; // 같을 경우
		}

		int mid = (start + end) / 2;

		long ret = Math.min(tree[idx], Math.min(init(start, mid, idx * 2), init(mid + 1, end, idx * 2 + 1)));

		return tree[idx] = ret;

	}
}
