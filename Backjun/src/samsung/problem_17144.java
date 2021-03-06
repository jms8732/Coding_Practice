package samsung;

//미세먼지 안녕!
import java.util.*;
import java.io.*;

public class problem_17144 {
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == -1) // 공기 청정기의 좌표
				{
					List<Integer> tmpList = new ArrayList<>();
					tmpList.add(i);
					tmpList.add(j);
					list.add(tmpList);
				}
				map[i][j] = tmp;
			}
		}

		for (int i = 0; i < T; i++) {
			expand(map); // 먼지 확산
			clearAir(map, list);
		}
		int result = sumDust(map);
		System.out.println(result);
	}
	
	private static void print(int[][] map) {
		for(int i =0 ; i < R; i++) {
			for(int j = 0 ; j< C ; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}

	private static void clearAir(int[][] map, List<List<Integer>> list) {
		boolean check = false;
		for (int i = 0; i < list.size(); i++) {
			List<Integer> tmp = list.get(i); // 공기청정기의 좌표
			int x = tmp.get(0);
			int y = tmp.get(1);
			
			if(!check) {
				reverseRotation(x,y,map);
				check = !check;
			}
			else
				rotation(x,y,map);
			
		}
	}

	private static void reverseRotation(int x, int y, int[][] map) {
		int airX = x;
		int airY= y;
		// up to down
		while (true) {
			x -= 1;
			int px = x + 1;

			if (x < 0) {
				x += 1;
				break;
			}
			map[px][y] = map[x][y];
		}

		// left to right
		while (true) {
			y = y + 1;
			int py = y - 1;

			if (y >= C) {
				y -= 1;
				break;
			}

			map[x][py] = map[x][y];
		}

		// down to up
		while (true) {
			x = x + 1;
			int px = x - 1;
			if (x > airX) {
				x -= 1;
				break;
			}
			map[px][y] = map[x][y];
		}

		// right to left
		while (true) {
			y -= 1;
			int py = y + 1;
			if (y < 0) {
				y += 1;
				break;
			}
			map[x][py] = map[x][y];
		}
		map[x][y] = -1; // 청소기 있는 부분
		map[x][y + 1] = 0; // 청소기 바로 다음 부분
	}
	private static int sumDust(int[][] map) {
		int sum = 0;
		for(int i =0 ; i< R ; i++){
			for(int j =0 ; j< C ; j++) {
				if(map[i][j] != -1)
					sum += map[i][j];
			}
		}
		
		return sum;
	}

	private static void rotation(int x, int y, int[][] map) {
		int airX = x;
		int airY= y;
		
		// down to up
		while (true) {
			x = x + 1;
			int px = x - 1;
			if (x >= R) {
				x -= 1;
				break;
			}
			map[px][y] = map[x][y];
		}

		// left to right
		while (true) {
			y = y + 1;
			int py = y - 1;

			if (y >= C) {
				y -= 1;
				break;
			}

			map[x][py] = map[x][y];
		}

		// up to down
		while (true) {
			x -= 1;
			int px = x + 1;

			if (x < airX) {
				x += 1;
				break;
			}
			map[px][y] = map[x][y];
		}

		// right to left
		while (true) {
			y -= 1;
			int py = y + 1;
			if (y < 0) {
				y += 1;
				break;
			}
			map[x][py] = map[x][y];
		}

		map[x][y] = -1; // 청소기 있는 부분
		map[x][y + 1] = 0; // 청소기 바로 다음 부분
	}

	private static void expand(int[][] map) {
		int[][] tmpMap = new int[R][C]; // 동시에 확장이 이뤄지기 때문에
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0) {
					if(map[i][j] == -1)
						tmpMap[i][j] =-1;
					else
						expandDust(i, j, tmpMap, map);
				}
			}
		}
		copyMap(tmpMap, map); // 확산된 먼지의 내용을 map에 저장
	}

	private static void expandDust(int x, int y, int[][] tmpMap, int[][] map) {
		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };
		int count = 0;

		for (int i = 0; i < 4; i++) { // 확산 방향 개수
			int nx = x + ud[i];
			int ny = y + rl[i];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == -1)
				continue;

			tmpMap[nx][ny] += map[x][y] / 5; // 확산된 미세먼지의 양
			count++;
		}
		tmpMap[x][y] += map[x][y] - (map[x][y] / 5) * count; // 남은 미세먼지의 양

	}

	private static void copyMap(int[][] src, int[][] dest) {
		int idx = 0;
		for(int tmp[] : src) {
			System.arraycopy(tmp, 0, dest[idx], 0, tmp.length);
			idx++;
		}
	}

}
