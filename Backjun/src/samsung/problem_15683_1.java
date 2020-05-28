package samsung;

//°¨½Ã
import java.util.*;
import java.io.*;

public class problem_15683_1 {
	static List<Point> cctv;
	static int[][] map;
	static int[] dir = { 0, 1, 2, 3 };
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };
	static int N, M, answer= Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cctv = new ArrayList<>();
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				int t = Integer.parseInt(st.nextToken());

				if (t >= 1 && t <= 5) {
					cctv.add(new Point(i, j, t));
				}
				map[i][j] = t;
			}
		}
		
		int []val = new int[cctv.size()];
		
		simulation(0,val);
		System.out.println(answer);
	}

	private static void simulation(int depth, int[] val) {
		if (depth == val.length) {
			int[][] tmp = new int[N][M];
			copyArray(map, tmp);
			fill(val);
			
			int count = count();
			answer = Math.min(count, answer);
			
			copyArray(tmp,map);
			return;
			
		}

		for (int i = 0; i < 4; i++) {
			val[depth] = dir[i];
			simulation(depth + 1, val);
		}
	}

	private static void fill(int[] val) {
		for (int i = 0; i < val.length; i++) {
			int dir = val[i];
			Point cur = cctv.get(i);
			fill(dir, cur);
		}
	}
	
	private static void print() {
		for(int i= 0 ; i < N ; i++) {
			for(int j =0 ; j < M ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static int count() {
		int count =0;
		for(int i= 0 ; i < N ; i++) {
			for(int j =0 ; j < M ; j++) {
				if(map[i][j] == 0)
					count++;
			}
		}
		
		return count;
	}

	private static void fill(int dir, Point cur) {
		int count = cur.num;
		
		if(cur.num == 3)
			count = 2;
		
		if(cur.num == 4)
			count = 3;
		
		for (int i = 0; i < count; i++) {
			int cur_x = cur.x, cur_y = cur.y;
			if (cur.num == 2)
				dir = Math.floorMod(dir + 2 * i, 4);
			else
				dir = Math.floorMod(dir + i, 4);

			while (true) {
				int nx = cur_x + ud[dir];
				int ny = cur_y + rl[dir];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 6)
					break;

				map[nx][ny] = 8;
				cur_x = nx;
				cur_y= ny;
			}
		}
	}

	private static void copyArray(int[][] src, int[][] dest) {
		int idx = 0;
		for (int[] s : src)
			System.arraycopy(s, 0, dest[idx++], 0, s.length);
	}

	private static class Point {
		int x, y, num;

		public Point(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
}
