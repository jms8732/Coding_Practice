package graph;

/*
 * 선수 과목
 * 위상정렬의 기본적인 예시
 * 위상정렬을 진행할 때마다 해당 과목의 학기 수를 증가시키면 된다.
 */

import java.util.*;
import java.io.*;

public class problem_14567 {
	static List<Integer> adj [];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[n];
		
		for(int i =0 ; i < n ; i++) adj[i] = new ArrayList<>();
		
		for(int i =0 ; i < m ; i++) {
			st=  new StringTokenizer(br.readLine());
			
			int f = Integer.parseInt(st.nextToken())-1;
			int l = Integer.parseInt(st.nextToken())-1;
			
			adj[f].add(l);
		}
		
		topologySort(n);
	}
	
	private static void topologySort(int n ) {
		int [] degree = new int[n];
		
		for(int i =0 ; i < n ; i++) {
			for(int f : adj[i]) {
				degree[f]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i =0 ; i < degree.length ; i++) {
			if(degree[i] == 0)
				q.add(i);
		}
		
		
		int ans [] = new int[n];
		Arrays.fill(ans, 1);
		
		for(int i =0 ; i < n ; i++) {
			if(q.isEmpty())
				break;
			
			int cur = q.poll();
			
			for(int aj : adj[cur]) {
				degree[aj]--;
				
				if(degree[aj] == 0) {
					q.add(aj);
					ans[aj] = ans[cur] + 1;
				}
			}
		}
		
		for(int i : ans)
			System.out.print(i + " ");
	}

}
