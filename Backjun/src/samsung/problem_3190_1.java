package samsung;

//뱀
import java.util.*;
import java.io.*;

public class problem_3190_1 {
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()) +1;

		int[][] map = new int[N][N];

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x][y] = 1;
		}

		K = Integer.parseInt(br.readLine());

		Queue<OP> q = new LinkedList<>();
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char op = st.nextToken().charAt(0);

			q.add(new OP(op, t));
		}

		simulation(q, map, N);
	}

	private static void simulation(Queue<OP> q, int[][] map, int N) {
		int time = 0;

		List<Point> snake = new ArrayList<>();
		snake.add(new Point(1, 1));

		map[1][1] = 2;

		int dir = 1;

		while (true) {
			if (!q.isEmpty() && q.peek().time == time) {
				int tmp = 0;
				if (q.peek().op == 'D')
					tmp = 1;
				else
					tmp = -1;

				dir = Math.floorMod(dir + tmp, 4);
				q.poll();

			}

			time++;
			if (movehead(snake, map, dir,N)) {
				System.out.println(time);
				break;
			}
			//print(map,N);
		}
	}
	
	private static void print(int [][] map, int N) {
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < N;  j++) {
				System.out.print(map[i][j] + " " );
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean movehead(List<Point> snake, int[][] map, int dir, int N) {
		Point head = snake.get(0);

		int cur_x = head.x + ud[dir];
		int cur_y = head.y + rl[dir];

		if (cur_x == 0 || cur_x >= N || cur_y == 0 || cur_y >= N) {
			return true;
		}
		
		if(map[cur_x][cur_y] == 2)
			return true;

		// 사과가 존재한다면
		if (map[cur_x][cur_y] == 1) {
			map[cur_x][cur_y] = 2;
			snake.add(0, new Point(cur_x, cur_y));
		} else {

			for (Point cur : snake) {
				int tmpX = cur.x;
				int tmpY = cur.y;
				
				cur.x = cur_x;
				cur.y = cur_y;

				map[cur.x][cur.y] = 2;
				map[tmpX][tmpY] = 0;
				
				cur_x = tmpX;
				cur_y = tmpY;
			}
		}

		return false;
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static class OP {
		char op;
		int time;

		public OP(char op, int t) {
			this.op = op;
			this.time = t;
		}
	}
}
