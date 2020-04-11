package search_algorithm;

//로봇, 시간 내에 못품

import java.util.*;
import java.io.*;

public class problem_1726 {
	// 동 서 남 북
	static int ud[] = { 0, 0, 1, -1 };
	static int rl[] = { 1, -1, 0, 0 };
	static BufferedReader br;

	public static void main(String[] args0) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simulation(map, N, M);
	}

	private static void simulation(int[][] map, int N, int M) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int startX = Integer.parseInt(st.nextToken()) - 1;
		int startY = Integer.parseInt(st.nextToken()) - 1;
		int startD = Integer.parseInt(st.nextToken()) - 1;

		boolean[][][] visited = new boolean[N][M][4];

		Queue<robot> q = new LinkedList<>();

		q.add(new robot(startX, startY, 0, startD));
		visited[startX][startY][startD] = true;

		st = new StringTokenizer(br.readLine());

		int endX = Integer.parseInt(st.nextToken()) - 1;
		int endY = Integer.parseInt(st.nextToken()) - 1;
		int endD = Integer.parseInt(st.nextToken()) - 1;

		int answer = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			robot cur = q.poll();

			if (cur.x == endX && cur.y == endY) {
				int tmp = cal(cur, endD);
				answer = Math.min(answer, tmp);
				continue;
			}

			move(cur, N, M, map, visited, q);
			rotation(cur, N, M, visited, map, q);

		}

		System.out.println(answer);
	}

	private static int cal(robot cur, int endD) {
		int left = cur.dir;
		int leftCount = cur.count;

		while (true) {
			if (left == endD)
				break;
			leftCount++;
			left = left(left);
		}

		int right = cur.dir;
		int rightCount = cur.count;

		while (true) {
			if (right == endD)
				break;

			rightCount++;
			right = right(right);

		}

		int answer = Math.min(leftCount, rightCount);
		return answer;
	}

	private static int right(int dir) {
		switch (dir) {
		case 0:
			dir = 2;
			break;
		case 2:
			dir = 1;
			break;
		case 1:
			dir = 3;
			break;
		case 3:
			dir = 0;
			break;
		}

		return dir;
	}

	private static int left(int dir) {
		switch (dir) {
		case 0:
			dir = 3;
			break;
		case 3:
			dir = 1;
			break;
		case 1:
			dir = 2;
			break;
		case 2:
			dir = 0;
			break;
		}
		return dir;
	}

	private static void rotation(robot cur, int N, int M, boolean[][][] visited, int[][] map, Queue<robot> q) {
		int curDir = cur.dir;
		int curX = cur.x;
		int curY = cur.y;

		int left_90, right_90, left_180;

		left_90 = left(curDir);
		if (!visited[curX][curY][left_90]) {
			visited[curX][curY][left_90] = true;
			q.add(new robot(curX, curY, cur.count + 1, left_90));
		}

		right_90 = right(curDir);
		if (!visited[curX][curY][right_90]) {
			visited[curX][curY][right_90] = true;
			q.add(new robot(curX, curY, cur.count + 1, right_90));
		}

		left_180 = left(curDir);
		left_180 = left(left_180);
		if (!visited[curX][curY][left_180]) {
			visited[curX][curY][left_180] = true;
			q.add(new robot(curX, curY, cur.count + 2, left_180));
		}

	}

	private static void move(robot cur, int N, int M, int[][] map, boolean[][][] visited, Queue<robot> q) {
		int curX = cur.x;
		int curY = cur.y;
		for (int i = 0; i < 3; i++) {
			int nx = curX + ud[cur.dir];
			int ny = curY + rl[cur.dir];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1)
				continue;

			if (!visited[nx][ny][cur.dir]) {
				visited[nx][ny][cur.dir] = true;
				q.add(new robot(nx, ny, cur.count + 1, cur.dir));
			}

			curX = nx;
			curY = ny;
		}
	}

	private static class robot {
		int x, y, count, dir;

		public robot(int x, int y, int c, int d) {
			this.x = x;
			this.y = y;
			this.count = c;
			this.dir = d;
		}
	}
}
