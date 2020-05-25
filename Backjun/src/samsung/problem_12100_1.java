package samsung;

//2048
import java.util.*;
import java.io.*;

public class problem_12100_1 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simulation(board, N);
	}

	private static void simulation(int[][] board, int N) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(board, 0));

		int answer = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.count == 5) {
				answer = Math.max(answer, big(cur.board, N));
				continue;
			}

			for (int i = 0; i < 4; i++) {
				move(i, q, cur, N);
			}
		}
		System.out.println(answer);
	}

	private static void print(int count, int[][] board, int N) {
		System.out.println("count : " + count);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int big(int[][] board, int N) {
		int big = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				big = Math.max(big, board[i][j]);
		}

		return big;
	}

	private static void copyArray(int[][] src, int[][] dest) {
		int idx = 0;

		for (int[] t : src) {
			System.arraycopy(t, 0, dest[idx++], 0, t.length);
		}
	}

	private static void move(int dir, Queue<Node> q, Node cur, int N) {
		int cur_count = cur.count;
		int cur_board[][] = new int[N][N];
		boolean[][] mix = new boolean[N][N];

		copyArray(cur.board, cur_board);

		if (dir == 0) {
			// 위쪽으로 기운 경우
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					int cur_x = j;
					int val = cur_board[j][i];
					cur_board[j][i] = 0;
					boolean check = false;
					// 위로 이동
					while (true) {
						cur_x += ud[dir];

						if (cur_x < 0 || cur_x >= N || cur_board[cur_x][i] != 0) {
							if (cur_x >= 0 && cur_x < N && cur_board[cur_x][i] != 0)
								check = true;

							cur_x -= ud[dir];
							break;
						}
					}

					if (check && cur_board[cur_x + ud[dir]][i] != 0 && cur_board[cur_x + ud[dir]][i] == val) {
						if (!mix[cur_x + ud[dir]][i]) {
							cur_board[cur_x + ud[dir]][i] += val;
							mix[cur_x + ud[dir]][i] = true;
						}else
							cur_board[cur_x][i] = val;
					} else
						cur_board[cur_x][i] = val;
				}
			}
		} else if (dir == 1) {
			// 오른쪽으로 기운 경우
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					int cur_y = j;
					int val = cur_board[i][cur_y];
					cur_board[i][cur_y] = 0;
					boolean check = false;

					// 위로 이동
					while (true) {
						cur_y += rl[dir];

						if (cur_y < 0 || cur_y >= N || cur_board[i][cur_y] != 0) {
							if (cur_y >= 0 && cur_y < N && cur_board[i][cur_y] != 0)
								check = true;

							cur_y -= rl[dir];
							break;
						}
					}

					if (check && cur_board[i][cur_y + rl[dir]] != 0 && cur_board[i][cur_y + rl[dir]] == val) {
						if (!mix[i][cur_y + rl[dir]]) {
							cur_board[i][cur_y + rl[dir]] += val;
							mix[i][cur_y + rl[dir]] = true;
						}else
							cur_board[i][cur_y] = val;
					} else
						cur_board[i][cur_y] = val;
				}
			}
		} else if (dir == 2) {
			// 아래쪽으로 기운 경우
			for (int j = N-1; j >= 0 ; j--) {
				for (int i = 0; i < N ; i++) {
					int cur_x = j;
					int val = cur_board[j][i];
					cur_board[cur_x][i] = 0;
					boolean check = false;

					// 위로 이동
					while (true) {
						cur_x += ud[dir];

						if (cur_x < 0 || cur_x >= N || cur_board[cur_x][i] != 0) {
							if (cur_x >= 0 && cur_x < N && cur_board[cur_x][i] != 0)
								check = true;

							cur_x -= ud[dir];
							break;
						}
					}

					if (check && cur_board[cur_x + ud[dir]][i] != 0 && cur_board[cur_x + ud[dir]][i] == val) {
						if (!mix[cur_x + ud[dir]][i]) {
							cur_board[cur_x + ud[dir]][i] += val;
							mix[cur_x + ud[dir]][i] = true;
						}
						else
							cur_board[cur_x][i] = val;
					} else
						cur_board[cur_x][i] = val;
				}

			}
		} else if (dir == 3) {
			// 왼쪽으로 기운 경우
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cur_y = j;
					int val = cur_board[i][cur_y];
					cur_board[i][cur_y] = 0;
					boolean check = false;

					// 위로 이동
					while (true) {
						cur_y += rl[dir];

						if (cur_y < 0 || cur_y >= N || cur_board[i][cur_y] != 0) {
							if (cur_y >= 0 && cur_y < N && cur_board[i][cur_y] != 0)
								check = true;

							cur_y -= rl[dir];
							break;
						}
					}

					if (check && cur_board[i][cur_y + rl[dir]] != 0 && cur_board[i][cur_y + rl[dir]] == val) {
						if (!mix[i][cur_y + rl[dir]]) {
							cur_board[i][cur_y + rl[dir]] += val;
							mix[i][cur_y + rl[dir]] = true;
						}else
							cur_board[i][cur_y] = val;
					} else
						cur_board[i][cur_y] = val;
				}
			}
		}

		q.add(new Node(cur_board, cur_count + 1));
	}

	private static class Node {
		int count;
		int[][] board;

		public Node(int[][] board, int c) {
			this.count = c;
			this.board = new int[board.length][board.length];

			int idx = 0;
			for (int b[] : board) {
				System.arraycopy(b, 0, this.board[idx++], 0, b.length);
			}

		}
	}
}
