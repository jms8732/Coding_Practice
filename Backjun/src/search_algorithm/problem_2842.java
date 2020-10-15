package search_algorithm;

/*
 * 집배원 한상덕
 * 투 포인터 + BFS를 이용하여 문제 해결
 * 
 * 투 포인터를 이용하여 찾을 범위를 지정하고 BFS를 통해 범위 내에 이동이 가능한 지 판단하면 된다.
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

		int K_count = 0; // K의 개수
		// 초기 값
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				if (temp.charAt(j) == 'P') { // P좌표 설정
					startX = i;
					startY = j;
				} else if (temp.charAt(j) == 'K')
					K_count++;

				map[i][j] = temp.charAt(j);
			}
		}

		Set<Integer> set = new TreeSet<>(); // 오름차순 정렬을 진행하기 위해서 TreeSet사용

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				set.add(t);
				map_value[i][j] = t;
			}
		}

		array = new int[set.size()]; // set 사이즈 만큼 배열 크기 할당

		int idx = 0;

		// 할당한 배열에 Set에 있는 값 할당
		for (int i : set) {
			array[idx++] = i;
		}

		System.out.println(two_point(K_count));
	}

	// 투 포인터 진행
	private static int two_point(int K_count) {
		int ret = Integer.MAX_VALUE, left = 0, right = 0;
		while (left <= right && right < array.length) {

			int l_val = array[left];
			int r_val = array[right];

			// 해당 값들로 이동 집배원의 이동이 가능한지 파악
			if (bfs(l_val, r_val, K_count)) {
				// 다 돌 수 있는 경우
				left++;
				ret = Math.min(ret, r_val - l_val);
			} else {
				// 불가능한 경우
				right++;
			}
		}

		return ret;
	}

	private static boolean bfs(int left, int right, int K_count) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];

		// 시작 값이 범위 밖인 경우
		if (left > map_value[startX][startY] || map_value[startX][startY] > right)
			return false;

		q.add(new Point(startX, startY)); // 집배원의 시작 위치 저장
		visited[startX][startY] = true;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			if (map[cur.x][cur.y] == 'K') {
				K_count--;
			}

			// 8방향으로 이동 가능한지 파악한다.
			for (int i = 0; i < ud.length; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				// 범위를 벗어난 경우 혹은 이미 방문한 경우
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
					continue;

				// 범위 내 존재 할 경우
				if (left <= map_value[nx][ny] && map_value[nx][ny] <= right) {
					visited[nx][ny] = true;
					q.add(new Point(nx, ny));
				}

			}

		}

		// 지정된 범위로 모든 집을 다 방문했을 경우
		if (K_count == 0)
			return true;

		return false;
	}

	// 좌표를 저장하는 클래스
	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
