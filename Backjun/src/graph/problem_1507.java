package graph;

//±√±›«— πŒ»£
import java.util.*;
import java.io.*;

public class problem_1507 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				map[i][j] = t;
			}
		}

		floyd(N);

	}

	private static void floyd(int N) {
		int answer = 0;
		boolean[][] check = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (j == i || k == i || j==k)
						continue;

					if (map[j][k] > map[j][i] + map[i][k]) {
						System.out.println(-1);
						System.exit(0);
					}

					if (map[j][k] == map[j][i] + map[i][k]) {
						check[j][k] = true;
					}
				}
			}
		}

		//print(check, N);

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (!check[i][j]) {
					answer += map[i][j];
				}
			}
		}

		System.out.println(answer);
	}

	private static void print(boolean[][] check, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(check[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
