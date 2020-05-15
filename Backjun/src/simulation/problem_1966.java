package simulation;

//프린터 큐
import java.util.*;
import java.io.*;

public class problem_1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Queue<Node> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cur = Integer.parseInt(st.nextToken());
				q.add(new Node(j, cur));
				pq.add(cur);
			}

			simulation(q, pq, M);
		}
	}

	private static void simulation(Queue<Node> q, PriorityQueue<Integer> pq, int M) {

		int print_num = 1;
		int num = pq.poll();
		
		while (!q.isEmpty()) {
			Node cur =q.poll();
			if (num == cur.num) {
				if (cur.idx == M) {
					System.out.println(print_num);
					break;
				}
				print_num++;
				num = pq.poll();
			} else {
				q.add(cur);
			}

		}

	}

	private static class Node {
		int idx, num;

		public Node(int i, int n) {
			this.idx = i;
			this.num = n;
		}
	}
}
