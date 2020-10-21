package search_algorithm;

/*
 * 다리 놓기
 * DP 유형의 문제
 */
import java.util.*;
import java.io.*;

public class problem_1010 {
	static int cache[][];
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			cache = new int[N][M];
			for (int c[] : cache)
				Arrays.fill(c, -1);
			
			System.out.println(dp(0,0));
		}
	}

	private static int dp(int A, int B) {
		if (A == N) // 서쪽에 있는 다리가 다 연결될 경우
			return 1;
		
		if(B == M) //동쪽의 다리가 범위를 벗어난 경우 
			return 0;

		if (cache[A][B] != -1)
			return cache[A][B];

		int ret = 0;

		//반복문을 돌면서 서쪽 -> 동쪽 다리를 연결한다
		for (int i = B; i < M; i++) {
			ret += dp(A+1,i+1); //다리 연결
		}
		
		return cache[A][B]=ret;
}}
