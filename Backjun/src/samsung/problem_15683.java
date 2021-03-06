package samsung;

//감시
import java.util.*;
import java.io.*;

public class problem_15683 {
	static int N, M;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int camera = 0;

		List<List<Integer>> list = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp != 0 && tmp != 6) { // 벽과 빈 공간이 아닌 경우
					// 카메라 좌표 값들 설정
					List<Integer> tmpList = new ArrayList<>();
					tmpList.add(i);
					tmpList.add(j);
					list.add(tmpList);
				}
				map[i][j] = tmp;
			}
		}
		int depth = 0, count = 0;
		
		dfs(list, depth, list.size(), map);
		
		System.out.println(min);
	}

	private static void print(int[][] map) {
		for (int i[] : map) {
			for (int j : i)
				System.out.print(j + " ");
			System.out.println();
		}
	}

	private static void countBlank(int[][] map) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}

		min = Math.min(min, count);
	}

	private static void dfs(List<List<Integer>> list, int depth, int size, int[][] map) {
		if (depth == size) {
			countBlank(map);
			return;
		}
		int[][] tmpMap = new int[N][M];

		copyMap(map, tmpMap);

		List<Integer> tmpList = list.get(depth);
		int x = tmpList.get(0);
		int y = tmpList.get(1);

		switch (map[x][y]) {
		case 1: {
			for (int i = 0; i < 4; i++) {
				fill(i, x, y, map); // 해당 방향으로 값 채워 넣기
				dfs(list, depth + 1, size, map);
				copyMap(tmpMap, map); // 원상태로 복귀
			}
			break;
		}
		case 2: {
			int[] ud = { 2, 3 };
			int[] rl = { 0, 1 };
			for (int i = 0; i < 2; i++) {
				fill(ud[i], x, y, map);
				fill(rl[i], x, y, map);
				dfs(list, depth + 1, size, map);
				copyMap(tmpMap, map);
			}
			break;
		}

		case 3: {
			int ud[] = { 0, 1, 2, 3 };
			int rl[] = { 1, 2, 3, 0 };
			for (int i = 0; i < 4; i++) {
				fill(ud[i], x, y, map);
				fill(rl[i], x, y, map);
				dfs(list, depth + 1, size, map);
				copyMap(tmpMap, map);
			}
			break;
		}
		case 4: {
			int ud[] = { 3, 0, 1, 2 };
			int rl[] = { 0, 1, 2, 3 };
			int lr[] = { 1, 2, 3, 0 };
			for (int i = 0; i < 4; i++) {
				fill(ud[i], x, y, map);
				fill(rl[i], x, y, map);
				fill(lr[i], x, y, map);
				dfs(list, depth + 1, size, map);
				copyMap(tmpMap, map);
			}
			break;
		}
		case 5: {
			fill(0, x, y, map);
			fill(1, x, y, map);
			fill(2, x, y, map);
			fill(3, x, y, map);
			dfs(list, depth + 1, size, map);
			copyMap(tmpMap, map);
			break;
		}
		}

	}

	private static void copyMap(int[][] src, int[][] dest) {
		int idx = 0;
		for (int[] i : src) {
			System.arraycopy(i, 0, dest[idx], 0, i.length);
			idx++;
		}
	}

	private static void fill(int direction, int x, int y, int[][] map) {
		switch (direction) {
		case 0: // 위로 계속 더함
		{
			while (true) {
				int nx = x - 1;
				if (nx < 0 || nx >= N ||  map[nx][y] == 6)
					break;
				if(map[nx][y] != 0) {
					x= nx;
					continue;
				}
				map[nx][y] = -1; // 색칠
				x = nx;
			}
			break;
		}
		case 1: { // 오른쪽으로 계속 증가
			while (true) {
				int ny = y + 1;
				if (ny < 0 || ny >= M || map[x][ny] == 6) // 범위를 벗어나거나 벽 혹은 다른게 있을 경우
					break;
				if(map[x][ny] != 0) {
					y= ny;
					continue;
				}
				map[x][ny] = -1;
				y = ny;
			}
			break;
		}
		case 2: { // 밑으로 계속 증가
			while (true) {
				int nx = x + 1;
				if (nx < 0 || nx >= N ||  map[nx][y] == 6)
					break;

				if(map[nx][y] != 0) {
					x =nx;
					continue;
				}
				map[nx][y] = -1; // 색칠
				x = nx;
			}
			break;
		}
		case 3: { // 왼쪽으로 계속 증가
			while (true) {
				int ny = y - 1;
				if (ny < 0 || ny >= M || map[x][ny] == 6) // 범위를 벗어나거나 벽 혹은 다른게 있을 경우
					break;

				if(map[x][ny] != 0) { //카메라가 있는 경우
					y =ny;
					continue;
				}
				map[x][ny] = -1;
				y = ny;
			}
			break;
		}
		}
	}
}
