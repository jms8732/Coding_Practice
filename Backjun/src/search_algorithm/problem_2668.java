package search_algorithm;

//숫자 고르기
import java.util.*;
import java.io.*;

public class problem_2668 {
	static boolean[] visited, circle;
	static int[] array;
	static List<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()) + 1;

		array = new int[N];

		for (int i = 1; i < N; i++)
			array[i] = Integer.parseInt(br.readLine());

		visited = new boolean[N];
		circle = new boolean[N];
		list = new ArrayList<>();
		
		for(int i = 1; i < N ; i++) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for(int i: list)
			System.out.println(i);
	}

	private static void dfs(int cur) {

		int next = array[cur];
		visited[cur] = true;

		if (!visited[next]) {
			dfs(next);
		}else {
			if(!circle[next]) {
				for(int i = next ; cur != i ; i= array[i]) {
					list.add(i);
				}
				list.add(cur);
			}
		}
		
		circle[cur] = true;
	}
}
