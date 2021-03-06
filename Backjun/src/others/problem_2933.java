package others;

//미네랄
import java.util.*;
import java.io.*;

public class problem_2933 {
	static char[][] cave;
	static boolean[][] visited;
	static List<List<List<Integer>>> totalList;
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };

	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		totalList = new ArrayList<>();

		cave = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < tmp.length(); j++) {
				cave[i][j] = tmp.charAt(j);
			}
		}

		int N = Integer.parseInt(br.readLine());

		boolean side = false;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			throwBar(side, R - Integer.parseInt(st.nextToken()));
			if (!isGoDown()) {
				cluster();
				goDown();
			}
			side = !side;
			visited = new boolean[R][C];
			totalList.clear();

		}

		for (int k = 0; k < R; k++) {
			for (int j = 0; j < C; j++) {
				System.out.print(cave[k][j]);
			}
			System.out.println();
		}

	}

	private static void throwBar(boolean side, int height) {
		if (!side) {
			// left to right
			int start = 0;
			while (start < C) {
				if (cave[height][start] == '.')
					start++;
				else {
					// 미네랄을 부신 경우
					cave[height][start] = '.';
					break;
				}
			}
		} else {
			// right to left
			int start = C - 1;
			while (start >= 0) {
				if (cave[height][start] == '.')
					start--;
				else {
					// 미네랄을 부신 경우
					cave[height][start] = '.';
					break;
				}
			}
		}

	}

	private static boolean isGoDown() {
		for (int j = 0; j < C; j++) {
			if (!visited[R - 1][j] && cave[R - 1][j] == 'x')
				check(R - 1, j);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && cave[i][j] == 'x')
					return false;
			}
		}

		return true;
	}

	private static void cluster() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && cave[i][j] == 'x') {
					List<List<Integer>> list = new ArrayList<>();
					check(i, j, list);
					totalList.add(list);
				}
			}
		}
	}

	private static void check(int x, int y, List<List<Integer>> list) {
		List<Integer> tmp = new ArrayList<>();
		tmp.add(x);
		tmp.add(y);
		list.add(tmp);
		cave[x][y] = '.';

		for (int i = 0; i < 4; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C || cave[nx][ny] == '.' || visited[nx][ny])
				continue;

			check(nx, ny, list);
		}
	}

	private static void goDown() {
		for (int i = 0; i < totalList.size(); i++) {
			List<List<Integer>> list = totalList.get(i);
			int minX = R;

			// 클러스터의 최소 하강 수치를 구한다.
			for (int j = 0; j < list.size(); j++) {
				List<Integer> tmp = list.get(j);
				int curX = tmp.get(0);
				int curY = tmp.get(1);
				int cur = curX;
				while (true) {
					cur += 1;
					if (cur >= R || cave[cur][curY] == 'x')
						break;
				}
				minX = Math.min((cur - 1) - curX, minX);
			}

			// 이동
			for (int j = 0; j < list.size(); j++) {
				List<Integer> tmp = list.get(j);
				int curX = tmp.get(0);
				int curY = tmp.get(1);

				cave[curX + minX][curY] = 'x';
			}
		}
	}

	private static void check(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C || cave[nx][ny] == '.' || visited[nx][ny])
				continue;

			check(nx, ny);
		}
	}
}
