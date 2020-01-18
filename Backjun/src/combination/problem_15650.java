package combination;

//N과 M(2)
import java.util.*;
import java.io.*;

public class problem_15650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[N];
		int[] array = new int[M];

		int depth = 0, next = 0;
		dfs(depth,next, visited, array);
	}

	private static void dfs(int depth,int next, boolean[] visited, int[] array) {
		if (depth == array.length) {
			print(array);
			return;
		}
		
		for(int i = next; i < visited.length ; i++) {
			if(!visited[i]) {
				//방문하지 않은 경우
				visited[i] = true;
				array[depth] = i+1;
				dfs(depth+1,i+1,visited,array);
				visited[i] = false;
				array[depth] = 0;
				
			}
		}
	}

	private static void print(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
