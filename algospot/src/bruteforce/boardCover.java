package bruteforce;

//게임판 덮기
import java.util.*;
import java.io.*;

public class boardCover {
	static int[][][] shape = { { { 0, 0 }, { 0, 1 }, { 1, 1 } }, { { 0, 0 }, { 1, 0 }, { 1, -1 } },
			{ { 0, 0 }, { 1, 0 }, { 0, 1 } }, { { 0, 0 }, { 1, 0 }, { 1, 1 } } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int k = 0; k < tc; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			char[][] map = new char[H][W];
			int whiteCount = 0;
			// 입력 값으로 주어진 맵 초기화
			for (int i = 0; i < H; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < W; j++) {
					if (tmp.charAt(j) == '.')
						whiteCount++;
					map[i][j] = tmp.charAt(j);
				}
			}

			if (whiteCount % 3 == 0)
				System.out.println(find(map, H, W));
			else
				System.out.println(0);
		}
	}

	private static void print(char[][] map, int H, int W) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

		System.out.println();
	}

	private static int find(char[][] map, int H, int W) {
		int x = -1, y = -1;

		outter: for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				// 아직 흰색이 존재하는 좌표를 찾는다.
				if (map[i][j] == '.') {
					x = i;
					y = j;
					break outter;
				}
			}
		}

		// 다 찾은 경우 1을 반환한다.
		if (x == -1 && y == -1)
			return 1;

		int count = 0;

		for (int i = 0; i < 4; i++) {
			if (put(map, H, W, x, y, i)) {
				count += find(map, H, W);
				pop(map, H, W, x, y, i);
			}

		}
		return count;
	}

	private static void pop(char[][] map, int H, int W, int x, int y, int k) {
		int x1 = x + shape[k][1][0];
		int y1 = y + shape[k][1][1];

		int x2 = x + shape[k][2][0];
		int y2 = y + shape[k][2][1];

		x += shape[k][0][0];
		y += shape[k][0][1];

		map[x][y] = '.';
		map[x1][y1] = '.';
		map[x2][y2] = '.';
	}

	private static boolean put(char[][] map, int H, int W, int x, int y, int k) {
		int x1 = x + shape[k][1][0];
		int y1 = y + shape[k][1][1];

		int x2 = x + shape[k][2][0];
		int y2 = y + shape[k][2][1];

		x += shape[k][0][0];
		y += shape[k][0][1];

		// 범위에 존재하지 않은 경우
		if (x < 0 || x >= H || x1 < 0 || x1 >= H || x2 < 0 || x2 >= H || y < 0 || y >= W || y1 < 0 || y1 >= W || y1 < 0
				|| y1 >= W)
			return false;
		
		//해당 좌표에 검은색이 존재하는 경우
		if(map[x][y] == '#' || map[x1][y1] == '#' || map[x2][y2] == '#')
			return false;

		map[x][y] = '#';
		map[x1][y1] = '#';
		map[x2][y2] = '#';

		return true;
	}
}
