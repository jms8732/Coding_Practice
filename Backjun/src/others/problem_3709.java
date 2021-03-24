package others;

/*
 * ������ ���� ����
 * �������� ���� ��, �迭�� ũ�⸦ ��� �� ���� +2�� �Ͽ� �������Ѿ��Ѵ�.
 * �������� ���⿡ ���� ���������� 90�� ȸ����Ű�� ��
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

				board[x][y] = 1; // �ſ�
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
				// �������� �������� ��� ���
				System.out.println(nx + " " + ny);
				break;
			}

			if (board[nx][ny] == 1) {
				// �ſ��� ������ ���
				cd = (cd + 1) % 4; // �������� 90�� ȸ��
			}

			// ���� ��ǥ�� ������ �̵�
			rx = nx;
			ry = ny;
		}
	}

}
