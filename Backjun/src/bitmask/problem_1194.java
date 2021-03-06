package bitmask;

import java.util.*;
import java.io.*;

//달이 차오른다, 가자

public class problem_1194 {
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M][1 << 6];
		int startX = 0, startY = 0;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				char tmp = line.charAt(j);
				if (tmp == '0') {
					startX = i;
					startY = j;
				}
				map[i][j] = tmp;
			}
		}

		bfs(startX, startY);
	}

	private static void bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<>();
		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };

		queue.add(new Node(0, startX, startY, 0));

		while (!queue.isEmpty()) {
			Node current = queue.poll();
			int cx = current.x;
			int cy = current.y;
			int ck = current.key;
			int cc = current.count;

			if (finish(cx, cy)) {
				System.out.println(cc);
				System.exit(0);
			}

			for (int i = 0; i < 4; i++) {

				int nx = cx + ud[i];
				int ny = cy + rl[i];

				// 배열의 범위 밖과 벽인 경우
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == '#') {
					continue;
				}

				// 키를 발견 했을 경우
				if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
					ck |= 1 << (map[nx][ny] - 'a');
				}

				// 문을 발견 했을 경우
				if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
					// 해당 문에 받는 키가 없을 경우
					if ((ck & (1 << map[nx][ny] - 'A')) != (1 << map[nx][ny] - 'A'))
						continue;
				}

				if (!visited[nx][ny][ck])
					queue.add(new Node(ck, nx, ny, cc + 1));
				visited[nx][ny][ck] = true;
				ck = current.key;

			}
		}

		System.out.println(-1);
	}

	private static boolean finish(int x, int y) {
		if (map[x][y] == '1')
			return true;

		return false;
	}

	private static class Node {
		int key, x, y;
		int count;

		public Node(int key, int x, int y, int count) {
			this.key = key;
			this.x = x;
			this.y = y;
			int idx = 0;
			this.count = count;
		}
	}
}
