package others;

/*
 * 로봇 시뮬레이션
 * 가로와 세로 개념이 다르다는 점을 유의해서 문제를 접근한다.
 */
import java.util.*;
import java.io.*;

public class problem_2174 {
	static Map<Integer, Robot> factory;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		String[][] map = new String[b][a];
		factory = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = (b - 1) - (Integer.parseInt(st.nextToken()) - 1);

			map[y][x] = "R" + (i + 1);
			char dir = st.nextToken().charAt(0);

			factory.put(i, new Robot(y, x, dir));
		}

		boolean check = true;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			if (check) {
				int num = Integer.parseInt(st.nextToken()) - 1;
				char op = st.nextToken().charAt(0);
				int count = Integer.parseInt(st.nextToken());

				String ret = simulation(num, op, a, b, count, map);

				if (ret != null) {
					System.out.println(ret);
					check = false;
				}
			}
		}

		if (check)
			System.out.println("OK");

	}

	private static String simulation(int num, char op, int a, int b, int count, String[][] map) {
		for (int i = 0; i < count; i++) {
			String ret = rotation(num, op, a, b, map);

			if (ret != null) {
				return ret;
			}
		}
		return null;
	}

	private static String rotation(int num, char op, int a, int b, String[][] map) {
		Robot temp = factory.get(num); // 로봇을 가져옴
		char[] rotation = { 'N', 'E', 'S', 'W' };
		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };

		int start = 0;
		for (int i = 0; i < rotation.length; i++) {
			if (rotation[i] == temp.dir) {
				start = i;
				break;
			}
		}

		if (op == 'L' || op == 'R') {
			char next_dir = ' ';
			if (op == 'L')
				next_dir = rotation[Math.floorMod(start - 1, rotation.length)];
			else
				next_dir = rotation[Math.floorMod(start + 1, rotation.length)];

			temp.dir = next_dir; // 방향 조절
		} else {
			int nx = temp.x + ud[start];
			int ny = temp.y + rl[start];

			if (nx < 0 || nx >= b || ny < 0 || ny >= a)
				return "Robot " + (num + 1) + " crashes into the wall";

			if (map[nx][ny] != null) {
				String another = map[nx][ny].substring(1);
				return "Robot " + (num + 1) + " crashes into robot " + another;
			}

			String cur_robot = map[temp.x][temp.y];
			map[temp.x][temp.y] = null;
			map[nx][ny] = cur_robot;
			temp.x = nx;
			temp.y = ny;
		}

		return null;
	}

	private static class Robot {
		int x, y;
		char dir;

		public Robot(int x, int y, char d) {
			this.x = x;
			this.y = y;
			this.dir = d;
		}
	}
}
