package samsung_Atype;

//다리 만들기 2
import java.util.*;
import java.io.*;

public class problem_17472 {
	static int island_num = 0;
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };
	static int N, M;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		find_island_num(map);
		PriorityQueue<bridge> pq = new PriorityQueue<>(new Comparator<bridge>() {

			@Override
			public int compare(bridge arg0, bridge arg1) {
				// TODO Auto-generated method stub
				if (arg0.w < arg1.w)
					return -1;
				else
					return 1;
			}

		});
		build_bridge(pq, map);
	}

	private static void build_bridge(PriorityQueue<bridge> pq, int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					build(pq, i, j, map, map[i][j]);
				}
			}
		}

		int[] parent = new int[island_num - 1];
		for (int i = 0; i < island_num - 1; i++) {
			parent[i] = i;
		}

		int answer = 0;
		while (!pq.isEmpty()) {
			bridge cur = pq.poll();

			if (union_find(cur, parent)) {
				answer += cur.w;
			}
		}
		
		for(int i = 0 ; i < parent.length ; i++) {
			parent[i] = find(parent[i],parent);
			
			if(parent[i] != 0) {
				answer = -1;
				break;
			}
		}

		System.out.println(answer);
	}

	private static boolean union_find(bridge b, int[] parent) {
		int v1 = find(b.s, parent);
		int v2 = find(b.e, parent);

		if (v1 == v2)
			return false;

		if (v1 < v2) {
			parent[v2] = v1;
		} else
			parent[v1] = v2;

		return true;
	}

	private static int find(int v1, int[] parent) {
		if (v1 == parent[v1])
			return v1;
		else
			return parent[v1] = find(parent[v1], parent);
	}

	private static void build(PriorityQueue<bridge> pq, int x, int y, int[][] map, int num) {
		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int count = 0;
			int startx = x;
			int starty = y;
			while (true) {
				int nx = startx + ud[i];
				int ny = starty + rl[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] != 0) {
					if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 0) {
						startx = nx;
						starty = ny;
					}
					break;
				}
				visited[nx][ny] = true;

				startx = nx;
				starty = ny;
				count++;
			}

			if (count >= 2 && map[startx][starty] != 0 && map[startx][starty] != num) {
				pq.add(new bridge(num - 1, map[startx][starty] - 1, count));
			}
		}
	}

	private static void find_island_num(int[][] map) {
		boolean[][] visited = new boolean[N][M];
		int number = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					Queue<Point> q = new LinkedList<>();
					q.add(new Point(i, j));
					map[i][j] = number;
					while (!q.isEmpty()) {
						Point cur = q.poll();

						visited[cur.x][cur.y] = true;
						for (int k = 0; k < 4; k++) {
							int nx = cur.x + ud[k];
							int ny = cur.y + rl[k];

							if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == 0)
								continue;

							visited[nx][ny] = true;
							map[nx][ny] = number;
							q.add(new Point(nx, ny));
						}
					}

					number++;
				}
			}
		}
		island_num = number;
	}

	private static class bridge {
		int s, e, w;

		public bridge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
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
