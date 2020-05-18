package floyd;

//케빈 베이컨의 6단계 법칙
import java.util.*;
import java.io.*;

public class problem_1389 {
	static int[][] adj;
	static int INF = 100000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		adj = new int[N][N];
		for (int tmp[] : adj)
			Arrays.fill(tmp, INF);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;

			adj[start][end] = 1;
			adj[end][start] = 1;
		}

		floyd(N);
		min_kevin(N);
	}

	private static void min_kevin(int N) {
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			int tmp = 0;
			for (int j = 0; j < N; j++) {
				if (i != j)
					tmp += adj[i][j];
			}

			if (min > tmp) {
				answer = i + 1;
				min = tmp;
			}
		}
		System.out.println(answer);
	}

	private static void floyd(int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (adj[j][k] > adj[j][i] + adj[i][k]) {
						adj[j][k] = adj[i][j] + adj[i][k];
					}
				}
			}
		}
	}
}
