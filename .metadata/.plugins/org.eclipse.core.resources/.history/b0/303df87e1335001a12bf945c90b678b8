package programmers1;

//블록 이동하기
import java.util.*;

public class problem_32 {
	static boolean[][][][] visited = new boolean[101][101][101][101]; // 중복 방문을 방지
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 0 } };
		int result = solution(board);
		System.out.println(result);
	}

	public static int solution(int[][] board) {
		int[][] map = new int[board.length][board[0].length];
		// 배열 값 복사
		for (int i = 0; i < map.length; i++) {
			System.arraycopy(board[i], 0, map[i], 0, board.length);
		}

		Queue<Node> queue = new LinkedList<>(); // BFS를 진행하기 위한 큐
		queue.add(new Node(0, 0, 0, 1, 0)); // 초기 좌표
		visited[0][0][0][1] = true; // 현재 위치 방문
		int answer = 0;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int leftX = cur.leftX, leftY = cur.leftY;
			int rightX = cur.rightX, rightY = cur.rightY;
			int cc = cur.count;

			if (isReach(leftX, leftY, rightX, rightY, map.length-1)) {
				answer = cc;
				break;
			}
			direction(leftX, leftY, rightX, rightY, cc, map, queue); // 4방향 돌려서 방문
			rotation(leftX, leftY, rightX, rightY, cc, map, queue); // 회전
		}

		return answer;
	}

	private static void rotation(int lx, int ly, int rx, int ry, int cc, int[][] map, Queue<Node> queue) {
		// 기준을 두개로 잡아야 됨
		// 왼쪽이 기준이 될 경우
		int d = whichDirection(lx, ly, rx, ry);
		rotation(d, lx, ly, rx, ry, cc, map, queue);

		// 오른쪽이 기준이 될 경우
		d = whichDirection(rx, ry, lx, ly);
		rotation(d, rx, ry, lx, ly, cc, map, queue);

	}

	private static void rotation(int d, int baseX, int baseY, int targetX, int targetY, int cc, int[][] map,
			Queue<Node> queue) {
		int count = cc;
		if (d == 0 || d == 2) {
			// 타켓의 위치가 남 혹은 북일 경우
			int ud[] = new int[2];

			if (d == 0) {
				ud[0] = 1;
				ud[1] = 1;
			} else {
				ud[0] = -1;
				ud[1] = -1;
			}
			int rl[] = { -1, 1 };
			for (int i = 0; i < 2; i++) {
				int nx = targetX + ud[i];
				int ny = targetY + rl[i];
				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length) // 범위 밖인 경우
					continue;

				if (map[targetX][targetY + rl[i]] == 1 || map[nx][ny] == 1) // 회전했는데 벽이 있을 경우
					continue;

				if (ny < baseY) {
					if (!visited[nx][ny][baseX][baseY]) {
						visited[nx][ny][baseX][baseY] = true;
						queue.add(new Node(nx, ny, baseX, baseY, count + 1));
					}
				} else {
					if (!visited[baseX][baseY][nx][ny]) {
						visited[baseX][baseY][nx][ny] = true;
						queue.add(new Node(baseX, baseY, nx, ny, count + 1));
					}
				}
			}
		} else {
			// 타켓의 위치가 동 혹은 서일 경우
			int ud[] = { -1, 1 };
			int rl[] = new int[2];

			if (d == 1) {
				// 타켓이 서쪽인 경우
				rl[0] = -1;
				rl[1] = -1;
			} else {
				rl[0] = 1;
				rl[1] = 1;
			}

			for (int i = 0; i < 2; i++) {
				int nx = targetX + ud[i];
				int ny = targetY + rl[i];
				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length) // 범위 밖인 경우
					continue;

				if (map[targetX + ud[i]][targetY] == 1 || map[nx][ny] == 1) // 회전했는데 벽이 있을 경우
					continue;

				if (nx < baseX) {
					if (!visited[nx][ny][baseX][baseY]) {
						visited[nx][ny][baseX][baseY] = true;
						queue.add(new Node(nx, ny, baseX, baseY, count + 1));
					}
				} else {
					if (!visited[baseX][baseY][nx][ny]) {
						visited[baseX][baseY][nx][ny] = true;
						queue.add(new Node(baseX, baseY, nx, ny, count + 1));
					}
				}
			}
		}
	}

	private static int whichDirection(int baseX, int baseY, int targetX, int targetY) {
		int x = baseX - targetX;
		int y = baseY - targetY;
		int direction = 0;
		if (x == 0) {
			if (y < 0)
				direction = 1;
			else
				direction = 3;
		} else {
			if (x < 0)
				direction = 2;
			else
				direction = 0;
		}

		return direction;
	}

	private static boolean isReach(int lx, int ly, int rx, int ry, int N) {
		if ((lx == N && ly == N) || (rx == N && ry == N)) // 두 개 중, 한개가 (N,N)에 도착했을 경우
			return true;

		return false;

	}

	private static void direction(int lx, int ly, int rx, int ry, int cc, int[][] map, Queue<Node> queue) {
		int baseX = Math.min(lx, rx); // 북쪽
		int baseY = Math.min(ly, ry); // 동쪽
		int baseXX = Math.max(lx, rx); // 남쪽
		int baseYY = Math.max(ly, ry); // 서쪽
		int count = cc;
		// 북쪽
		int nx = baseX + ud[0];
		if (nx >= 1) // 범위 내에 존재할 경우
		{
			if (map[lx - 1][ly] == 0 && map[rx - 1][ry] == 0) { // 둘다 벽이 없을 경우
				if (!visited[lx - 1][ly][rx - 1][ry]) {
					visited[lx - 1][ly][rx - 1][ry] = true;
					queue.add(new Node(lx - 1, ly, rx - 1, ry, count + 1));
				}
			}
		}

		// 서쪽
		int ny = baseYY + rl[1];
		if (ny < map[lx].length) {
			if (map[lx][ly + 1] == 0 && map[rx][ry + 1] == 0) {
				if (!visited[lx][ly + 1][rx][ry + 1]) {
					visited[lx][ly + 1][rx][ry + 1] = true;
					queue.add(new Node(lx, ly + 1, rx, ry + 1, count + 1));
				}
			}
		}

		// 남쪽
		nx = baseXX + ud[2];
		if (nx < map.length) {
			if (map[lx + 1][ly] == 0 && map[rx + 1][ry] == 0) {
				if (!visited[lx + 1][ly][rx + 1][ry]) {
					visited[lx + 1][ly][rx + 1][ry] = true;
					queue.add(new Node(lx + 1, ly, rx + 1, ry, count + 1));
				}
			}
		}

		// 동쪽
		ny = baseY + rl[3];
		if (ny >= 1) {
			if (map[lx][ly - 1] == 0 && map[rx][ry - 1] == 0) {
				if (!visited[lx][ly - 1][rx][ry - 1]) {
					visited[lx][ly - 1][rx][ry - 1] = true;
					queue.add(new Node(lx, ly - 1, rx, ry - 1, count + 1));
				}
			}
		}

	}

	private static class Node {
		int leftX, leftY;
		int rightX, rightY;
		int count;

		public Node(int lx, int ly, int rx, int ry, int c) {
			this.leftX = lx;
			this.leftY = ly;
			this.rightX = rx;
			this.rightY = ry;
			this.count = c;
		}
	}
}
