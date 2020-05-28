package search_algorithm;

//상근이의 여행
import java.util.*;
import java.io.*;

public class problem_9372 {
	static List<Integer> adj[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			adj = new ArrayList[N];

			for (int j = 0; j < N; j++)
				adj[j] = new ArrayList<>();

			int M = Integer.parseInt(st.nextToken());

			for (int k = 0; k < M; k++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;

				adj[s].add(e);
				adj[e].add(s);

			}

			dijkstra(N);
		}
	}

	private static void dijkstra(int N) {
		Queue<Integer> q = new LinkedList<>();

		int[] dist = new int[N];
		Arrays.fill(dist, 1000000);

		q.add(0);
		dist[0] = 0;

		int answer = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : adj[cur]) {
				if (dist[next] > dist[cur] + 1) {
					dist[next] = dist[cur] + 1;
					answer++;
					q.add(next);
				}
			}
		}

		System.out.println(answer);

	}

}
