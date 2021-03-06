package graph;

//�丶��
import java.util.*;
import java.io.*;

public class problem_7576 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[M][N];
		boolean[][] visited = new boolean[M][N];

		Queue<List<Integer>> queue = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					List<Integer> coord = new ArrayList<>();
					coord.add(i);
					coord.add(j);
					queue.add(coord);
					visited[i][j] = true;
				}
			}
		}
		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };
		int count = 0;
		while (true) {
			Queue<List<Integer>> tmpQ = new LinkedList<>();
			while (!queue.isEmpty()) {
				List<Integer> cur = queue.poll();
				int curX = cur.get(0);
				int curY = cur.get(1);

				for (int i = 0; i < 4; i++) {
					int nx = curX + ud[i];
					int ny = curY + rl[i];

					if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny])
						continue;

					if (map[nx][ny] == -1 || map[nx][ny] == 1)
						continue;

					List<Integer> coord = new ArrayList<>();
					visited[nx][ny] = true;
					map[nx][ny] = 1;

					coord.add(nx);
					coord.add(ny);
					tmpQ.add(coord);
				}
			}
			if (tmpQ.isEmpty())
				break;

			count++;
			queue = new LinkedList<>(tmpQ);
		}
		if (isFinish(map)) {
			System.out.println(count);
		} else
			System.out.println(-1);
	}

	private static boolean isFinish(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}

		return true;
	}
}
