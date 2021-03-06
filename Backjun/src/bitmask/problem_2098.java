package bitmask;

//외판원 순회

import java.util.*;
import java.io.*;

public class problem_2098 {
	static int[][] map, dp;
	static int N;
	static int IMPOSSIBLE = 100000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new int[N][1<<N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i[] : dp) {
			Arrays.fill(i, IMPOSSIBLE);
		}
		
		int result = tsp(0, 1);
		
		System.out.println(result);
	}

	private static int tsp(int current, int visited) {
		if(dp[current][visited] != IMPOSSIBLE)
			return dp[current][visited];
		
		if((visited == (1<<N)-1)) {
			//4곳을 다 방문한 경우
			if(map[current][0] == 0)
				return IMPOSSIBLE;
			return map[current][0];
			
		}

		for(int i=0 ; i <N ;i++) {
			if((visited & (1<<i)) == 0 && map[current][i] != 0) {
				//아직 방문하지 않은 지역
				dp[current][visited]= Math.min(dp[current][visited], map[current][i] + tsp(i,(visited | (1<<i))));
				
			}
		}
		
		return dp[current][visited];
	}
}
