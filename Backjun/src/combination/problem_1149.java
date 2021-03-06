package combination;


//RGB 거리
import java.io.*;
import java.util.*;

public class problem_1149 {
	static int [][] map;
	static int [][] dp; //가장 최솟값을 넣는 dp
	static int small = Integer.MAX_VALUE; //최솟값
	static int N;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][3];
		dp = new int[N][3];
		
		for(int [] tmp : dp) {
			Arrays.fill(tmp, Integer.MAX_VALUE);
		}
		
		for(int i =0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0 ; j< 3 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int depth = 0;
		for(int i =0 ; i< 3; i++) {
			dp[depth][i] = map[depth][i];
			dfs(depth+1,i,map[depth][i]);
		}
		
		for(int i = 0 ; i < 3 ; i++) {
			small =Math.min(dp[N-1][i], small);
		}
		
		System.out.println(small);
	}
	
	
	private static void dfs(int depth,int preIdx,int preValue) {
		if(depth == N) {
			return;
		}
		for(int i =0 ; i< 3 ; i++) {
			if(preIdx != i && dp[depth][i] > map[depth][i]+preValue) {
				dp[depth][i] = map[depth][i]+preValue;
				dfs(depth+1,i,map[depth][i]+preValue);
			}
		}
	}
}
