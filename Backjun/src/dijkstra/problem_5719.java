package dijkstra;

//거의 최단 경로
import java.util.*;
import java.io.*;

public class problem_5719 {
	static List<Node> adj[];
	static List<Integer> track[];
	static int INF = 100000000;
	static int[][] weight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			if (N == 0 && M == 0)
				break;

			adj = new ArrayList[N];
			track = new ArrayList[N];
			weight = new int[N][N];

			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
				track[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int v1 = Integer.parseInt(st.nextToken());
				int v2 = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());

				adj[v1].add(new Node(v2, w));
				weight[v1][v2] = w;
			}

			int min = dijkstra(s, e, N);
			List<Integer> list = new ArrayList<>();
			list.add(e);
			trackback(e, s, min, list);

			int result = 0;
			if ((result = dijkstra(s, e, N)) == INF)
				System.out.println(-1);
			else
				System.out.println(result);
		}
	}

	private static void trackback(int cur, int start, int min, List<Integer> list) {
		if (min == 0) {
			if (cur == start) {
				Collections.reverse(list);

				for (int i = 0; i < list.size() - 1; i++) {
					for (Node j : adj[list.get(i)]) {
						if (j.p == list.get(i + 1)) {
							adj[list.get(i)].remove(j);
							break;
						}
					}
				}

				Collections.reverse(list);
			}

			return;
		}

		for (int pre : track[cur]) {
			if (min - weight[pre][cur] >= 0) {
				list.add(pre);
				trackback(pre, start, min - weight[pre][cur], list);
				list.remove(list.size() - 1);
			}
		}
	}

	private static int dijkstra(int start, int end, int N) {

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if (arg0.w < arg1.w)
					return -1;
				else
					return 1;
			}

		});

		int[] dist = new int[N];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (Node next : adj[cur.p]) {
				if (dist[next.p] >= dist[cur.p] + next.w) {
					track[next.p].add(cur.p);
					dist[next.p] = dist[cur.p] + next.w;
					pq.add(new Node(next.p, dist[next.p]));
				}
			}
		}

		return dist[end];
	}

	private static class Node {
		int p, w;

		public Node(int p, int w) {
			this.w = w;
			this.p = p;
		}
	}
}
