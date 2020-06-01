package others;

//나이트 투어
import java.util.*;
import java.io.*;

public class problem_1331 {
	static int ud[] = { -2, -2, 2, 2, -1, -1, 1, 1 };
	static int rl[] = { -1, 1, -1, 1, 2, -2, 2, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[][] visited = new boolean[6][6];
		String line = br.readLine();
		int col = line.charAt(0) - 'A';
		int row = line.charAt(1) - '1';

		int s_col = col;
		int s_row = row;
		int count = 0;

		for (int i = 0; i < 35; i++) {
			String next = br.readLine();

			int n_col = next.charAt(0) - 'A';
			int n_row = next.charAt(1) - '1';

			boolean c = false;

			for (int j = 0; j < 8; j++) {
				int nx = col + ud[j];
				int ny = row + rl[j];

				if (nx < 0 || nx >= 6 || ny < 0 || ny >= 6 || visited[nx][ny])
					continue;

				if (nx == n_col && ny == n_row) {
					count++;
					visited[nx][ny] = true;
					c = true;
					col = n_col;
					row = n_row;
					break;
				}

			}

			if (!c) {
				System.out.println("Invalid");
				System.exit(0);
			}
		}

		for (int j = 0; j < 8; j++) {
			int nx = col + ud[j];
			int ny = row + rl[j];
			
			if(nx < 0 || nx >= 6 || ny < 0 || ny >= 6 || visited[nx][ny])
				continue;
			
			if (nx == s_col && ny == s_row) {
				count++;

				if (count == 36) {
					System.out.println("Valid");
					System.exit(0);
				}
			}
		}

		System.out.println("Invalid");

	}

	private static void print(boolean[][] c) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
}
