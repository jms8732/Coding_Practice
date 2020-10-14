package graph;

/*
 * ����
 * inversion counting + ���׸�Ʈ Ʈ���� �̿��ؾ� �Ѵ�.
 *
 */
import java.util.*;
import java.io.*;

public class problem_7578 {
	static int N;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		tree = new long[N * 4];

		StringTokenizer st = new StringTokenizer(br.readLine());

		/*
		 * Map�� �̿��ϴ� ����
		 * ���� ��ȣ�� ����� �ε����� �ľ��ϱ� ���ؼ� ����Ѵ�. 
		 * ���� for���� �̿��ؼ� ������ ���, �ð� �ʰ��� �߻��� �� �ִ�.
		 */
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(st.nextToken());
			map.put(target, 0);
		}

		// ��� ���� �ֱ�
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(st.nextToken());
			map.put(target, i);
		}

		long sum = 0;
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			int k = m.getKey();
			int v = m.getValue();
		
			sum += summation(0,N-1,1,v+1,N-1);
			update(0,N-1,1,v);
			
		}

		System.out.println(sum);
	}

	//inversion counting�� �����Ͽ� ������ ����.
	private static long summation(int start, int end, int idx, int left, int right) {
		if (end < left || start > right)
			return 0; // ������ ��� ���

		if (left<= start && end <=  right)
			return tree[idx]; // ���� ���� ���

		int mid = (start + end) / 2;

		return summation(start, mid, idx * 2, left, right) + summation(mid + 1, end, idx * 2 + 1, left, right);
	}

	//���� ��ġ�� �湮�ߴٴ� ���� ǥ��
	private static void update(int start, int end, int idx, int pos) {
		if(pos < start || end < pos)
			return;
		
		if (start == end) {
			tree[idx] = 1;
			return;
		}

		int mid = (start + end) / 2;
		update(start, mid, idx * 2, pos);
		update(mid + 1, end, idx * 2 + 1, pos);

		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1]; // ���ŵ� ���� �ݿ�
	}
}
