package dfs;
import java.util.*;

public class problem_11724 {
	static int map[][];
	static int N,M;
	static boolean visited[];
	static int count = 0;
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		map = new int[N+2][N+2];
		visited = new boolean[N+2];
		Arrays.fill(visited,false);
		for(int i= 0 ; i < M ; i++) {
			int v1 = scanner.nextInt();
			int v2 =scanner.nextInt();
			
			map[v1][v2] = map[v2][v1] = 1; //무방향 간선	
		}
		for(int i = 1 ; i< map.length; i++) {
				if(!visited[i]) {
					DFS(i);
					count++;
				}
			}
		System.out.println(count- 1);
	}
	static void DFS(int idx) {
		visited[idx]  =true;
			for(int j = 1;  j< map[idx].length ; j++) {
				if(map[idx][j] != 0) {
				//	int next = map[idx][j];
					if(!visited[j]) {
						DFS(j);
					}
				}
			}
		
		return;
	}
}
