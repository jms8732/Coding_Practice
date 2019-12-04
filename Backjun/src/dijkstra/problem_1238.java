package dijkstra;
//파티

import java.util.*;
import java.io.*;

public class problem_1238 {
	static int start = 0;
	static int N = 0, M = 0;
	static BufferedReader br;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // n
			M = Integer.parseInt(st.nextToken()); // m
			start = Integer.parseInt(st.nextToken()) - 1;

			int big = dijkstra(start);
			System.out.println(big);
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static int dijkstra(int start) throws IOException {
		int dist[] = new int[N];
		Arrays.fill(dist, INF);
		List<Node> list[] = new ArrayList[N];
		dist[start] = 0;
		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());

			list[s].add(new Node(e, d));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if (arg0.distance < arg1.distance)
					return -1;
				else
					return 1;
			}

		});

		// 목적지에서 각각의 위치로 되돌아가는 최소 경로
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node tmp = pq.poll();
			int idx = tmp.idx;
			int distance = tmp.distance;
			for (Node ne : list[idx]) {
				int nextIdx = ne.idx;
				int nextDistance = dist[idx] + ne.distance;
				if (dist[nextIdx] > nextDistance) {
					dist[nextIdx] = nextDistance;
					pq.add(new Node(nextIdx, dist[nextIdx]));
				}
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			int dist1[] = new int[N];
			pq.clear();
			Arrays.fill(dist1, INF);
			if(i == start)
				continue;
			
			dist1[i] = 0;
			pq.add(new Node(i,0));
			
			while(!pq.isEmpty()) {
				Node tmp = pq.poll();
				int idx = tmp.idx;
				int distance = tmp.distance;
				for (Node ne : list[idx]) {
					int nextIdx = ne.idx;
					int nextDistance = dist1[idx] + ne.distance;
					if (dist1[nextIdx] > nextDistance) {
						dist1[nextIdx] = nextDistance;
						pq.add(new Node(nextIdx, dist1[nextIdx]));
					}
				}
			}
			
			dist[i] += dist1[start];
		}
		int big = 0;
		for(int i =0 ; i< dist.length ; i++) {
			big = Math.max(big, dist[i]);
		}
		return big;
	}

	private static class Node {
		int idx, distance;

		public Node(int i, int d) {
			this.idx = i;
			this.distance = d;
		}
	}
}
