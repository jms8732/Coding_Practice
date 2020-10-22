package dp;

/*
 * �κ� �����ϱ�
 * DP ������ ����
 * 
 * �κ��� ������ �Ʒ�, ����, �����ʿ� ���� ���� �޶����� �ȴ�.
 * ����, 3���� �迭�� �����Ͽ� �޸������̼��� �����ؾ� �ִ��� ���� �� �ִ�.
 */
import java.io.*;
import java.util.*;

public class problem_2169 {
	static int N, M, mars[][];
	static long cache[][][];
	static boolean[][] visited;
	static int INF = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cache = new long[3][N][M];
		mars = new int[N][M];
		visited = new boolean[N][M];

		for (long c[][] : cache) {
			for (long i[] : c)
				Arrays.fill(i, INF);
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				mars[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dp(0, 0, 0));
	}

	private static long dp(int x, int y, int dir) {
		/*
		 * �Ʒ� �ڵ尡 �ȵǴ� ������ 
		 * 1 4
		 * -1 -1- 1- 1 �� ���, ���� -1�� ��ȯ�Ѵ�. (������ -4�̴�)
		 * 
		 * if(x < 0|| x>= N || y < 0 || y >= M || visited[x][y]) return 0;
		 */
		
		if (x == N - 1 && y == M - 1) // ���������� ������ ���
			return mars[x][y];

		if (cache[dir][x][y] != INF)
			return cache[dir][x][y];

		int ret = mars[x][y];
		visited[x][y] = true;

		long val1 = INF, val2 = INF, val3 = INF;
		
		//���� ���� �湮���� �ʾ����鼭 �迭 ���� ���� �̵��� ������ ��ǥ���� Ž���� �����Ѵ�.
		if (x + 1 < N && !visited[x + 1][y])
			val1 = Math.max(val1, dp(x + 1, y, 0));

		if (y + 1 < M && !visited[x][y + 1])
			val2 = Math.max(val2, dp(x, y + 1, 1));

		if (y - 1 >= 0 && !visited[x][y - 1])
			val3 = Math.max(val3, dp(x, y - 1, 2));

		visited[x][y] = false;
		return cache[dir][x][y] = ret + Math.max(val1, Math.max(val2, val3));
	}
}
