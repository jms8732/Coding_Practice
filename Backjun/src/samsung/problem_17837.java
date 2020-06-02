package samsung;

//새로운 게임 2
import java.util.*;
import java.io.*;

public class problem_17837 {
	static board[][] b;
	static int chess_number = 1;
	static int ud[] = { 0, 0, -1, 1 };
	static int rl[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		b = new board[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int c = Integer.parseInt(st.nextToken());
				b[i][j] = new board(c);
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());

			b[x][y].list.add(new chess(d, chess_number++));
		}

		simulation(N);
	}

	private static void simulation(int N) {
		int number = 0;

		while (number <= 1000) {
			number++;
			if(pick_chess(N)) {
				System.out.println(number);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}

	private static boolean is_finish(int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (b[i][j].list.size() >= 4)
					return true;
			}
		}

		return false;
	}

	private static boolean pick_chess(int N) {
		for (int k = 1; k < chess_number; k++) {
			int x = 0, y = 0;
			chess cur = null;
			outter: for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!b[i][j].list.isEmpty()) {
						for (chess c : b[i][j].list) {
							if (k == c.number) {
								x = i;
								y = j;
								cur = c;
								break outter;
							}
						}
					}
				}
			}

			move_chess(x, y, cur, N);
			if(is_finish(N))
				return true;
		}
		return false;
	}

	private static void move_chess(int x, int y, chess cur, int N) {

		int nx = x + ud[cur.dir - 1];
		int ny = y + rl[cur.dir - 1];

		// 파란색과 동일하게 이동
		if (nx < 0 || nx >= N || ny < 0 || ny >= N || b[nx][ny].color == 2) {
			// 방향을 반대로
			if (cur.dir == 1)
				cur.dir = 2;
			else if (cur.dir == 2)
				cur.dir = 1;
			else if (cur.dir == 3)
				cur.dir = 4;
			else
				cur.dir = 3;

			nx = x + ud[cur.dir - 1];
			ny = y + rl[cur.dir - 1];

			// 다음에 이동하려는 칸이 파란색이 아닌 경우
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && b[nx][ny].color != 2) {
				add(cur, nx, ny, x, y, N,b[nx][ny].color);
			}

			return;
		}

		add(cur, nx, ny, x, y, N,b[nx][ny].color);

		return;
	}

	private static void add(chess cur, int nx, int ny, int x, int y, int N, int c) {
		int start = b[x][y].list.indexOf(cur);
		List<chess> tmp = new ArrayList(b[x][y].list.subList(start, b[x][y].list.size()));
		List<chess> remain = new ArrayList(b[x][y].list.subList(0, start));

		if (c == 1) {
			Collections.reverse(tmp);
			b[nx][ny].list.addAll(tmp);
		}else
			b[nx][ny].list.addAll(tmp);

		b[x][y].list.clear();

		if (!remain.isEmpty())
			b[x][y].list.addAll(remain);

	}

	private static void print(int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!b[i][j].list.isEmpty()) {
					for (chess c : b[i][j].list) {
						System.out.print("(" + c.number + "," + c.dir + ")");
					}
					System.out.print("   ");
				} else
					System.out.print(b[i][j].color + "   ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static class board {
		List<chess> list;
		int color;

		public board(int c) {
			this.list = new ArrayList<>();
			this.color = c;
		}
	}

	private static class chess {
		int dir;
		int number;

		public chess(int d, int n) {
			this.number = n;
			this.dir = d;
		}
	}
}
