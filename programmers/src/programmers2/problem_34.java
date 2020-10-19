package programmers2;

/*
 * 경주로 건설
 * 6차원 boolean 배열 + BFS
 * 이전 좌표, 현재 좌표, 다음 좌표를 6차원 boolean 배열의 인덱스로 하여 탐색을 진행한다.
 * 6차원으로 설정한 이유는 한 좌표에 동일한 비용으로 올 수 있지만 다음 방향에 따라서 비용의 값이 달라지기 때문이다. (ex, 예제 3)
 */
import java.util.*;

public class problem_34 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 1 }, { 1, 0, 0, 0 } };
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
		return bfs(board.length, board);
	}

	private static int bfs(int N, int[][] board) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				return Integer.compare(arg0.cost, arg1.cost);
			}

		});

		boolean[][][][][][] visited = new boolean[N][N][N][N][N][N];
		visited[0][0][0][0][0][0] = true;
		pq.add(new Node(0, 0, 0, 0, 0));

		int cost = Integer.MAX_VALUE;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			// 도착한 경우
			if (cur.cx == N - 1 && cur.cy == N - 1) {
				cost = Math.min(cost, cur.cost);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.cx + ud[i];
				int ny = cur.cy + rl[i];

				// 배열의 범위 밖이거나 방문한 경우
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1
						|| visited[cur.px][cur.py][cur.cx][cur.cy][nx][ny]
						|| visited[nx][ny][cur.cx][cur.cy][cur.px][cur.py])
					continue;

				visited[cur.px][cur.py][cur.cx][cur.cy][nx][ny] = true;
				visited[nx][ny][cur.cx][cur.cy][cur.px][cur.py] = true;

				int diffX = Math.abs(nx - cur.px);
				int diffY = Math.abs(ny - cur.py);

				if (diffX == 1 && diffY == 1) {
					// 커브인 경우
					pq.add(new Node(cur.cx, cur.cy, nx, ny, cur.cost + 600));
				} else {
					// 커브가 아닌 경우
					pq.add(new Node(cur.cx, cur.cy, nx, ny, cur.cost + 100));
				}
			}
		}

		return cost;
	}

	private static class Node {
		int px, py, cx, cy, cost;

		public Node(int px, int py, int cx, int cy, int cost) {
			this.cost = cost;
			this.px = px;
			this.py = py;
			this.cx = cx;
			this.cy = cy;
		}
	}
}
