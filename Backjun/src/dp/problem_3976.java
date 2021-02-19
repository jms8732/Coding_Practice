package dp;

/*
 * 역습
 * 각 구간마다 가장 작은 값을 메모이제이션을 진행한다.
 */
import java.util.*;
import java.io.*;

public class problem_3976 {
	static int p1_dribble[], p1_pass[], p2_dribble[], p2_pass[], cache[][], n;
	static int l1, l2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());

			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			l1 = Integer.parseInt(st.nextToken());
			l2 = Integer.parseInt(st.nextToken());

			String[] tmp = new String[4];

			for (int j = 0; j < tmp.length; j++) {
				tmp[j] = br.readLine();
			}

			init(tmp);

			System.out.println(Math.min(dp(0, 0) + s1, dp(1, 0) + s2));
		}
	}

	private static int dp(int P, int N) {
		if (N == n-1) {
			// 슛
			if (P == 0)
				return l1;
			else
				return l2;
		}

		if (cache[P][N] != -1)
			return cache[P][N];

		int ret = Integer.MAX_VALUE;

		if (P == 0) {
			// p1 -> p2 패스
			ret = Math.min(ret, p1_pass[N] + dp((P + 1) % 2, N + 1));
			// p1 드리블
			ret = Math.min(ret, p1_dribble[N] + dp(P, N + 1));
		}

		if (P == 1) {
			// p2 -> p1 패스
			ret = Math.min(ret, p2_pass[N] + dp((P + 1) % 2, N + 1));

			// p2 드리블
			ret = Math.min(ret, p2_dribble[N] + dp(P, N + 1));
		}
		return cache[P][N] = ret;
	}

	private static void init(String[] tmp) {
		p1_dribble = new int[n - 1];
		p1_pass = new int[n - 1];
		p2_dribble = new int[n - 1];
		p2_pass = new int[n - 1];
		cache = new int[2][n - 1];

		for (int[] c : cache)
			Arrays.fill(c, -1);

		int[][] temp = { p1_pass, p1_dribble, p2_pass, p2_dribble };

		StringTokenizer st = null;
		for (int i = 0; i < tmp.length; i++) {
			st = new StringTokenizer(tmp[i]);

			for (int j = 0; j < n - 1; j++) {
				temp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
