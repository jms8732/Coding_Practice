package graph;

//오일로 회로
import java.util.*;
import java.io.*;

public class problem_1199 {
	static int[][] adj;
	static int[] cnt_degree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		adj = new int[N][N];

		cnt_degree = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int v = Integer.parseInt(st.nextToken());
				adj[i][j] = v;

				cnt_degree[i] += v;

			}
		}

		if (EulerPath(N)) {
			List<Integer> val = new ArrayList<>();
			getEulerPath(0, val);

			Collections.reverse(val);

			for (int i : val)
				System.out.print((i + 1) + " ");
		} else
			System.out.println(-1);

	}

	private static void getEulerPath(int cur, List<Integer> val) {
		for (int i = 0; i < adj[cur].length; i++) {
			while (adj[cur][i] > 0) {
				// 간선 하나 소비
				adj[cur][i] -= 1;
				adj[i][cur] -= 1;
				getEulerPath(i, val);
			}
		}

		val.add(cur);
	}

	private static boolean EulerPath(int N) {
		for (int i = 0; i < N; i++) {
			if (cnt_degree[i] % 2 != 0)
				return false;
		}

		return true;
	}
}
