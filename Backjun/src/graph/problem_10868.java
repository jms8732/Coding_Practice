package graph;

/*
 * �ּڰ�
 * �������� ���׸�Ʈ Ʈ��
 */
import java.util.*;
import java.io.*;

public class problem_10868 {
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

	// ������ �ش�Ǵ� �ּڰ��� ã�´�.
	private static long find(int start, int end, int idx, int left, int right) {
		if (right < start || left > end) // ������ ��� ���
			return Integer.MAX_VALUE;

		// ������ �������� ���
		if (left <= start && end <= right)
			return tree[idx];

		int mid = (start + end) / 2;
		long temp = Integer.MAX_VALUE;

		temp = Math.min(temp,
				Math.min(find(start, mid, idx * 2, left, right),find(mid + 1, end, idx * 2 + 1, left, right) ));

		return temp;

	}

	// ���׸�Ʈ Ʈ���� ����� �޼ҵ�, ��� ȣ���� �����ϸ鼭 �θ� ��忡 ������ ���� ���� �Ҵ��Ѵ�.
	private static long init(int start, int end, int idx) {
		if (start == end) {
			return tree[idx] = array[start]; // ���� ���
		}

		int mid = (start + end) / 2;

		long ret = Math.min(tree[idx], Math.min(init(start, mid, idx * 2), init(mid + 1, end, idx * 2 + 1)));

		return tree[idx] = ret;

	}
}
