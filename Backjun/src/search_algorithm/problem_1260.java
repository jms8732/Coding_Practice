package search_algorithm;

//DFS와 BFS
import java.util.*;
import java.io.*;

public class problem_1260 {
	static List<Integer> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			list[v1].add(v2);
			list[v2].add(v1);
		}
		for(int i =0 ; i< N+1 ; i++) Collections.sort(list[i]);
		
		boolean[] visited = new boolean[N+1];
		List<Integer> answer = new ArrayList<>();
		answer.add(start);
		
		dfs(start,answer,visited);
		print(answer);
		
		Arrays.fill(visited, false);
		answer.clear();
		answer.add(start);
		bfs(start,visited,answer);
		
	}
	private static void bfs(int start, boolean[] visited, List<Integer> answer) {
		Queue<Integer> queue = new LinkedList<>();
		for(int i =0 ; i < list[start].size() ; i++) {
			if(list[start].get(i) != 0)
				queue.add(list[start].get(i));
		}
		
		visited[start] = true;
	
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			if(!visited[current] && current != 0) {
				//현재 노드가 방문하지 않았다면
				visited[current] = true;
				answer.add(current);
				for(int i =0 ; i < list[current].size() ; i++) {
					int next = list[current].get(i);
					if(!visited[next] && current != 0)
						queue.add(next);
				}
			}
		}
		
		print(answer);
	}
	
	private static void dfs(int current,List<Integer> answer, boolean[] visited) {
		visited[current] = true;

		for (int i = 0; i < list[current].size(); i++) {
			int next = list[current].get(i);
			if (!visited[next]) {
				answer.add(next);
				dfs(next,answer,visited);
			}
		}
	}
	
	private static void print(List<Integer> array) {
		for(int i =0 ; i < array.size(); i++) {
			System.out.print(array.get(i) + " " );
		}
		System.out.println();
	}
}
