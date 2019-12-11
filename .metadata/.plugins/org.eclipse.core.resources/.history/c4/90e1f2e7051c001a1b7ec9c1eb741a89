package dfs;
import java.util.*;

public class problem_10026 {
	static char[][] map;
	static boolean[][] visited;
	static int[] rl = { -1, 0, 1, 0 };
	static int[] ud = { 0, -1, 0, 1 };
	static int total = 0;
	static boolean check = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		map = new char[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < map.length; i++) {
			String tmp = scanner.next();
			char[] ctmp = tmp.toCharArray();
			for (int j = 0; j < ctmp.length; j++) {
				map[i][j] = ctmp[j];
			}
		} /*
			 * for(int i= 0 ; i < map.length; i++) { for(int j= 0 ; j< map[i].length; j++) {
			 * System.out.print(map[i][j]); } System.out.println(); }
			 */
		for (int k = 0; k <= 1; k++) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (!visited[i][j]) {
						visited[i][j] = true;
						total++;
						total = DFS(i, j);
					}
				}
			}
			System.out.print(total + " ");
			total = 0;
			check = true;
			visited = new boolean[N][N];
		}

	}

	static int DFS(int x, int y) {
		for (int i = 0; i < rl.length; i++) {
			int nx = x + rl[i];
			int ny = y + ud[i];

			if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length)
				continue;
			else {
				if (!check && !visited[nx][ny] && (map[nx][ny] == map[x][y])) {
					visited[nx][ny] = true;
					DFS(nx, ny);
				} else if (check) {
					char ctmp = map[x][y];
					if(!visited[nx][ny] && (ctmp== 'R' || ctmp == 'G') &&  (map[nx][ny] =='R' || map[nx][ny] == 'G')) {
						visited[nx][ny] = true;
						DFS(nx,ny);
					}
					else if(!visited[nx][ny] && (map[nx][ny] == map[x][y])) {
						visited[nx][ny] = true;
						DFS(nx, ny);
					}
				}
			}
		}
		return total;
	}
}
