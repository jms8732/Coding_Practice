package dp;

/*
 * 로봇 조종하기
 * DP 유형의 문제
 * 
 * 로봇의 방향이 아래, 왼쪽, 오른쪽에 따라서 값이 달라지게 된다.
 * 따라서, 3차원 배열로 생각하여 메모이제이션을 진행해야 최댓값을 구할 수 있다.
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
		 * 아래 코드가 안되는 이유는 
		 * 1 4
		 * -1 -1- 1- 1 일 경우, 값이 -1을 반환한다. (정답은 -4이다)
		 * 
		 * if(x < 0|| x>= N || y < 0 || y >= M || visited[x][y]) return 0;
		 */
		
		if (x == N - 1 && y == M - 1) // 도착지점에 도착한 경우
			return mars[x][y];

		if (cache[dir][x][y] != INF)
			return cache[dir][x][y];

		int ret = mars[x][y];
		visited[x][y] = true;

		long val1 = INF, val2 = INF, val3 = INF;
		
		//각각 아직 방문하지 않았으면서 배열 범위 내로 이동이 가능한 좌표들을 탐색을 진행한다.
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
