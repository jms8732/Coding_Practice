package search_algorithm;

//비숍
import java.util.*;
import java.io.*;

public class problem_1799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max_bishop(array,N);
	}

	private static void max_bishop(int [][] array, int N) {
		int [][] first = new int[N][N];
		int [][] second = new int[N][N];
		
		int size = 0;
		int start = 1;
		for(int i= 0; i < N ; i++) {
			for(int j =0 ; j < N ; j++) {
				first[i][j] = start + i + j ;
				size=  Math.max(size, first[i][j]);
			}
		}
		
		for(int i = N-1 ; i >= 0 ; i--) {
			for(int j =0 ; j < N ; j++) {
				second[i][j] = start + j ;
			}
			start++;
		}
		
		size += 1;
		List<Integer> adj[] = new ArrayList[size];
		
		for(int i =0 ; i < adj.length ; i++) adj[i] = new ArrayList<>();
		
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < N ; j++) {
				if(array[i][j] == 1) {
					adj[first[i][j]].add(second[i][j]);
				}
			}
		}
		
		
		boolean [] check = new boolean[size];
		int [] idx = new int[size];
		Arrays.fill(idx, -1);
		
		int c = 0;
		for(int i =1 ; i < idx.length ; i++) {
			if(bipartiteMatch(i,idx,adj,check))
				c++;
			Arrays.fill(check, false);
		}
		System.out.println(c);
	}
	
	private static boolean bipartiteMatch(int cur,int[]idx,  List<Integer>[] adj, boolean [] check) {
		
		//현재 정점에 연결된 다른 정점을 찾는다.
		
		for(int next : adj[cur]) {
			//현재 정점이 이미 방문한 경우이면
			if(check[next])
				continue;
			
			check[next] = true;
			
			//현재 정점이 아직 채워져 있지 않거나 채워진 경우 채워진 정점이 다른 정점으로 갈 수 있는지 판단
			if(idx[next] == -1 || bipartiteMatch(idx[next],idx,adj,check)) {
				idx[next] = cur;
				return true;
			}
		}
		
		return false;
	}
	
}
