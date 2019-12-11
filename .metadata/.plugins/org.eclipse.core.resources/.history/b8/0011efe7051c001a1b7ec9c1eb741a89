package dfs;
import java.util.*;

public class problem_10265 {
	static int[] map;
	static boolean[] visited, finish;
	static int count;
	static int totalCount = 0;
	static int componentCount = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		map = new int[N];
		visited = new boolean[N];
		finish = new boolean[N];
		int K = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			int tmp = scanner.nextInt();
			map[i] = tmp - 1;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i] && !finish[i]) {
				visited = new boolean[N];
				finish = new boolean[N];
				DFS(i);
				if(count <= K) {
					if(componentCount == count) {
						if((totalCount + count) <= K)
							totalCount += count;
						else
							totalCount = compare(totalCount,count);
					}
					else if(count <= K && K <=componentCount)
						totalCount = K;
					else if(count <= K && componentCount <= K) {
						totalCount = compare(compare(count,componentCount),totalCount);
					}
				}
				count = 0;
				componentCount = 0;
			}
		}
		System.out.println(totalCount);
	}

	static void DFS(int idx) {
		visited[idx] = true;
		int next = map[idx];

		if (!visited[next]) {
			DFS(next);
		} else {
			if (!finish[idx]) {
				for (int n = map[idx]; n != idx; n = map[n])
					count++;
				count++;
			}
		}
		componentCount++;
		finish[idx] = true;
	}
	static int compare(int a , int b) {
		return a > b ? a : b;
	}
}
