package others;

//·Îº¿ ½Ã¹Ä·¹ÀÌ¼Ç
import java.util.*;
import java.io.*;

public class problem_2174 {
	static List<robot> list;
	static int A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int k = 0; k < tc; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				char dir = st.nextToken().charAt(0);
				String name = String.valueOf(i + 1);

				list.add(new robot(x, y, dir, name));
			}

			boolean check = false;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int number = Integer.parseInt(st.nextToken()) - 1;
				char op = st.nextToken().charAt(0);
				int count = Integer.parseInt(st.nextToken());

				if (!check) {
					for (int j = 0; j < count; j++) {
						if (!simulation(list.get(number), number + 1, op)) {
							check = true;
							break;
						}
					}
				}

			}
			if (!check)
				System.out.println("OK");
		}
	}

	private static boolean simulation(robot rb, int number, char op) {
		boolean check = false;
		if (op == 'F') {
			if (!move(rb, number))
				return false;
		} else {
			if (op == 'R')
				check = true;

			rotation(rb, check);
		}

		return true;
	}

	private static void rotation(robot rb, boolean check) {

		// R
		if (check) {
			switch (rb.dir) {
			case 'N':
				rb.dir = 'E';
				break;
			case 'E':
				rb.dir = 'S';
				break;
			case 'S':
				rb.dir = 'W';
				break;
			case 'W':
				rb.dir = 'N';
				break;
			}
		} else { // L
			switch (rb.dir) {
			case 'N':
				rb.dir = 'W';
				break;
			case 'E':
				rb.dir = 'N';
				break;
			case 'S':
				rb.dir = 'E';
				break;
			case 'W':
				rb.dir = 'S';
				break;
			}
		}
	}

	private static boolean move(robot rb, int number) {
		int nx = rb.x, ny = rb.y;
		switch (rb.dir) {
		case 'N':
			ny += 1;
			break;
		case 'E':
			nx += 1;
			break;
		case 'S':
			ny -= 1;
			break;
		case 'W':
			nx -= 1;
			break;
		}

		if (nx < 1 || nx > A || ny < 1 || ny > B) {
			System.out.println("Robot " + number + " crashes into the wall");
			return false;
		}

		if (checkCrash_robot(number, nx, ny)) {
			return false;
		}

		rb.x = nx;
		rb.y = ny;

		return true;

	}

	private static boolean checkCrash_robot(int number, int x, int y) {
		for (int i = 0; i < list.size(); i++) {
			if ((number - 1) != i && x == list.get(i).x && y == list.get(i).y) {
				System.out.println("Robot " + list.get(number - 1).name + " crashes into robot " + list.get(i).name);
				return true;
			}
		}

		return false;
	}

	private static class robot {
		int x, y;
		char dir;
		String name;

		public robot(int x, int y, char d, String n) {
			this.x = x;
			this.y = y;
			this.dir = d;
			this.name = n;
		}
	}
}
