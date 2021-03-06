package dp;

//가장 긴 증가하는 부분 수열 1
import java.util.*;
import java.io.*;

public class problem_11053 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		int[] dp = new int[N];
		Arrays.fill(dp, 1);

		for (int i = 0; i < N; i++) {
			int big = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (array[i] > array[j]) {
					big = Math.max(big,Math.max(dp[i], dp[j] + 1));
				}
			}

			dp[i] = big;
		}

		int answer = 0;
		for (int i = 0; i < N; i++)
			answer = Math.max(answer, dp[i]);

		System.out.println(answer);
	}
}
