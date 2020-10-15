package search_algorithm;

/*
 * ����� �ѻ��
 * �� ������ + BFS�� �̿��Ͽ� ���� �ذ�
 * 
 * �� �����͸� �̿��Ͽ� ã�� ������ �����ϰ� BFS�� ���� ���� ���� �̵��� ������ �� �Ǵ��ϸ� �ȴ�.
 */
import java.util.*;
import java.io.*;

public class problem_2842 {
	static int N;
	static char[][] map;
	static int[] array;
	static int startX, startY;
	static int[] ud = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] rl = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[][] map_value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		map = new char[N][N];
		map_value = new int[N][N];

		int K_count = 0; // K�� ����
		// �ʱ� ��
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				if (temp.charAt(j) == 'P') { // P��ǥ ����
					startX = i;
					startY = j;
				} else if (temp.charAt(j) == 'K')
					K_count++;

				map[i][j] = temp.charAt(j);
			}
		}

		Set<Integer> set = new TreeSet<>(); // �������� ������ �����ϱ� ���ؼ� TreeSet���

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				set.add(t);
				map_value[i][j] = t;
			}
		}

		array = new int[set.size()]; // set ������ ��ŭ �迭 ũ�� �Ҵ�

		int idx = 0;

		// �Ҵ��� �迭�� Set�� �ִ� �� �Ҵ�
		for (int i : set) {
			array[idx++] = i;
		}

		System.out.println(two_point(K_count));
	}

	// �� ������ ����
	private static int two_point(int K_count) {
		int ret = Integer.MAX_VALUE, left = 0, right = 0;
		while (left <= right && right < array.length) {

			int l_val = array[left];
			int r_val = array[right];

			// �ش� ����� �̵� ������� �̵��� �������� �ľ�
			if (bfs(l_val, r_val, K_count)) {
				// �� �� �� �ִ� ���
				left++;
				ret = Math.min(ret, r_val - l_val);
			} else {
				// �Ұ����� ���
				right++;
			}
		}

		return ret;
	}

	private static boolean bfs(int left, int right, int K_count) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];

		// ���� ���� ���� ���� ���
		if (left > map_value[startX][startY] || map_value[startX][startY] > right)
			return false;

		q.add(new Point(startX, startY)); // ������� ���� ��ġ ����
		visited[startX][startY] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (map[cur.x][cur.y] == 'K') {
				K_count--;
			}

			// 8�������� �̵� �������� �ľ��Ѵ�.
			for (int i = 0; i < ud.length; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				// ������ ��� ��� Ȥ�� �̹� �湮�� ���
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
					continue;

				// ���� �� ���� �� ���
				if (left <= map_value[nx][ny] && map_value[nx][ny] <= right) {
					visited[nx][ny] = true;
					q.add(new Point(nx, ny));
				}

			}

		}

		// ������ ������ ��� ���� �� �湮���� ���
		if (K_count == 0)
			return true;

		return false;
	}

	// ��ǥ�� �����ϴ� Ŭ����
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
