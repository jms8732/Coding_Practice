package dp;

//∞‘¿”
import java.util.*;
import java.io.*;

public class problem_1103 {
	static char[][] map;
	static int N, M;
	static int[][] cache;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		cache = new int[N][M];
		visited = new boolean[N][M];

		for (int c[] : cache)
			Arrays.fill(c, -1);

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			for (int j = 0; j < tmp.length(); j++) {
				map[i][j] = tmp.charAt(j);
			}
		}

		System.out.println(simulation(0, 0));
		//print(N,M);
	}
	private static void print(int N , int M) {
		for(int i=0 ; i < N ;i++) {
			for(int j =0 ; j < M ; j++) {
				System.out.print(cache[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int simulation(int x, int y) {
		if(x < 0 || x >= N || y <0 || y >= M || map[x][y] == 'H') {
			return 0;
		}
		
		if(visited[x][y]) {
			System.out.println(-1);
			System.exit(0);
		}

		int m = map[x][y] - '0';
		
		if (cache[x][y] != -1)
			return cache[x][y];

		visited[x][y] = true;
		int ret = 0;

		ret = simulation(x - 1 * m, y) + 1;
		ret = Math.max(ret,simulation(x + 1 * m, y) +1);
		ret = Math.max(ret, simulation(x, y - 1 * m) +1);
		ret = Math.max(ret, simulation(x, y + 1 * m) + 1);
		
		visited[x][y] = false;
		return cache[x][y] = ret;

	}

	private static void print(char[][] map, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
