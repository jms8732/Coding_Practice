package kakao_2021;

import java.util.*;

/*
 * 카드짝 맞추기
 * 구현 + 조합 문제
 * 
 */
public class problem_6 {
	static List<Point>[] card;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int r = 1, c = 0;
		int[][] board = { { 1, 0, 0, 3 }, { 2, 0, 0, 0 }, { 0, 0, 0, 2 }, { 3, 0, 1, 0 } };
		System.out.print(solution(board, r, c));
	}

	public static int solution(int[][] board, int r, int c) {
		Set<Integer> temp = new TreeSet<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] != 0)
					temp.add(board[i][j]);
			}
		}

		card = new ArrayList[temp.size()];
		for (int i = 0; i < card.length; i++) {
			card[i] = new ArrayList<>();
		}

		// 각 카드별로 좌표 저장
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 0) {
					card[board[i][j] - 1].add(new Point(i, j));
				}
			}
		}

		int[] total = temp.stream().mapToInt(i -> i).toArray();
		int[] combi = new int[total.length];
		boolean[] visited = new boolean[total.length];
		combination(0, r, c, combi, visited, total, board);
		return ans;
	}

	// 조합 생성
	private static void combination(int depth, int sx, int sy, int[] comb, boolean[] visited, int[] total,
			int[][] board) {
		if (depth == comb.length) {
			ans = Math.min(ans, simulation(sx, sy, comb, board));
			return;
		}

		for (int i = 0; i < total.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb[depth] = total[i];
				combination(depth + 1, sx, sy, comb, visited, total, board);
				visited[i] = false;
			}
		}
	}

	private static int simulation(int sx, int sy, int[] comb, int[][] b) {
		List<Point> seq = new ArrayList<>();
		int ret = 0;
		Point start = new Point(sx, sy);

		int[][] board = new int[b.length][];
		copyArray(b, board);
		
		for (int i = 0; i < comb.length; i++) {
			int cur = comb[i] - 1;

			int totalMin = Integer.MAX_VALUE;
			int min = Integer.MAX_VALUE;

			seq.add(start);
			// X -> Y
			for (int j = 0; j < card[cur].size(); j++) {
				seq.add(card[cur].get(j));
			}

			min = bfs(seq, board);

			if (min < totalMin) {
				totalMin = min;
				start = seq.get(seq.size() - 1);
			}

			// Y -> X
			seq.removeAll(seq.subList(1, seq.size()));
			for (int j = card[cur].size() - 1; j >= 0; j--) {
				seq.add(card[cur].get(j));
			}

			min = bfs(seq, board);

			if (min < totalMin) {
				totalMin = min;
				start = seq.get(seq.size() - 1);
			}

			ret += totalMin;

			removePicture(card[cur], board);
			seq.clear();
		}

		return ret;
	}

	private static void copyArray(int[][] src, int[][] dest) {
		int idx = 0;
		for (int[] s : src) {
			dest[idx++] = Arrays.copyOf(s, s.length);
		}
	}

	private static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 그림 삭제
	private static void removePicture(List<Point> seq, int[][] board) {
		for (Point p : seq) {
			int x = p.x;
			int y = p.y;

			board[x][y] = 0;
		}
	}

	private static int bfs(List<Point> seq, int[][] board) {
		int ret = 0;

		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };

		Queue<Point> q = new LinkedList<>();
		q.add(seq.get(0));

		int step = 0, idx = 1;
		boolean[][] visited = new boolean[board.length][board[0].length];

		while (idx < 3) {
			if (containPoint(q, seq.get(idx))) {
				Point next = seq.get(idx);
				idx++;
				q.clear();
				q.add(next);

				ret += step;
				step = 0;
				clear(visited);
				continue;
			}

			Queue<Point> temp = new LinkedList<>(q);
			q.clear();
			// 현재 좌표에서 움직일 수 있는 한 사이클
			while (!temp.isEmpty()) {
				Point cur = temp.poll();

				visited[cur.x][cur.y] = true;
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + ud[i];
					int ny = cur.y + rl[i];

					if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length)
						continue;

					if (visited[nx][ny])
						continue;

					visited[nx][ny] = true;
					q.add(new Point(nx, ny));
				}

				ctrlMove(q, cur.x, cur.y, board, visited);
			}

			step++;
		}

		return ret + 2;
	}

	private static void clear(boolean[][] visited) {
		for (boolean[] b : visited) {
			Arrays.fill(b, false);
		}
	}

	private static boolean containPoint(Queue<Point> q, Point cur) {
		int size = q.size();
		int idx = -1;

		while (++idx < size) {
			Point qp = q.peek();

			if (qp.x == cur.x && qp.y == cur.y) {
				// 현재 경로에 현재 좌표가 있는 경우
				return true;
			}

			q.add(q.poll());
		}

		return false;
	}

	private static void ctrlMove(Queue<Point> q, int x, int y, int[][] board, boolean[][] visited) {
		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {
			int nx = x;
			int ny = y;

			while (true) {
				nx = nx + ud[i];
				ny = ny + rl[i];
				// 벗어나는 경우
				if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
					nx -= ud[i];
					ny -= rl[i];
					break;
				}

				// 가다가 숫자가 있는 경우
				if (board[nx][ny] != 0)
					break;

			}

			if (!visited[nx][ny]) {
				visited[nx][ny] = true;
				q.add(new Point(nx, ny));
			}
		}

	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
