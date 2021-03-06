package combination;

//수들의 합2
import java.util.*;
import java.io.*;

public class problem_2003 {
	static int N, M;
	static int count;
	static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		array = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int depth = 0;
		for(int i =0 ; i< N ; i++) {
			dfs(i+1,array[i]);
		}
		System.out.println(count);
	}

	private static void dfs(int depth, int value) {
		if(value >= M) { //원하는 값보다 클 경우 반환
			if(value == M)
				count++;
			return;
		}
		
		if(depth == N)
			return;
		
		dfs(depth+1,value+array[depth]);
		
		
	}

}
