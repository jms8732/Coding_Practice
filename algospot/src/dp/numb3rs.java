package dp;

//두니발 박사의 탈옥
import java.util.*;
import java.io.*;

public class numb3rs {
	static double cache[][];
	static List<Integer> adj[];
	static int start;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tw = Integer.parseInt(st.nextToken());
			int days = Integer.parseInt(st.nextToken());

			start = Integer.parseInt(st.nextToken());

			cache = new double[days + 1][tw + 1];

			for (double tmp[] : cache)
				Arrays.fill(tmp, -1);
			
			adj = new ArrayList[tw];

			for (int j = 0; j < tw; j++)
				adj[j] = new ArrayList<>();

			// 인접된 리스트 연결
			for (int j = 0; j < tw; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < tw; k++) {
					int tmp = Integer.parseInt(st.nextToken());

					if (tmp != 0)
						adj[j].add(k);
				}
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				System.out.print(percent(days, Integer.parseInt(st.nextToken())) + " ");
			}
			System.out.println();
		}
	}

	private static double percent(int d, int cur) {
		if (d == 0)
			return (cur == start ? 1.0 : 0.0);

		if (cache[d][cur] > -0.5)
			return cache[d][cur];
		
		double ret = 0.0;
		
		for (int next : adj[cur]) {
			ret += percent(d - 1, next) / adj[next].size();
		}

		return cache[d][cur] = ret;

	}
}
