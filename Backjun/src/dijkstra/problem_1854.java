package dijkstra;

//K번째 최단 경로 찾기
import java.util.*;
import java.io.*;

public class problem_1854 {
	static List<Node> adj[];
	static PriorityQueue<Integer> result[];
	static int INF = 10000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N];
		result = new PriorityQueue[N];

		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList<>();
			result[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());

			adj[x1].add(new Node(x2, c));
		}

		simulation(N, K);

		for (PriorityQueue<Integer> pq : result) {
			if(pq.size() == K) {
				System.out.println(pq.peek());
			}else
				System.out.println(-1);
		}
	}

	private static void simulation(int N, int K) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				return Integer.compare(arg0.cost, arg1.cost);
			}

		});

		pq.add(new Node(0, 0));
		result[0].add(0);

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (Node next : adj[cur.x]) {
				if (result[next.x].size() < K) {
					result[next.x].add(cur.cost + next.cost);
					pq.add(new Node(next.x, cur.cost + next.cost));
				} else if (result[next.x].peek() > cur.cost + next.cost) {
					result[next.x].poll();
					result[next.x].add(cur.cost + next.cost);
					pq.add(new Node(next.x,cur.cost + next.cost));
				}
			}
		}
	}

	private static class Node {
		int x, cost;

		public Node(int x, int c) {
			this.x = x;
			this.cost = c;
		}
	}
}
