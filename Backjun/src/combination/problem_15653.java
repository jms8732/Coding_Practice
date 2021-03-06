package combination;

//N과 M(5)
import java.util.*;
import java.io.*;

public class problem_15653 {
	public static void main(String[] args)throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] array = new int[M];
		int [] value = new int[N];
		boolean [] visited= new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i =0 ; i< value.length ;i++) value[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(value); //오름차순으로 정렬
		
		int depth = 0;
		dfs(depth,value,array,visited);
	}
	private static void dfs(int depth, int [] value, int [] array,boolean[] visited) {
		if(depth == array.length) {
			print(array);
			return;
		}
		
		for(int i =0 ; i< visited.length ; i++) {
			if(!visited[i]) {
				//방문하지 않은 곳이라면
				visited[i] = true;
				array[depth] = value[i];
				dfs(depth+1,value,array,visited);
				visited[i] = false;
				
			}
		}
		
	}
	
	private static void print(int[] array) {
		for(int i : array)
			System.out.print(i + " ");
		System.out.println();
	}
}
