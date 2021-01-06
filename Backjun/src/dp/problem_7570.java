package dp;

/*
 * �� �����(DP)
 * ���������� �����ϴ� �κ� ������ ���̸� ã�´�.
 * 
 */
import java.util.*;
import java.io.*;

public class problem_7570 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] cache= new int[N+1];
		int max = 0;
		for(int i =1 ; i < cache.length ; i++) {
			int k =  Integer.parseInt(st.nextToken());
			cache[k] = cache[k-1] + 1;
			max = Math.max(cache[k], max);
		}
		
		System.out.println(N - max);

	}

}
