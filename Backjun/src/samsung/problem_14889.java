package samsung;

//스타트와 링크, 조합탐색
import java.util.*;
import java.io.*;

public class problem_14889 {
	static int N;
	static int map[][];
	static boolean visited[]; // true= start team, false=link team
	static int diff = Integer.MAX_VALUE;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // N
			map = new int[N][N];
			visited = new boolean[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // map 값 설정
				}
			}

			dfs(0, 0);

			System.out.println(diff);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void dfs(int idx, int depth) {
		if (depth == N / 2) {
			calculate();
			return;
		}

		for (int i = idx; i < N; i++) {
			visited[i] = true;
			dfs(i + 1, depth + 1);
			visited[i] = false;
		}
	}

	private static void calculate() {
		int startTeam = 0, linkTeam = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i] && visited[j]) {
					// startTeam인 경우
					startTeam += map[i][j];
				}
				if (!visited[i] && !visited[j]) {
					linkTeam += map[i][j];
				}
			}
		}

		int dif = Math.abs(startTeam - linkTeam);
		diff = Math.min(diff, dif);
	}
}
