package samsung;

import java.util.*;

public class problem_3190 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };
	static final int Apple = 3;
	static final int Snake = 4;
	static int[][] map;
	static Vector<Snake> snake;
	static int N;
	static Vector<direction> direction;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		map = new int[N + 1][N + 1];
		snake = new Vector<>();
		direction = new Vector<>();
		int appleCount = scanner.nextInt();
		map[1][1] = Snake;
		for (int i = 0; i < appleCount; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			map[x][y] = Apple;
		}
		int directionCount = scanner.nextInt();
		for (int i = 0; i < directionCount; i++) {
			int count = scanner.nextInt();
			String d = scanner.nextLine().trim();
			direction dd = new direction(count, d);
			direction.add(dd);
		}
		Snake s = new Snake(1, 1);
		snake.add(s);
		int count = 0;
		int result = start(ud[1], rl[1], count);
		System.out.println(result);
	}

	static int start(int dx, int dy, int count) {
		direction dTmp = direction.get(0);
		direction.remove(0);
		int c = dTmp.count;
		String d = dTmp.direction;
		while (true) {
			count++;
			Snake sTmp = snake.get(0);
			int cx = sTmp.x;
			int cy = sTmp.y;
			int nx = cx + dx;
			int ny = cy + dy;
			if (nx < 1 || nx > N || ny < 1 || ny > N) {
				// 벽에 부딪힐 때
				return count;
			} else if (map[nx][ny] == Snake) {
				return count;
			} else {
				Snake st = new Snake(nx,ny);
				snake.add(0,st); //머리 추가
				if(map[nx][ny] != Apple) {
					//사과가 없을 경우
					int xtmp = snake.get(snake.size()-1).x;
					int ytmp = snake.get(snake.size()-1).y;
					map[xtmp][ytmp] = 0;
					snake.remove(snake.size()-1);
				}
				map[nx][ny] = Snake;
			}
			System.out.println("***count*** : " + count);
			show();
		
			if (count == c) {
				int idx = changeDirection(dx, dy, d);
				dx = ud[idx];
				dy = rl[idx];
				if (!direction.isEmpty()) {
					dTmp = direction.get(0);
					direction.remove(0);
					c = dTmp.count;
					d = dTmp.direction;
				}
			}
		}
	}

	static void show() {
		System.out.println();
		for (int tmp[] : map) {
			for (int i = 0; i < tmp.length; i++) {
				System.out.print(tmp[i] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static int changeDirection(int dx, int dy, String rotation) {
		if (dx == 0 && dy == -1) {
			// left
			if (rotation.equals("L")) {
				return 2;
			} else {
				return 0;
			}
		} else if (dx == -1 && dy == 0) {
			// up
			if (rotation.equals("L")) {
				return 3;
			} else {
				return 1;
			}

		} else if (dx == 0 && dy == 1) {
			// right
			if (rotation.equals("L")) {
				return 0;
			} else {
				return 2;
			}
		} else if (dx == 1 && dy == 0) {
			// down
			if (rotation.equals("L")) {
				return 1;
			} else {
				return 3;
			}
		}
		return -1;
	}
}

class Snake {
	int x;
	int y;

	public Snake(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class direction {
	int count;
	String direction;

	public direction(int x, String c) {
		this.count = x;
		this.direction = c;
	}
}