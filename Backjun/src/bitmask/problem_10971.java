package bitmask;

//외판원 순회2
import java.util.*;
import java.io.*;

public class problem_10971 {
	static int[][] map, dp;
	static int IMPOSSIBLE = 100000000;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		dp = new int[N][1 << N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], IMPOSSIBLE);
		}
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = visitedCity(1, 0);
		System.out.println(result);
	}

	private static int visitedCity(int city, int curCity) {
		if (Integer.bitCount(city) == N) {
			if(map[curCity][0] != 0 )
				return map[curCity][0];
			else
				return IMPOSSIBLE;
		}

		if (dp[curCity][city] != IMPOSSIBLE)
			return dp[curCity][city];

		for (int j = 0; j < N; j++) {
			if ((city & 1 << j) == 0) {
				// 아직 방문하지 않은 도시가 존재하면서 해당 도시로 갈 수 있는 경우
				if (map[curCity][j] != 0)
					dp[curCity][city] = Math.min(dp[curCity][city], visitedCity(city | 1 << j, j) + map[curCity][j]);
			}
		}

		return dp[curCity][city];

	}
}
