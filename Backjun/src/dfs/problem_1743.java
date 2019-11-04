package dfs;
import java.util.*;

public class problem_1743 {
	static int map[][];
	static int count;
	static int big;
	static int[] directionR = { 0, 0, 1, -1 };
	static int[] directionC = { 1, -1, 0, 0 };
	static int n, m;

	static int DFS(int idx, int i) {
		map[idx][i] = 0;
		for (int j = 0; j < directionR.length; j++) {
			int nextIdx = idx + directionR[j];
			int nextI = i + directionC[j];

			if ((nextIdx < 0 || nextIdx > n || nextI > m || nextI < 0))
				continue;
			if (map[nextIdx][nextI] == 1) {
				count++;
				DFS(nextIdx, nextI);
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		int trash = scanner.nextInt();
		map = new int[n + 1][m + 1];

		for (int i = 0; i < trash; i++) {
			int x = scanner.nextInt() - 1;
			int y = scanner.nextInt() - 1;
			map[x][y] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					count = 1;
					big = max(big, DFS(i, j));
				}
			}
		}
		System.out.println(big);
	}
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}
}
