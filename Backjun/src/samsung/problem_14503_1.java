package samsung;

//로봇 청소기
import java.util.*;
import java.io.*;

public class problem_14503_1 {
	static int map[][], startX, startY, dir;
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());

		dir = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simulation(N, M);
	}

	private static void simulation(int N, int M) {
		boolean[][] clean = new boolean[N][M];
		int count = 0;
		while (true) {
			// 1. 현재 위치를 청소한다
			map[startX][startY] = 0;
			clean[startX][startY] = true;
			count++;

			//print(N, M);
			// 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색
			int start = dir;
			boolean clear = false;

			while (true) {
				for (int i = 1; i <= 4; i++) {
					if (isClear(start - i, N, M, clean)) {
						clear = true;
						break;
					}
				}

				if (!clear) {
					// 3. 바라보는 방향을 유지한채로 한칸 후진한 후, 2번으로 돌아간다.
					int nx = startX - ud[dir];
					int ny = startY - rl[dir];

					// 4. 뒤쪽 방향이 벽이라 후진 안되면 종료
					if (map[nx][ny] == 1) {
						System.out.println(count);
						System.exit(0);
					}

					startX = nx;
					startY = ny;
				}
				
				if(clear)
					break;
			}
		}

	}

	private static void print(int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i == startX && j == startY) {
					System.out.print(2 + " ");
				} else
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean isClear(int d, int N, int M, boolean[][] clean) {
		d = Math.floorMod(d, 4);
		int nx = startX + ud[d];
		int ny = startY + rl[d];

		dir = d; // 그 방향으로 회전

		if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == 1 || clean[nx][ny])
			return false;

		startX = nx;
		startY = ny;

		return true;
	}
}
