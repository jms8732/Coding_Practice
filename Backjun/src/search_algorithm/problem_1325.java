package search_algorithm;

//효율적인 해킹
import java.util.*;
import java.io.*;

public class problem_1325 {
	static List<Integer> list[];
	static int count[] ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];
		count = new int[N];

		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			list[s-1].add(e-1);
		}

		simulation(N);
		
		int big =0 ; 
		for(int i : count)
			big = Math.max(i,big);
		
		StringBuilder sb = new StringBuilder();
		for(int i =0 ; i < N ; i++) {
			if(big == count[i])
				sb.append(i+1 + " ");
		}
		
		System.out.println(sb.toString());
	}

	private static void simulation(int n) {
		boolean [] visited = new boolean[n];
		
		for(int i =0 ; i < n ; i++) {
			visited = new boolean[n];
			if(!visited[i]) {
				search(i,visited);
			}
		}

	}

	private static void search(int cur,boolean[] visited) {
		visited[cur] = true;
		
		for(int next : list[cur]) {
			if(!visited[next]) {
				count[next]++;
				search(next,visited);
			}
		}
	}
}
