package samsung;

//이차원 배열과 연산
import java.util.*;
import java.io.*;

public class problem_17142 {
	static List<Virus> list;
	static int answer = -1;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				String tmp = st.nextToken();
				if (tmp.equals("2")) {
					list.add(new Virus(i, j,0));
				}
				map[i][j] = Integer.parseInt(tmp);
			}
		}

		List<Virus> value = new ArrayList<>();
		virus(0, 0, map, value);
		System.out.println(answer);
	}

	private static void virus(int depth, int next, int[][] map, List<Virus> value) {
		if (depth == M) {
			int v = infection(value, map);

			if (v != -1) {
				if (answer == -1) {
					answer = v;
				} else
					answer = Math.min(answer, v);
			}
			return;
		}
		for (int i = next; i < list.size(); i++) {
			value.add(list.get(i));
			virus(depth + 1, i + 1, map, value);
			value.remove(list.get(i));
		}
	}

	private static int infection(List<Virus> value, int[][] map) {
		boolean[][] visited = new boolean[N][N];
		int[][] board = new int[N][N];
		int answer = 0;

		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };

		Queue<Virus> q = new LinkedList<>();

		for (int i = 0; i < value.size(); i++) {
			q.add(value.get(i));
			visited[value.get(i).x][value.get(i).y] = true;
			visited = new boolean[N][N];

			while (!q.isEmpty()) {
				Virus cur = q.poll();

				for (int j = 0; j < 4; j++) {
					int nx = cur.x + ud[j];
					int ny = cur.y + rl[j];

					if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == 1)
						continue;

					visited[nx][ny] = true;
					if (board[nx][ny] != 0)
						board[nx][ny] = Math.min(board[nx][ny], cur.count+ 1);
					else
						board[nx][ny] = cur.count + 1;

					q.add(new Virus(nx, ny,board[nx][ny]));
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 && board[i][j] == 0)
					return -1;
			}
		}
		
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < N ; j++) {
				if(map[i][j] == 0)
					answer = Math.max(answer, board[i][j]);
			}
		}

		return answer;

	}

	private static class Virus {
		int x, y, count;

		public Virus(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.count = c;
		}
	}
}
