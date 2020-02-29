package graph;

import java.util.*;
import java.io.*;

public class problem_13023 {
	static List<Integer> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];

		for(int i =0 ; i < N ; i++) list[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			list[s].add(e);
			list[e].add(s);
		}
		boolean[] visited = new boolean[N];
		int depth = 1;
		for (int i = 0; i < list.length; i++) {
			if (!list[i].isEmpty()) {
				visited[i] = true;
				findFriend(depth, i, visited);
				visited[i] = false;
			}
		}

		System.out.println(0);
	}

	private static void findFriend(int depth, int cur, boolean[] visited) {
		if (depth == 5) {
			System.out.println(1);
			System.exit(0);
		}

		for (int i = 0; i < list[cur].size(); i++) {
			int next = list[cur].get(i);
			if (!visited[next]) {
				visited[next] = true;
				findFriend(depth + 1, next, visited);
				visited[next] = false;
			}
		}

	}
}
