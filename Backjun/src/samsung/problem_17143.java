package samsung;

//낚시왕
import java.util.*;
import java.io.*;

public class problem_17143 {
	static int R, C, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		shark[][] map = new shark[R][C];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			map[r][c] = new shark(s, d, z);
		}

		simulation(map);
	}

	private static void simulation(shark[][] map) {
		int totalSize = 0;
		// 낚시왕이 오른쪽으로 한 칸씩 이동한다.
		for (int i = 0; i < C; i++) {
			shark tmp = catchShark(i, map);
			if (tmp != null)
				totalSize += tmp.size;

			moveShark(map);

		}

		System.out.println(totalSize);
	}

	private static void moveShark(shark[][] map) {
		shark[][] afterMap = new shark[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != null) {
					moving(afterMap, map[i][j], i, j);
					map[i][j] = null;
				}
			}
		}

		copyArray(afterMap, map);
		
	}

	private static void copyArray(shark[][] src, shark[][] dest) {
		int idx = 0;
		for (shark[] tmp : src) {
			System.arraycopy(tmp, 0, dest[idx++], 0, tmp.length);
		}
	}
	
	private static void print(shark[][] map) {
		for(int i =0 ; i < R ; i++) {
			for(int j =0 ; j < C ; j++) {
				if(map[i][j] == null)
					System.out.print(" " );
				else
					System.out.println(map[i][j].size+ " ");
			}
			System.out.println();
		}
	}

	private static void moving(shark[][] afterMap, shark cur, int x, int y) {
		int dir = cur.dir;
		int speed =0 ;
		if(dir == 1 || dir == 2)
			speed = cur.speed % (2*R-2);
		else
			speed = cur.speed % (2*C-2);
		int size = cur.size;


		while (speed != 0) {
			int nx = x, ny = y;
			switch (dir) {
			case 1:
				nx -= 1;
				break;
			case 2:
				nx += 1;
				break;
			case 3:
				ny += 1;
				break;
			case 4:
				ny -= 1;
				break;
			}

			// 배열범위 밖으로 벗어나는 경우
			if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
				if (dir == 1)
					dir = 2;
				else if (dir == 2)
					dir = 1;
				else if (dir == 3)
					dir = 4;
				else
					dir = 3;
			} else {
				x = nx;
				y = ny;
				speed--;
			}
		}
		
		// 다른 상어가 존재하면
		if (afterMap[x][y] != null) {
			shark tmp = afterMap[x][y];
			if (tmp.size < cur.size)
				afterMap[x][y] = new shark(cur.speed, dir, size);
		} else
			afterMap[x][y] = new shark(cur.speed, dir, size);
	}

	private static shark catchShark(int idx, shark[][] map) {
		shark tmp = null;
		for (int i = 0; i < map.length; i++) {
			if (map[i][idx] != null) {
				tmp = map[i][idx];
				map[i][idx] = null;
				break;
			}
		}

		return tmp;
	}

	private static class shark {
		int speed, dir, size;

		public shark(int s, int d, int z) {
			this.size = z;
			this.speed = s;
			this.dir = d;
		}
	}
}
