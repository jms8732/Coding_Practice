package others;

/*
 * 커피 숍2
 * 세그먼트 트리를 이용
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

		// 초기화
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		init(0, N - 1, 1);

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int temp = 0;

			//노트를 확인하면 x > y 로 입력 값이 주어질 수 있다. 따라서, 탐색을 원활히 진행하기 위해서 swap을 진행한다.
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

	// 해당 숫자를 갱신하기 위한 메소드
	private static void update(int change_idx, long diff, int left, int right, int idx) {
		if (change_idx < left || change_idx > right) // 범위를 벗어난 경우
			return;

		tree[idx] += diff; //차이 값을 더하면서 부분합을 갱신해 간다.

		if (left == right) {
			return;
		}

		int mid = (left + right) / 2;
		update(change_idx, diff, left, mid, idx * 2);
		update(change_idx, diff, mid + 1, right, idx * 2 + 1);

	}

	// 구간의 부분합을 구하는 메소드
	private static long summation(int start, int end, int left, int right, int idx) {
		if (end < left || start > right) // 범위를 벗어난 경우
			return 0;

		if (start <= left && right <= end) // 범위 내에 존재한 경우
			return tree[idx];

		int mid = (left + right) / 2;

		return summation(start, end, left, mid, idx * 2) + summation(start, end, mid + 1, right, idx * 2 + 1);
	}

	// 세그먼트 트리 구성
	private static void init(int left, int right, int idx) {
		if (left == right) {
			tree[idx] = array[left];
			return;
		}

		int mid = (left + right) / 2;
		init(left, mid, idx * 2); // 왼쪽 자식
		init(mid + 1, right, idx * 2 + 1); // 오른쪽 자식

		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1]; // 부모 노드에 자식 노드의 합을 저장
	}
}
