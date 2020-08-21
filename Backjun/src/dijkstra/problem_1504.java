package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//특정한 경로
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class problem_1504 {
	static List<Node> adj[];
	static int N, E, INF = 100000000, answer = INF;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N];
		for (int i = 0; i < N; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());

			adj[v1 - 1].add(new Node(v2 - 1, dis));
			adj[v2 - 1].add(new Node(v1 - 1, dis));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken()) - 1;
		int v2 = Integer.parseInt(st.nextToken()) - 1;

		int[] array = new int[] { v1, v2 };

		permutation(array, 0);
		if (answer == INF)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	private static void permutation(int[] array, int depth) {
		if (depth == array.length) {
			int temp_array[] = new int[] { array[0], array[1], N - 1 };
			int temp = 0;
			int start = 0;

			for (int end : temp_array) {
				temp += dijkstra(start, end);
				start = end;
			}

			answer = Math.min(Math.min(answer, temp), INF);
			return;
		}

		for (int i = depth; i < array.length; i++) {
			swap(array, i, depth);
			permutation(array, depth + 1);
			swap(array, i, depth);
		}
	}

	private static void swap(int[] array, int i, int depth) {
		int temp = array[i];
		array[i] = array[depth];
		array[depth] = temp;
	}

	private static int dijkstra(int start, int end) {
		if (start == end)
			return 0;

		int[] dist = new int[N];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			for (Node next : adj[cur.v]) {
				if (dist[next.v] > dist[cur.v] + next.cost) {
					dist[next.v] = dist[cur.v] + next.cost;
					pq.add(new Node(next.v, dist[next.v]));
				}
			}
		}

		return dist[end];
	}

	private static class Node implements Comparable<Node> {
		int v, cost;

		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node arg0) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, arg0.cost);
		}

	}
}
