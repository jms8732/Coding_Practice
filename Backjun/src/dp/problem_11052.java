package dp;

//카드 구매하기

import java.util.*;
import java.io.*;

public class problem_11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] array = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][N + 1];/*
		long start = System.currentTimeMillis();*/
		for (int i = 1; i <= N; i++) {
			dp[1][i] = Math.max(array[i],array[1] * i);
		}
		
		for(int i = 2; i <= N ; i++) {
			System.arraycopy(dp[i-1], 0,dp[i], 0, i+1);
			for(int j= i+1 ; j <=N; j++) {
				dp[i][j] = Math.max(dp[i-1][j],dp[i][i]+dp[i][j-i]);
			}
		}/*
		long end = System.currentTimeMillis();
		System.out.println("time : " + (end-start)/1000.0);*/
		System.out.println(dp[N][N]);
	}
}
