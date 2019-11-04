package dfs;
import java.util.*;

public class problem_2468 {
	static int[][] map;
	static boolean[][] visited;
	static int height;
	static int totalCount;
	static int[] rl = { -1, 0, 1, 0 };
	static int[] ud = { 0, -1, 0, 1 };
	static int count = 1;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = scanner.nextInt();
				map[i][j] = tmp;
				if (height == 0)
					height = map[i][j];
				else if (height < map[i][j])
					height = map[i][j];
			}
		}
		int tmpCount = 0;
		for (int i = 0; i <= height; i++) {
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map[j].length; k++) {
					if (i < map[j][k] && !visited[j][k]) {
						visited[j][k] = true;
						tmpCount += DFS(j, k, i);
					}
				}
			}
			visited = new boolean[N][N];
			totalCount = compare(totalCount, tmpCount);
			tmpCount = 0;

		}
		System.out.println(totalCount);
	}

	static int DFS(int x, int y, int he) {
		for (int i = 0; i < rl.length; i++) {
			int nx = x + rl[i];
			int ny = y + ud[i];

			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length)
				continue;
			else {
				if (he < map[nx][ny] && !visited[nx][ny]) {
					visited[nx][ny] = true;
					DFS(nx, ny, he);
				}
			}
		}
		return count;
	}

	static int compare(int a, int b) {
		return a > b ? a : b;
	}
}
