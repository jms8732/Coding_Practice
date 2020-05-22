package dp;

//Á¤¼ö »ï°¢Çü
import java.util.*;
import java.io.*;

public class problem_1932 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int [][] tri = new int[N][];
		
		for(int i =0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int [] tmp = new int[i+1];
			for(int j = 0;  j < tmp.length ; j++) {
				tmp[j]= Integer.parseInt(st.nextToken());
			}
			tri[i] = tmp;
		}
		
		dp(tri,N);
	}
	
	private static void dp(int[][] tri, int N) {
		int big = 0, idx =0;
		
		int [][] cache = new int[N][];
		
		for(int c [] : tri) {
			cache[idx++] = new int[c.length];
		}
		
		for(int i = 0 ; i < N-1 ; i++) {
			
			for(int j =0 ;  j < tri[i].length;  j++) {
				for(int k = j ; k <= j+1; k ++) {
					cache[i+1][k] = Math.max(cache[i+1][k], tri[i+1][k] + tri[i][j]);
				}
			}
			System.arraycopy(cache[i+1], 0, tri[i+1], 0, tri[i+1].length);
		}
		
		for(int i : cache[N-1])
			big = Math.max(big, i);
		
		System.out.println(big);
	}
}
