package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M(6)
public class problem_15655 {
	public static void main(String[] args)throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [] array = new int[M];
		int [] value = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i =0 ; i< value.length ;i++) value[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(value); //오름차순으로 정렬
		
		int depth = 0;
		dfs(depth,0,value,array);
	}
	private static void dfs(int depth,int next, int [] value, int [] array) {
		if(depth == array.length) {
			print(array);
			return;
		}
		
		for(int i = next; i< value.length ; i++) {
			array[depth] = value[i];
			dfs(depth+1,i+1,value,array);
		}
		
	}
	
	private static void print(int[] array) {
		for(int i : array)
			System.out.print(i + " ");
		System.out.println();
	}
}
