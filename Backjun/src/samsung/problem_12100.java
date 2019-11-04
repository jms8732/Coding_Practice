package samsung;

import java.util.Scanner;

public class problem_12100 {
	static int[][] map;
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };
	static int N;
	static int result;
	static int big;
	static boolean visited[][];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = scanner.nextInt();
				map[i][j] = tmp;
			}
		} // map 채움
		dfs(0);
		System.out.println(big);
	}

	static void dfs(int count) {
		if (count  ==5) {
			count--;
			isBig();
			return;
		}
		int[][] ttmap = new int[N][N];
		for (int i = 0; i < rl.length; i++) {
			copyMap(ttmap, map);
			int nx = ud[i];
			int ny = rl[i];
		
			move3(nx,ny);
			move4(nx,ny);
			move3(nx,ny);
			//show();
			visited = new boolean[N][N];
			dfs(count + 1);
			copyMap(map, ttmap);
		}
	}

	static void move4(int ud, int rl) {
		if (ud == -1 && rl == 0) {
			for (int j =0  ; j < N ; j++) {
				for (int i = 0; i < N; i++) {
					if (map[i][j] != 0 && !visited[i][j])
						move(i, j, ud, rl);
				}
			}
		} else if (ud == 1 && rl == 0) {
			for (int j = N - 1; j >=  0 ; j--) {
				for (int i = N - 1; i >= 0; i--) {
					if (map[i][j] != 0 && !visited[i][j])
						move(i, j, ud, rl);
				}
			}
		} else if (ud == 0 && rl == 1) {
			for (int i = N -1 ; i >= 0 ; i--) {
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] != 0 && !visited[i][j])
						move(i, j, ud, rl);
				}
			}
		} else if (ud == 0 && rl == -1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0 && !visited[i][j])
						move(i, j, ud, rl);
				}
			}
		}
	}

	static void move3(int ud, int rl) {
		if (ud == -1 && rl == 0) {
			for (int j =0  ; j < N ; j++) {
				for (int i = 0; i < N; i++) {
					if (map[i][j] != 0)
						move2(i, j, ud, rl);
				}
			}
		} else if (ud == 1 && rl == 0) {
			for (int j = N - 1; j >=  0 ; j--) {
				for (int i = N - 1; i >= 0; i--) {
					if (map[i][j] != 0)
						move2(i, j, ud, rl);
				}
			}
		} else if (ud == 0 && rl == 1) {
			for (int i = N -1 ; i >= 0 ; i--) {
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] != 0)
						move2(i, j, ud, rl);
				}
			}
		} else if (ud == 0 && rl == -1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0)
						move2(i, j, ud, rl);
				}
			}
		}
	}

	static void show() {

		System.out.println();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static void move2(int x, int y, int ud, int rl) {
		int nx = 0;
		int ny = 0;
		int cx = x;
		int cy = y;
		int tmp = map[cx][cy];
		while (true) {
			nx = x + ud;
			ny = y + rl;
			if (nx < 0 || nx > map.length - 1 || ny < 0 || ny > map[nx].length - 1) {
				nx -= ud;
				ny -= rl;
				break;
			} else if (map[nx][ny] == 0) {
				x = nx;
				y = ny;
			} else {
				nx -= ud;
				ny -= rl;
				break;
			}
		}
		if (map[nx][ny] == 0) {
			map[cx][cy] = 0;
			map[nx][ny] = tmp;

		}
	}

	static void isBig() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				big = Math.max(big, map[i][j]);
			}
		}
	}

	static void move(int x, int y, int ud, int rl) {
		int cx = x;
		int cy = y;
		int tmp = map[cx][cy];
		int nx = 0, ny = 0;
		while (true) {
			nx = x + ud;
			ny = y + rl;
			if (nx < 0 || nx > map.length - 1 || ny < 0 || ny > map[nx].length - 1) {
				nx -= ud;
				ny -= rl;
				break;
			} else if (map[cx][cy] == map[nx][ny] || map[nx][ny] == 0) {
				x = nx;
				y = ny;
			} else {
				nx -= ud;
				ny -= rl;
				break;
			}
		}
		if ((cx != nx || cy != ny)  && !visited[nx][ny] && map[nx][ny] != 0) {
			map[cx][cy] = 0;
			map[nx][ny] += tmp;
			checkLine(cx, cy, nx, ny, ud, rl);
		}
		else if((cx != nx || cy != ny) && map[cx][cy] == map[nx][ny]){
			map[cx][cy] = 0;
			map[nx- ud][ny - rl] = tmp;
		}
		else {
			map[cx][cy] = 0;
			map[nx][ny] = tmp;
		}
	}

	static void checkLine(int cx, int cy, int nx, int ny, int ud, int rl) {
		int diffX = Math.abs(cx - nx);
		int diffY = Math.abs(cy - ny);

		if (diffX == 0) {
			// y값
			//visited[cx][cy] = true;
			visited[nx][ny] = true;
		} else {
			// x값
			//visited[cx][cy] = true;
			visited[nx][ny] = true;
		}
	}

	static void copyMap(int[][] des, int[][] src) {
		for (int i = 0; i < src.length; i++) {
			for (int j = 0; j < src[i].length; j++) {
				des[i][j] = src[i][j];
			}
		}
	}
}
