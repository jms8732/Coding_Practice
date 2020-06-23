package greedy;

//ец╧Х
import java.util.*;
import java.io.*;

public class problem_8980 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int capacity = Integer.parseInt(st.nextToken());

		int[] town_capacity = new int[N];
		Arrays.fill(town_capacity, capacity);

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub

				if (arg0.end < arg1.end)
					return -1;
				else if (arg0.end == arg1.end) {
					if (arg0.start < arg1.start)
						return -1;
					else
						return 1;
				} else
					return 1;
			}
		});

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken());

			pq.add(new Node(s, e, v));
		}

		int delivery = 0;
		while (!pq.isEmpty()) {
			int possible = Integer.MAX_VALUE;
			Node cur = pq.poll();

			for (int i = cur.start; i < cur.end; i++) {
				possible = Math.min(possible, town_capacity[i]);
			}

			int w = Math.min(cur.vol, possible);

			delivery += w;
			for (int i = cur.start; i < cur.end; i++) {
				town_capacity[i] -= w;
			}
		}
		System.out.println(delivery);
	}

	private static class Node {
		int start, end, vol;

		public Node(int s, int e, int v) {
			this.start = s;
			this.end = e;
			this.vol = v;
		}
	}
}
