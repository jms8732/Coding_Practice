package samsung;

import java.util.*;
import java.io.*;

public class problem_16236 {
	static int sharkX, sharkY, sharkSize;
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		sharkX = 0;
		sharkY = 0;
		sharkSize = 2;

		// ��� �� �ʱ�ȭ
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 9) {
					sharkX = i;
					sharkY = j;
				}
				map[i][j] = tmp;
			}
		}

		simulation(map);
	}

	private static void simulation(int[][] map) {
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {

			// �Ÿ��� ����� ����Ⱑ ���ٸ� ���� ���� �ִ� �����, �׷��� ����Ⱑ �����Ӹ����, ���� ���ʿ� �ִ� �����
			@Override
			public int compare(Point arg0, Point arg1) {
				// TODO Auto-generated method stub
				if (arg0.count < arg1.count) {
					return -1;
				} else if (arg0.count == arg1.count) {
					if (arg0.x < arg1.x)
						return -1;
					else if (arg0.x == arg1.x) {
						if (arg0.y < arg1.y)
							return -1;
						else
							return 1;

					} else
						return 1;
				} else
					return 1;
			}
		});

		int timer = 0;
		int eatCount = 0;
		boolean visited[][] = null;
		
		while (true) {
			visited = new boolean[N][N];
			searchFish(map, visited, sharkX, sharkY, pq);

			// �� �̻� ���� ����Ⱑ ���� ���
			if (pq.isEmpty())
				break;

			// ���� ��� ��ġ�� 0���� �ٲ�
			map[sharkX][sharkY] = 0;
			Point cur = pq.poll();

			sharkX = cur.x;
			sharkY = cur.y;
			timer += cur.count;

			map[sharkX][sharkY] = 9;
			eatCount += 1;

			// ����⸦ ������ŭ ������ ����
			if (eatCount % sharkSize == 0) {
				sharkSize += 1;
				eatCount=0;
			}

			pq.clear();
		}
		System.out.println(timer);
	}

	private static void searchFish(int[][] map, boolean[][] visited, int x, int y, PriorityQueue<Point> pq) {
		Queue<Point> shark = new LinkedList<>();
		
		visited[x][y] = true;
		shark.add(new Point(x,y,1));
		
		while (!shark.isEmpty()) {
			Point cur = shark.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N)
					continue;

				if (!visited[nx][ny] && map[nx][ny] <= sharkSize) {
					visited[nx][ny] = true;
					if (map[nx][ny] == 0 || map[nx][ny] == sharkSize) {
						shark.add(new Point(nx,ny,cur.count+1));
					} else {
						// �� �Դ´�
						pq.add(new Point(nx, ny,cur.count));
					}
				}
			}
		}
	}

	// ��ǥ�� �����ϴ� Ŭ����
	private static class Point {
		int x, y, count;

		public Point(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.count = c;
		}
	}
}
