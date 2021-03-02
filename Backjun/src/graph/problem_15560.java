package graph;

//구간 합 최대?1
import java.util.*;
import java.io.*;

public class problem_15560 {
	static Node[] segtree;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		int[] array = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		segtree = new Node[n * 4];
		init(0, n - 1, 1, array);

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (c == 0) {
				int[]  result = query0(a - 1, b - 1, 0, n - 1, 1, u, v);
				int ans = Math.max(result[0], result[1]*u + (b-a) * v);
				System.out.println(ans);
			} else {
				array[a - 1] = b;
				query1(0, n - 1, 1, array);
			}

		}
	}

	private static int query1(int start, int end, int idx, int[] array) {
		if (start == end) {
			return segtree[idx].cost = array[start];
		}

		int mid = (start + end) / 2;
		int c1 = query1(start, mid, 2 * idx, array);
		int c2 = query1(mid + 1, end, 2 * idx + 1, array);

		return segtree[idx].cost = c1 + c2;
	}

	private static int[] query0(int a, int b, int start, int end, int idx, int u, int v) {

		// 범위 밖인 경우
		if (end < a || start > b)
			return new int[] {Integer.MIN_VALUE,0};

		// 범위내에 있는 경우
		if (a <= start && end <= b) {
			return new int[] {segtree[idx].cost*u + (end-start) * v,segtree[idx].cost};
		}

		int mid = (start + end) / 2;
		int[] c1 = query0(a, b, start, mid, 2 * idx, u, v);
		int[] c2 = query0(a, b, mid + 1, end, 2 * idx + 1, u, v);

		int ret = Math.max(c1[0],c2[0]);
	
		return new int[] {ret,c1[1] + c2[1]};
	}

	private static void init(int start, int end, int idx, int[] array) {
		if (start == end) {
			segtree[idx] = new Node(start, end, array[start]);
			return;
		}

		int mid = (start + end) / 2;
		init(start, mid, 2 * idx, array);
		init(mid + 1, end, 2 * idx + 1, array);

		segtree[idx] = new Node(start, end, segtree[2 * idx].cost + segtree[2 * idx + 1].cost);
	}

	private static class Node {
		int start, end, cost;

		public Node(int s, int e, int c) {
			this.start = s;
			this.end = e;
			this.cost = c;
		}
	}
}
