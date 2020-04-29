package dp;

//ÇÕÄ£LIS
import java.util.*;
import java.io.*;

public class jlis {
	static int N,M;
	static int [] A, B;
	static int [][] cache;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			A = new int[N];
			B = new int[M];
			
			cache = new int[N+1][M+1];
			
			for(int [] tmp : cache)
				Arrays.fill(tmp, -1);
			
			st=  new StringTokenizer(br.readLine());
			for(int j =0 ; j< N ; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < M ; j++) {
				B[j] = Integer.parseInt(st.nextToken());
			}

			System.out.println(lis(-1,-1)-2);
			
			
		}
	}

	private static int lis(int indexA, int indexB) {
		if(cache[indexA+1][indexB+1] != -1)
			return cache[indexA+1][indexB+1];
		
		int ret = 2;
		
		long a = (indexA == -1 ? Long.MIN_VALUE : A[indexA]);
		long b = (indexB == -1 ? Long.MIN_VALUE : B[indexB]);
		
		long mx = Math.max(a, b);
		
		for(int next = indexA + 1 ; next< A.length ; next++) {
			if(mx < A[next]) {
				ret = cache[indexA+1][indexB+1] = Math.max(ret, lis(next,indexB)+1);
			}
		}
		
		for(int next = indexB + 1 ; next < B.length ; next++) {
			if(mx < B[next])
				ret = cache[indexA+1][indexB+1] = Math.max(ret, lis(indexA,next)+1);
		}
		
		return cache[indexA+1][indexB+1] = ret;
		
	}

}
