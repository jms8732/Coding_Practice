package graph;

/*
 * 히스토그램에서 가장 큰 직사각형
 * 세그먼트 트리를 이용해서 문제를 해결한다.
 * 
 */
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class problem_6549 {
	static int[] tree; //범위에서 가장 작은 높이를 가지는 인덱스를 저장하는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		while (true) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			if (N == 0)
				break;

			long[] height = new long[N];
			tree = new int[N * 4];
			// 높이 저장
			for (int i = 0; i < N; i++)
				height[i] = Long.parseLong(st.nextToken());

			init(height, 0, N - 1, 1); // 세그먼트 트리를 만드는 과정
			System.out.println(find_largest(height, 0, N - 1));
		}

		bw.flush();
	}

	/*
	 * 범위를 돌면서 히스토그램의 넓이를 구한다.
	 * BigInteger를 사용한 이유는 long 형을 벗어난 값이 생길 수 있어서 BigInteger를 이용한다.
	 */
	private static BigInteger find_largest(long[] height, int start, int end) {
		int N = height.length - 1;
		int m = query(height, 1, 0, N, start, end);
		BigInteger ret = new BigInteger(String.valueOf(height[m] * (end - start + 1)));

		//왼쪽
		if (start <= m - 1) {
			BigInteger temp = find_largest(height, start, m - 1);
			if (ret.compareTo(temp) < 0)
				ret = temp;
		}

		//오른쪽
		if (end >= m + 1) {
			BigInteger temp = find_largest(height, m + 1, end);
			if (ret.compareTo(temp) < 0)
				ret = temp;
		}

		return ret;
	}

	private static int query(long[] height, int idx, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return -1;
		}

		if (left <= start && end <= right) {
			return tree[idx];
		}

		int mid = (start + end) / 2;
		int q1 = query(height, idx * 2, start, mid, left, right);
		int q2 = query(height, idx * 2 + 1, mid + 1, end, left, right);

		if (q1 == -1)
			return q2;
		else if (q2 == -1)
			return q1;
		else {
			if (height[q1] <= height[q2])
				return q1;
			else
				return q2;
		}
	}

	//분할 정복을 이용하여 범위 내에 가장 작은 값을 가지는 인덱스를 저장한다.
	private static void init(long[] height, int start, int end, int idx) {
		if (start == end) {
			tree[idx] = start;
			return;
		}

		int mid = (start + end) / 2;
		init(height, start, mid, idx * 2);
		init(height, mid + 1, end, idx * 2 + 1);

		// 최소 인덱스를 저장
		if (height[tree[idx * 2]] <= height[tree[idx * 2 + 1]]) {
			tree[idx] = tree[idx * 2];
		} else
			tree[idx] = tree[idx * 2 + 1];

	}
}
