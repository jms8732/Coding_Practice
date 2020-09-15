package dp;

/*
 * ���̾Ƹ�� ����
 * 
 * dp�� �̿��ؼ� ������ �����Ѵ�. ��, 4���⿡ �´� �迭�� ������ ��, DP�� �����ؾ� �Ѵ�.
 */
import java.util.*;
import java.io.*;

public class problem_1028 {
	static int[][][] cache;
	static char[][] map;
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cache = new int[R][C][4];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				for (int k = 0; k < 4; k++) {
					cache[i][j][k] = -1;
				}
			}
		}
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++)
				map[i][j] = line.charAt(j);
		}

		dp(map, R, C);
	}

	private static void dp(char[][] map, int R, int C) {
		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '1') {
					int level = Math.min(dfs(i, j, 0), dfs(i, j, 1)); //<������, ª�� �Ÿ��� ã�´�.
					
					//<�� ª�� �Ÿ��� ������� >�� �Ÿ��� ����Ѵ�.
					for (int k = 1; k <= level; k++) {
						int aside = j + 2 * k - 2;

						if (aside >= C)
							break;
						if (map[i][aside] == '0')
							continue;
						int another = Math.min(dfs(i, aside, 2), dfs(i, aside, 3));

						if (another >= k) //�ݴ� ������ ª���� ������ ���� �ʴ´�.
							answer = Math.max(answer, k);
					}
				}
			}
		}
		
		System.out.println(answer);
	}

	//���⿡ ���� Ž���� �����Ѵ�.
	private static int dfs(int x, int y, int dir) {
		if (cache[x][y][dir] != -1)
			return cache[x][y][dir];

		int ret = 1;

		if (dir == 0) {
			if (x - 1 < 0 || y + 1 >= C || map[x - 1][y + 1] == '0')
				return cache[x][y][dir] = ret;
			else
				ret += dfs(x - 1, y + 1, dir);
		}
		if (dir == 1) {
			if (x + 1 >= R || y + 1 >= C || map[x + 1][y + 1] == '0')
				return cache[x][y][dir] = ret;
			else
				ret += dfs(x + 1, y + 1, dir);
		}
		if (dir == 2) {
			if (x - 1 < 0 || y - 1 < 0 || map[x - 1][y - 1] == '0')
				return cache[x][y][dir] = ret;
			else
				ret += dfs(x - 1, y - 1, dir);
		}
		if (dir == 3) {
			if (x + 1 >= R || y - 1 < 0 || map[x + 1][y - 1] == '0')
				return cache[x][y][dir] = ret;
			else
				ret += dfs(x + 1, y - 1, dir);
		}

		return cache[x][y][dir] = ret;
	}
}
