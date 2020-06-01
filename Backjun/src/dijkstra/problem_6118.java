package dijkstra;

//¼û¹Ù²ÀÁú
import java.util.*;
import java.io.*;

public class problem_6118 {
	static List<Integer> adj [];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		adj=  new ArrayList[N];
		for(int i =0 ; i < N ; i++) adj[i] = new ArrayList<>();
		
		for(int i =0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) -1;
			int e = Integer.parseInt(st.nextToken()) -1;
			
			adj[s].add(e);
			adj[e].add(s);
		}
		
		dijkstra(N);
	}
	private static void dijkstra(int N) {
		int dist[]  = new int[N];
		Arrays.fill(dist, 1000000000);
		dist[0] = 0;
		
		Queue<Integer> q= new LinkedList<>();
		q.add(0);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next : adj[cur]) {
				if(dist[next] > dist[cur] + 1) {
					dist[next] = dist[cur] +1;
					q.add(next);
				}
			}
		}
		
		int big = 0;
		for(int i =0 ; i < N ; i++)
			big = Math.max(big, dist[i]);
		
		int answer_count = 0;
		for(int i =0 ; i <N  ;i++) {
			if(big == dist[i])
				answer_count++;
		}
		
		int answer_idx = 0;
		
		for(int i =0 ; i < N ; i++) {
			if(big == dist[i]) {
				answer_idx = i+1;
				break;
			}
		}
		
		System.out.println(answer_idx + " " + big + " " + answer_count);
	}
}
