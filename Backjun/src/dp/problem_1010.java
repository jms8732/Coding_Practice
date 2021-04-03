package dp;

/*
 * 다리 놓기
 * DP 유형의 문제
 */
import java.util.*;
import java.io.*;

public class problem_1010 {
	static int [][] cache;
	static int n,m;
	public static void main(String []args) throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i =0 ; i < tc ; i++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			cache = new int[n][m];
			
			for(int [] c : cache)
				Arrays.fill(c,-1);
			
			System.out.println(dp(0,0));
		}
	}
	
	private static int dp(int x ,int y) {
		if(x == n) //다리를 겹치지 않게 다 이은 경우
			return 1;
		
		if(y == m)
			return 0;
		
		if(cache[x][y] != -1)
			return cache[x][y];
		
		int ret = 0;
		for(int i= y; i < m ; i++) {
			ret += dp(x+1,i+1);
		}
		
		return cache[x][y] = ret;
	}
}
