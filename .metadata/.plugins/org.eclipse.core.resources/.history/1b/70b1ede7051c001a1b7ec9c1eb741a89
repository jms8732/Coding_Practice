package dfs;
import java.util.*;

public class problem_2667 {
	static int[][] map = new int[26][26];
	static boolean[][] visited = new boolean[26][26];
	static int[] rl = { -1, 0, 1, 0 };
	static int[] ud = { 0, -1, 0, 1 };
	static int total = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int danzi = scanner.nextInt();
		Vector<Integer> sort = new Vector<>();
		for (int i = 0; i < danzi; i++) {
			String tmp = scanner.next();
			char[] ctmp = tmp.toCharArray();
			for(int j = 0  ; j < tmp.length(); j++) {
				map[i][j] = ctmp[j] - '0';
				
			}
		}
		for (int i = 0; i < danzi; i++) {
			for (int j = 0; j < danzi; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					total++;
					total = DFS(i, j);
					sort.add(total);
					total = 0;
				}
			}
		}
		Object[] obs = sort.toArray();
		Arrays.sort(obs);
		System.out.println(sort.size());
		for(int i = 0; i < obs.length ; i++) {
			System.out.println((int)obs[i]);
		}
		
	}

	static int DFS(int x, int y) {
		for (int i = 0; i < rl.length; i++) {
			int nx = x + rl[i];
			int ny = y + ud[i];

			if (nx < 0 || nx > map.length || ny < 0 || ny > map.length)
				continue;
			else {
				if (!visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					total++;
					DFS(nx, ny);
				}
			}
		}
		return total;
	}
}
