package samsung;

//청소년 상어
import java.util.*;
import java.io.*;

public class problem_19236 {
	static int[] ud = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] rl = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;

		fish[][] fishes = new fish[4][4];

		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken()) - 1;
				fishes[i][j] = new fish(n, d);
			}
		}

		backtracking(fishes, 0, 0, 0);
		System.out.println(answer);
	}

	private static void backtracking(fish[][] fishes, int sharkX, int sharkY, int sum) {
		// 상어가 현재 위치의 물고기를 먹는다.
		sum += fishes[sharkX][sharkY].number;
		fishes[sharkX][sharkY].number = 0;

		// 물고기가 이동한다.
		move_fish(fishes, sharkX, sharkY);

		fish[][] temp = new fish[4][4];
		copyArray(fishes, temp);

		// 현재 상어의 방향
		int dir = fishes[sharkX][sharkY].dir;
		int nx = sharkX + ud[dir];
		int ny = sharkY + rl[dir];

		while (true) {
			// 방향으로 이동하는데 배열 범위 밖이거나 물고기가 없는 경우 이동 불가능
			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
				answer = Math.max(answer, sum);
				break;
			}

			if (fishes[nx][ny].number == 0) {
				nx += ud[dir];
				ny += rl[dir];
				continue;
			}

			backtracking(fishes, nx, ny, sum);
			copyArray(temp, fishes);
			nx += ud[dir];
			ny += rl[dir];
		}
	}

	private static void print(fish[][] fishes) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(fishes[i][j].number + " " + fishes[i][j].dir + "| ");
			}
			System.out.println();
		}

		System.out.println();
	}

	private static void move_fish(fish[][] fishes, int sharkX, int sharkY) {
		for (int k = 1; k <= 16; k++) {
			outter: for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (fishes[i][j].number == k) {
						move(i, j, fishes, sharkX, sharkY);
						break outter;
					}
				}
			}
		}
	}

	private static void move(int x, int y, fish[][] fishes, int sharkX, int sharkY) {
		int dir = fishes[x][y].dir;
		while (true) {
			int nx = x + ud[dir];
			int ny = y + rl[dir];

			if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || (sharkX == nx && sharkY == ny)) {
				dir = (dir + 1) % ud.length;
				continue;
			}

			fishes[x][y].dir = dir;
			swap(fishes[x][y], fishes[nx][ny]);
			break;
		}
	}

	private static void swap(fish f1, fish f2) {
		int f1_n = f1.number;
		int f1_d = f1.dir;

		f1.number = f2.number;
		f1.dir = f2.dir;

		f2.number = f1_n;
		f2.dir = f1_d;

	}

	private static void copyArray(fish[][] src, fish[][] dest) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				dest[i][j] = new fish(src[i][j].number, src[i][j].dir);
			}
		}
	}

	private static class fish {
		int number;
		int dir;

		public fish(int n, int d) {
			this.number = n;
			this.dir = d;
		}
	}
}
