package programmers1;

//N-Queen

public class problem_28 {
	static int count = 0;

	public static void main(String[] args) {
		int result = solution(5);
		System.out.println(result);
	}

	public static int solution(int n) {
		boolean[][] map = new boolean[n][n];
		int depth = 0;
		dfs(depth, 0, n, map);
		return count;
	}

	private static void dfs(int depth, int next, int n, boolean[][] map) {
		if (depth == n) {
			// 퀸의 개수가 n개가 된 경우, 경우의 수를 증가시킨다.
			count++;
			return;
		}
		boolean[][] tmpMap = new boolean[n][n];

		copyMap(map, tmpMap); // 채우기 이전의 모습

		for (int j = 0; j < n; j++) {
			if (!map[next][j]) {
				fill(next, j, map);
				map[next][j] = true;
				dfs(depth + 1, next + 1, n, map);
				map[next][j] = false;
				copyMap(tmpMap, map);
			}
		}
	}

	private static void copyMap(boolean[][] src, boolean[][] target) {
		int idx = 0;
		for (boolean[] tmp : src) {
			System.arraycopy(tmp, 0, target[idx++], 0, tmp.length);
		}
	}

	private static void fill(int x, int y, boolean[][] map) {
		// 퀸은 8방향으로 이동할 수 있다. 북,북동,동,동남,남,남서,서,북서
		int ud[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int rl[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int tmpX = x, tmpY = y;
		for (int i = 0; i < ud.length; i++) {
			x = tmpX;
			y = tmpY;
			while (true) {
				int nx = x + ud[i];
				int ny = y + rl[i];

				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length)
					break;

				map[nx][ny] = true; // 퀸이 이동 할 수 있는 좌표

				// 다음 좌표로 이동
				x = nx;
				y = ny;
			}
		}
	}
}
