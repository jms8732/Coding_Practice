package search_algorithm;

//�ٸ� �����, 1:30 -> 46:04 (44�� �ҿ�)
import java.util.*;
import java.io.*;

public class problem_2146 {
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];

		StringTokenizer st = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		simulation(map, N);
	}

	private static void simulation(char[][] map, int N) {
		List<List<Point>> totalIsland = new ArrayList<>();

		boolean[][] visited = new boolean[N][N];

		// map�� �ִ� ���� ã�´�.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == '1') {
					List<Point> tmp = new ArrayList<>();
					tmp.add(new Point(i, j, 0));
					findIsland(map, N, i, j, visited, tmp);

					totalIsland.add(tmp);
				}
			}
		}

		// ��� ���� �̿��Ͽ� ª�� �ٸ��� ����Ѵ�.
		for (int i = 0; i < totalIsland.size(); i++) {
			buildBridge(totalIsland.get(i), map, N);
		}

		System.out.println(answer);
	}

	private static void buildBridge(List<Point> island, char[][] map, int N) {
		Queue<Point> q = new LinkedList<>(island);
		boolean[][] visited = new boolean[N][N];
		int[][] board = new int[N][N];

		for (int i = 0; i < island.size(); i++) {
			Point cur = island.get(i);
			visited[cur.x][cur.y] = true;
		}

		while (!q.isEmpty()) {
			q = build(q, visited, board, map, N);
		}

	}

	private static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static Queue<Point> build(Queue<Point> q, boolean[][] visited, int[][] board, char[][] map, int N) {
		Queue<Point> ans = new LinkedList<>();
		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				// �迭 ���� ���̰ų� �湮�� �����̰ų� ������ ���
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
					continue;

				// �ٸ��� ������ �Ǽ��� ���
				if (map[nx][ny] == '1') {
					answer = Math.min(answer, board[cur.x][cur.y]);
					continue;
				}

				visited[nx][ny] = true;

				if (board[nx][ny] == 0)
					board[nx][ny] = cur.c + 1;
				else
					board[nx][ny] = Math.min(board[nx][ny], cur.c + 1);

				ans.add(new Point(nx, ny, cur.c + 1));
			}
		}
		return ans;
	}

	private static void findIsland(char[][] map, int N, int x, int y, boolean[][] visited, List<Point> list) {

		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			// �迭�� ������ ����ų� �湮�� ������ ���, �ٴ��� ���
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == '0')
				continue;

			list.add(new Point(nx, ny, 0));
			findIsland(map, N, nx, ny, visited, list);

		}
	}

	private static class Point {
		int x, y, c;

		public Point(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
