package samsung;

//테트로미노
import java.util.*;
import java.io.*;

public class problem_14500_1 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };
	static int[][] map;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		simulation(N, M);
	}

	private static void simulation(int N, int M) {
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				find_max(1, i, j, N, M, map[i][j], visited);

				// ㅗ 모양 값 구하기
				find_max(i, j,N,M,map);
			}
		}
		
		System.out.println(answer);
	}

	private static void find_max(int i, int j, int N, int M, int[][] map) {
		int val = 0;

		if (i - 1 >= 0 && i + 1 < N && j + 1 < M) { // ㅏ
			val = map[i - 1][j] + map[i][j] + map[i + 1][j] + map[i][j + 1];
			answer = Math.max(answer, val);
		}

		if (j - 1 >= 0 && j + 1 < M && i + 1 < N) { // ㅜ
			val = map[i][j - 1] + map[i][j] + map[i][j + 1] + map[i + 1][j];
			answer = Math.max(answer, val);
		}

		 if (i - 1 >= 0 && i + 1 < N && j - 1 >= 0) { // ㅓ
			val = map[i - 1][j] + map[i][j] + map[i + 1][j] + map[i][j - 1];
			answer = Math.max(answer, val);
		}

		 if (i - 1 >= 0 && j - 1 >= 0 && j + 1 < M) { //ㅗ
			val = map[i - 1][j] + map[i][j] + map[i][j - 1] + map[i][j + 1];
			answer = Math.max(answer, val);
		}

	}

	private static void find_max(int depth, int x, int y, int N, int M, int val, boolean[][] visited) {
		if (depth == 4) {
			answer = Math.max(answer, val);
			return;
		}
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue;

			if (visited[nx][ny])
				continue;

			find_max(depth + 1, nx, ny, N, M, val + map[nx][ny], visited);
		}
		
		visited[x][y] = false;
	}
}
