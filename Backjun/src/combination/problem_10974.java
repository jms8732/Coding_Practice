package combination;

//모든 순열
import java.io.*;
import java.util.*;

public class problem_10974 {
	static boolean visited[]; //순서를 유지하기 위해서 visited 이용
	static int N;
	public static void main(String[] args) {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		try {
		N = Integer.parseInt(br.readLine());
		visited= new boolean[N];
		int [] array= new int[N];
		int [] value = new int[N];
		for(int i=0 ; i < N ; i++)
			array[i] = i+ 1;
		
		int depth =0 ;
		for(int i = 0; i < N ; i++) {
			if(!visited[i])
			{
				visited[i] = true;
				value[depth] = array[i];
				dfs(array,value,depth+1);
				visited[i] = false;
			}
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void dfs(int[] array,int [] value, int depth) {
		if(depth == array.length) {
			print(value);
		}
		
		for(int i = 0 ; i < array.length ; i++) {
			if(!visited[i])
			{
				visited[i]=true;
				value[depth]= array[i];
				dfs(array,value,depth+1);
				visited[i] = false;
			}
		}
	}
	
	private static void print(int[] array) {
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
