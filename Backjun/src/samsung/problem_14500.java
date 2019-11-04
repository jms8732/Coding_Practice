package samsung;

import java.util.*;

public class problem_14500 {
	static int[][] map;
	static int N, M;
	static int big;
	static boolean[][] visited;
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int tmp = scanner.nextInt();
				map[i][j] = tmp;
			}
		}
		int count = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum += map[i][j];
				visited[i][j] = true;
				dfs(i, j, count, sum);
				specialBlock(i, j);
				visited[i][j] = false;
				sum = 0;
			}
		}
		System.out.println(big);
	}

	// �Ǹ� ������ ������
	static void dfs(int x, int y, int count, int sum) {
		int tmp = 0;
		if (count == 3) {
			big = Math.max(big, sum);
			return;
		}
		for (int i = 0; i < rl.length; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue; // ������ �Ѿ�����
			else {
				// ������ �ȳѾ�����
				if (!visited[nx][ny]) { // ������ ���� �ƴϸ�
					visited[nx][ny] = true;
					sum += map[nx][ny]; // ���� �� ���Ѵ�.
					dfs(nx, ny, count + 1, sum); // dfs
					sum -= map[nx][ny];
					visited[nx][ny] = false;
				}
			}
		}
	}

	// ��
	static void specialBlock(int x, int y) {
		int sum = 0;
		if ((x == 0 || x == N - 1) && (y == 0 || y == M - 1))
			return;
		if (x == 0) {
			// �� ����� ��� ��
			sum = map[x][y - 1] + map[x][y] + map[x][y + 1] + map[x + 1][y];
			big = Math.max(sum, big);
		} else if (x == N - 1) {
			// �� �ϴ� �ϰ�� ��
			sum = map[x][y - 1] + map[x][y] + map[x][y + 1] + map[x - 1][y];
			big = Math.max(sum, big);
		} else if (y == 0) {
			// �� ������ ��� ��
			sum = map[x - 1][y] + map[x][y] + map[x + 1][y] + map[x][y + 1];
			big = Math.max(sum, big);
		} else if (y == M - 1) {
			// �� ������ ��� ��
			sum = map[x - 1][y] + map[x][y] + map[x + 1][y] + map[x][y - 1];
			big = Math.max(sum, big);
		} else {
			sum = map[x][y - 1] + map[x][y] + map[x][y + 1] + map[x + 1][y];
			big = Math.max(sum, big);
			sum = map[x][y - 1] + map[x][y] + map[x][y + 1] + map[x - 1][y];
			big = Math.max(sum, big);
			sum = map[x - 1][y] + map[x][y] + map[x + 1][y] + map[x][y + 1];
			big = Math.max(sum, big);
			sum = map[x - 1][y] + map[x][y] + map[x + 1][y] + map[x][y - 1];
			big = Math.max(sum, big);
		}
	}
}
