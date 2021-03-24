package others;

/*
 * 레이저 빔은 어디로
 * 보드판을 받을 때, 배열의 크기를 행과 열 각각 +2를 하여 생성시켜야한다.
 * 레이저의 방향에 따라 오른쪽으로 90도 회전시키는 것
 */
import java.util.*;
import java.io.*;

public class problem_3709 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int l = 0; l < tc; l++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[][] board = new int[n + 2][n + 2];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				board[x][y] = 1; // 거울
			}
			st = new StringTokenizer(br.readLine());
			int raser_x = Integer.parseInt(st.nextToken());
			int raser_y = Integer.parseInt(st.nextToken());

			simulation(raser_x, raser_y, board, n);
		}
		br.close();
	}

	private static void simulation(int rx, int ry, int[][] board, int n) {
		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };
		int cd = 0;

		if (rx == 0 || rx == n+1) {
			if (rx == 0)
				cd = 2;
			else
				cd = 0;
		} else {
			if (ry == 0)
				cd = 1;
			else
				cd = 3;
		}

		while (true) {
			int nx = rx + ud[cd];
			int ny = ry + rl[cd];

			if (nx <= 0 || nx >= n + 1 || ny <= 0 || ny >= n + 1) {
				// 레이저가 보드판을 벗어난 경우
				System.out.println(nx + " " + ny);
				break;
			}

			if (board[nx][ny] == 1) {
				// 거울이 존재한 경우
				cd = (cd + 1) % 4; // 우측으로 90도 회전
			}

			// 다음 좌표로 레이저 이동
			rx = nx;
			ry = ny;
		}
	}

}
