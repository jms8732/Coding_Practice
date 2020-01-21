package combination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//N°ú M(8)
public class problem_15657 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] value = new int[N];
		int[] array = new int[M];

		st = new StringTokenizer(br.readLine());

		
		for (int i = 0; i < value.length; i++)
			value[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(value);
		int depth = 0, idx = 0;
		dfs(depth,idx, value, array);

		br.close();
	}

	private static void dfs(int depth, int idx , int [] value ,int [] array) {
		if(depth == array.length)
		{
			print(array);
			return;
		}
		
		if(idx == value.length)return;
		
		array[depth] = value[idx];
		dfs(depth+1,idx,value,array);
		dfs(depth,idx+1,value,array);
	}
	
	private static void print(int [] array) {
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
