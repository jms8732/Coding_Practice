package greedy;

//Ã¥ ³ª´² ÁÖ±â
import java.util.*;
import java.io.*;

public class problem_9576 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			List<Integer> adj[] = new ArrayList[M];

			for (int j = 0; j < M; j++)
				adj[j] = new ArrayList<>();

			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;

				for (int k = a; k <= b; k++) {
					adj[j].add(k);
				}
			}

			boolean[] visited = new boolean[N];
			int[] val = new int[N];
			Arrays.fill(val, -1);

			int count = 0;
			for (int j = 0; j < M; j++) {
				Arrays.fill(visited, false);
				if (search(j, visited, val, adj))
					count++;
			}
			System.out.println(count);
		}
	}

	private static boolean search(int cur, boolean[] visited, int[] val, List<Integer>[] adj) {
		for (int next : adj[cur]) {
			if (visited[next])
				continue;

			visited[next] = true;

			if (val[next] == -1 || search(val[next], visited, val, adj)) {
				val[next] = cur;
				return true;
			}
		}

		return false;
	}
}
