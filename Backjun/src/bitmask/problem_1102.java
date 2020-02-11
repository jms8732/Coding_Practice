package bitmask;

//������
import java.util.*;
import java.io.*;

public class problem_1102 {
	static int N, P;
	static int[] dp;
	static int[][] cost;
	static int IMPOSSIBLE = 100000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		dp = new int[1 << N];

		StringTokenizer st = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		String tmp = br.readLine();
		int light = 0;

		// �����ҿ� ���� ���� ���� ��Ʈ�� ǥ��
		for (int i = 0; i < tmp.length(); i++) {
			if (tmp.charAt(i) == 'Y') {
				light |= 1 << i;
			}
		}

		P = Integer.parseInt(br.readLine());
		Arrays.fill(dp, IMPOSSIBLE);

		int result = dfs(light);
		if (result == IMPOSSIBLE)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	private static int dfs(int light) {
		if (Integer.bitCount(light) >= P) {
			return 0;
		}

		if(dp[light] != IMPOSSIBLE)
			return dp[light];
		
		for(int i =0 ; i < N ; i++) {
			if((light & (1<<i)) == 1<<i) {
				for(int j =0 ; j < N ; j++) {
					if((light & (1<<j)) == 0<<j) {
						dp[light] = Math.min(dp[light], cost[i][j] + dfs(light | 1<<j));
					}
				}
			}
		}
		
		return dp[light];
	}

}
