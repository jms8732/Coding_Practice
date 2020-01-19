package combination;

//N°ú M (4)
import java.util.*;
import java.io.*;

public class problem_15652 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		int [] array = new int[M];
		dfs(0,1,N,array);
	}
	private static void dfs(int depth,int value, int N , int [] array) {
		if(depth == array.length)
		{
			print(array);
			return;
		}
		
		if(value > N)
			return;
		array[depth]= value;
		dfs(depth+1,value,N,array);
		dfs(depth,value+1,N,array);
	}
	private static void print (int [] array) {
		for(int i : array)
			System.out.print(i + " ");
		System.out.println();
	}
}
