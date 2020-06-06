package search_algorithm;

//중량 제한
import java.util.*;
import java.io.*;

public class problem_1939 {
	static List<Node> adj[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N];
		for (int i = 0; i < N; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;

			int capacity = Integer.parseInt(st.nextToken());

			adj[s].add(new Node(e, capacity));
			adj[e].add(new Node(s, capacity));
		}

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken()) - 1;
		int e = Integer.parseInt(st.nextToken()) - 1;

		simulation(N, s, e);
	}

	private static void simulation(int N , int s, int e) {
		int left = 0; 
		int right = 1000000000;
		
		
		while(left <= right) {
			int mid = (left + right ) /2;
			
			if(BFS(mid,s,e,N))
				left = mid +1;
			else
				right = mid -1;
		}
		System.out.println(left-1);
	}
	
	private static boolean BFS(int mid , int s, int e, int N) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(s,0));
		boolean[]  visited = new boolean[N];
		
		while(!q.isEmpty()) {
			
			Node cur = q.poll();
			
			visited[cur.e] = true;
			
			if(cur.e == e)
				return true;
			
			for(Node n : adj[cur.e]) {
				if(!visited[n.e] && n.capacity >= mid) {
					visited[n.e]= true;
					q.add(n);
				}
			}
		}
		
		return false;
	}

	private static class Node {
		int e, capacity;

		public Node(int e, int c) {
			this.e = e;
			this.capacity = c;
		}
	}
}
