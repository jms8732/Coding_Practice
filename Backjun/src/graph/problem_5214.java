package graph;

//È¯½Â

import java.util.*;
import java.io.*;

public class problem_5214 {
	static List<Integer> adj[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[M+N];

		for (int i = 0; i < adj.length; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = i + N;
			for(int j =0 ; j <K ; j++) {
				int s = Integer.parseInt(st.nextToken())-1;
				
				adj[s].add(idx);
				adj[idx].add(s);
			}
		}

		bfs(N, K, M);
	}

	private static void bfs(int N, int K, int M) {
		Queue<Integer> q = new LinkedList<>();
		int[] dist = new int[N+1000];
		Arrays.fill(dist, 1000000);

		dist[0] = 1;
		q.add(0);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : adj[cur]) {
				if (dist[next] > dist[cur] + 1) {
					dist[next] = dist[cur] + 1;
					q.add(next);
				}
			}
		}
		
		if(dist[N-1] == 1000000)
			System.out.println(-1);
		else {
			int div = dist[N-1] /2;
			System.out.println(div+1);
		}
	}
}
