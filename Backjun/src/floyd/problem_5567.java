package floyd;

//°áÈ¥½Ä
import java.util.*;
import java.io.*;

public class problem_5567 {
	static int[][] adj;
	static int INF = 100000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()) +1;
		adj = new int[N][N];

		for (int[] a : adj)
			Arrays.fill(a, INF);

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			adj[s][e] = 1;
			adj[e][s] = 1;

		}

		floyd(N);
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

		int count = 0;
		for (int i = 2; i < N; i++) {
			if (adj[1][i] != INF && adj[1][i] <= 2) {
				count++;
			}
		}

		System.out.println(count);
	}
}
