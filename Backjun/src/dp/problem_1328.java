package dp;

/*
 * 고층 빌딩
 * DP 유형 문제, 점화식을 이용하여 접근해야 한다.
 */
import java.util.*;
import java.io.*;

public class problem_1328 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		long MOD = 1000000007;
		
		long[][][] dp = new long[N+1][L+1][R+1];
		dp[1][1][1] = 1; // 빌딩이 1개 인경우, 좌 우로 1개만 보인다.

		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= L; j++) {
				for (int k = 1; k <= R; k++) {
					dp[i][j][k] += dp[i - 1][j][k] * (i - 2); //건물들 사이에 작은 건물을 둘 경우, 건물이 보이지 않는다.
					dp[i][j][k] += dp[i - 1][j - 1][k]; //가장 왼쪽에 건물을 둘 경우, 왼쪽에 보이는 건물의 수가 증가한다.
					dp[i][j][k] += dp[i - 1][j][k - 1]; //가장 오른쪽에 건물을 둘 겨웅, 오른쪽에 보이는 건물의 수가 증가한다.
					dp[i][j][k] %= MOD;
				}
			}
		}
		
		System.out.println(dp[N][L][R]);
	}
}
