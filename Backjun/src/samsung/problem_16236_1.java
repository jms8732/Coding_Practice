package samsung;

//아기 상어
import java.util.*;
import java.io.*;

public class problem_16236_1 {
	static int map[][], N, sharkX, sharkY, shark_size = 2, time;
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				if (t == 9) {
					sharkX = i;
					sharkY = j;
				}
				map[i][j] = t;
			}
		}

		simulation();
	}

	private static void simulation() {

		int eat_count = 0;
		while (true) {
			boolean[][] visited = new boolean[N][N];
			fish eat = move_shark(visited);

			if (eat == null)
				break;

			eat_fish(eat);
			eat_count++;
			if (eat_count == shark_size) {
				shark_size++;
				eat_count = 0;
			}
			
		}
		System.out.println(time);
	}

	private static void eat_fish(fish e) {
		map[sharkX][sharkY] = 0;
		sharkX = e.x;
		sharkY = e.y;
		map[sharkX][sharkY] = 9;
	}

	private static fish move_shark(boolean[][] visited) {
		Queue<Point> q = new LinkedList<>();
		List<fish> f = new ArrayList<>();
		int[][] move = new int[N][N];

		q.add(new Point(sharkX, sharkY));

		visited[sharkX][sharkY] = true;
		
		while (!q.isEmpty()) {
			Point cur = q.poll(); 
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] > shark_size)
					continue;

				move[nx][ny] = move[cur.x][cur.y] + 1;
				visited[nx][ny]= true;
				if (map[nx][ny] >= 1 && map[nx][ny] <= 6) {
					if (map[nx][ny] < shark_size)
						f.add(new fish(nx, ny, move[nx][ny]));
				}
				q.add(new Point(nx, ny));
			}
		}
		

		Collections.sort(f, new Comparator<fish>() {

			@Override
			public int compare(fish o1, fish o2) {
				// TODO Auto-generated method stub
				if (o1.count < o2.count)
					return -1;
				else if (o1.count == o2.count) {
					if (o1.x < o2.x)
						return -1;
					else if (o1.x == o2.x) {
						if (o1.y < o2.y)
							return -1;
						else
							return 1;
					} else
						return 1;
				} else
					return 1;
			}

		});

		if (f.isEmpty())
			return null;

		time += move[f.get(0).x][f.get(0).y];
		return f.get(0);
	}

	private static void print(int[][] move) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(move[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static class fish {
		int x, y, count;

		public fish(int x, int y, int c) {
			this.count = c;
			this.x = x;
			this.y = y;
		}
	}
}
