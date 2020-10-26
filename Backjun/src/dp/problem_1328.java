package dp;

/*
 * ���� ����
 * DP ���� ����, ��ȭ���� �̿��Ͽ� �����ؾ� �Ѵ�.
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
		dp[1][1][1] = 1; // ������ 1�� �ΰ��, �� ��� 1���� ���δ�.

		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= L; j++) {
				for (int k = 1; k <= R; k++) {
					dp[i][j][k] += dp[i - 1][j][k] * (i - 2); //�ǹ��� ���̿� ���� �ǹ��� �� ���, �ǹ��� ������ �ʴ´�.
					dp[i][j][k] += dp[i - 1][j - 1][k]; //���� ���ʿ� �ǹ��� �� ���, ���ʿ� ���̴� �ǹ��� ���� �����Ѵ�.
					dp[i][j][k] += dp[i - 1][j][k - 1]; //���� �����ʿ� �ǹ��� �� �ܿ�, �����ʿ� ���̴� �ǹ��� ���� �����Ѵ�.
					dp[i][j][k] %= MOD;
				}
			}
		}
		
		System.out.println(dp[N][L][R]);
	}
}
