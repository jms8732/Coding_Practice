package greedy;

/*
 * 공장
 * inversion counting + 세그먼트 트리를 이용해야 한다.
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
		 * Map을 이용하는 이유
		 * 같은 번호의 기계의 인덱스를 파악하기 위해서 사용한다. 
		 * 이중 for문을 이용해서 진행할 경우, 시간 초과가 발생할 수 있다.
		 */
		Map<Integer, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(st.nextToken());
			map.put(target, 0);
		}

		// 출발 지점 넣기
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

	//inversion counting을 진행하여 개수를 센다.
	private static long summation(int start, int end, int idx, int left, int right) {
		if (end < left || start > right)
			return 0; // 범위를 벗어난 경우

		if (left<= start && end <=  right)
			return tree[idx]; // 범위 내인 경우

		int mid = (start + end) / 2;

		return summation(start, mid, idx * 2, left, right) + summation(mid + 1, end, idx * 2 + 1, left, right);
	}

	//현재 위치를 방문했다는 것을 표현
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

		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1]; // 갱신된 값을 반영
	}
}
