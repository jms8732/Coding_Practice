package others;

/*
 * Ŀ�� ��2
 * ���׸�Ʈ Ʈ���� �̿�
 */
import java.util.*;
import java.io.*;

public class problem_1275 {
	static long[] tree, array;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		array = new long[N];
		tree = new long[N * 4];

		// �ʱ�ȭ
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		init(0, N - 1, 1);

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int temp = 0;

			//��Ʈ�� Ȯ���ϸ� x > y �� �Է� ���� �־��� �� �ִ�. ����, Ž���� ��Ȱ�� �����ϱ� ���ؼ� swap�� �����Ѵ�.
			if (start > end) {
				temp = end;
				end = start;
				start = temp;
			}

			bw.write(summation(start, end, 0, N - 1, 1) + "\n");

			int change_idx = Integer.parseInt(st.nextToken()) - 1;
			long diff = Long.parseLong(st.nextToken()) - array[change_idx];

			array[change_idx] += diff;
			update(change_idx, diff, 0, N - 1, 1);
		}

		bw.flush();
	}

	// �ش� ���ڸ� �����ϱ� ���� �޼ҵ�
	private static void update(int change_idx, long diff, int left, int right, int idx) {
		if (change_idx < left || change_idx > right) // ������ ��� ���
			return;

		tree[idx] += diff; //���� ���� ���ϸ鼭 �κ����� ������ ����.

		if (left == right) {
			return;
		}

		int mid = (left + right) / 2;
		update(change_idx, diff, left, mid, idx * 2);
		update(change_idx, diff, mid + 1, right, idx * 2 + 1);

	}

	// ������ �κ����� ���ϴ� �޼ҵ�
	private static long summation(int start, int end, int left, int right, int idx) {
		if (end < left || start > right) // ������ ��� ���
			return 0;

		if (start <= left && right <= end) // ���� ���� ������ ���
			return tree[idx];

		int mid = (left + right) / 2;

		return summation(start, end, left, mid, idx * 2) + summation(start, end, mid + 1, right, idx * 2 + 1);
	}

	// ���׸�Ʈ Ʈ�� ����
	private static void init(int left, int right, int idx) {
		if (left == right) {
			tree[idx] = array[left];
			return;
		}

		int mid = (left + right) / 2;
		init(left, mid, idx * 2); // ���� �ڽ�
		init(mid + 1, right, idx * 2 + 1); // ������ �ڽ�

		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1]; // �θ� ��忡 �ڽ� ����� ���� ����
	}
}
