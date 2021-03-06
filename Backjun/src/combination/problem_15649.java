package combination;

//N과 M(1)
import java.util.*;
import java.io.*;
public class problem_15649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean [] visited=  new boolean[N];
		int [] array = new int[M];
		int depth = 0;
		permutation(depth, N,M,array, visited);
	}
	
	private static void permutation(int depth, int N,int M,int[] array, boolean[] visited) {
		if(depth == array.length) {
			print(array);
			return;
		}
		
		
		for(int i =0 ; i< visited.length ; i++) {
			if(!visited[i]) {
				//방문하지 않은 곳이있다면
				visited[i] = true;
				array[depth] = i+1;
				permutation(depth+1,N,M,array,visited);
				array[depth] = 0;
				visited[i] = false;
			}
		}
	}
	private static void print(int[] array) {
		for(int i  : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
