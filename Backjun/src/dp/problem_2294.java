package dp;

//동전 2
import java.io.*;
import java.util.*;

public class problem_2294 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int IMPOSSIBLE = 100000;
		Set<Integer> set = new TreeSet<>();

		// 중복 제거
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp <= K)
				set.add(tmp);
		}
		if (set.size() == 0)
			System.out.println("-1");
		else {
			int[] array = new int[set.size()];
			Iterator<Integer> it = set.iterator();
			int idx = 0;
			while (it.hasNext())
				array[idx++] = it.next();

			int[][] dp = new int[set.size()][K + 1];
			for (int[] tmp : dp) {
				Arrays.fill(tmp, IMPOSSIBLE);
			}
			int step = 1;

			for (int i = array[0]; i <= K; i += array[0])
				dp[0][i] = 1 * (step++);

			for (int i = 1; i < array.length; i++) {
				System.arraycopy(dp[i - 1], 0, dp[i], 0, array[i]);
				dp[i][array[i]] = 1;
				for (int j = array[i] + 1; j <= K; j++) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][array[i]] + dp[i][j - array[i]]);
				}
			}

			if(dp[set.size()-1][K] == IMPOSSIBLE)
				System.out.println("-1");
			else
				System.out.println(dp[set.size() - 1][K]);
		}
	}
}
