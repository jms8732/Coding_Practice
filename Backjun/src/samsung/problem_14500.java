package samsung;

import java.util.*;
import java.io.*;

/*
 * ��Ʈ�ι̳�
 * DFS + ���� ����
 * DFS�� �̿��Ͽ� �� ����� �����ϰ� ��ȸ�ϸ鼭 ���� ū ���� ã�´�.
 * �� ����� ���� ó���Ѵ�.
 */

public class problem_14500 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simulation(board, n, m);

	}

	private static void simulation(int[][] board, int n, int m) {
		int ans = 0;
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans = Math.max(ans, dfs(0, i, j, 0, board, visited, n, m));

				// ��, ��, ��, �����
				ans = Math.max(ans, specialCase(i, j, board, n, m));
			}
		}
		System.out.println(ans);
	}

	private static int specialCase(int x, int y, int[][] board, int n, int m) {
		int ret = 0;
		// �� ���
		if (x - 1 >= 0 && x + 1 < n && y >= 0 && y + 1 < m) {
			ret = Math.max(ret, board[x - 1][y] + board[x][y] + board[x + 1][y] + board[x][y + 1]);
		}

		// �� ���
		if (x - 1 >= 0 && x + 1 < n && y - 1 >= 0 && y < m) {
			ret = Math.max(ret, board[x - 1][y] + board[x][y] + board[x + 1][y] + board[x][y - 1]);
		}

		// �� ���
		if (x - 1 >= 0 && x < n && y - 1 >= 0 && y + 1 < m) {
			ret = Math.max(ret, board[x][y - 1] + board[x][y] + board[x][y + 1] + board[x - 1][y]);
		}

		// �� ���
		if (x >= 0 && x + 1 < n && y - 1 >= 0 && y + 1 < m) {
			ret = Math.max(ret, board[x][y - 1] + board[x][y] + board[x][y + 1] + board[x + 1][y]);
		}

		return ret;

	}

	private static int dfs(int depth, int x, int y, int c, int[][] board, boolean[][] visited, int n, int m) {
		if (depth == 4) {
			// ���� ���
			return c;
		}

		int ret = 0; // �ִ� ��ȯ
		for (int i = 0; i < 4; i++) {
			// ���� ��ǥ
			int nx = x + ud[i];
			int ny = y + rl[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny])
				continue; // �迭�� ������ ��� ���, ��ġ�� �κ��� �ִ� ���

			visited[x][y] = true;
			ret = Math.max(dfs(depth + 1, nx, ny, c + board[x][y], board, visited, n, m), ret);
			visited[x][y] = false;
		}

		return ret;
	}
}
