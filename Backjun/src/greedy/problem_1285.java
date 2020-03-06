package greedy;

//동전 뒤집기
import java.util.*;
import java.io.*;

public class problem_1285 {
	static char[][] map;
	static boolean[] col, row;
	static int N;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		row = new boolean[N];
		col = new boolean[N];

		int count = 0;
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				if (tmp.charAt(j) == 'T')
					count++;
				map[i][j] = tmp.charAt(j);
			}
		}

		// 초기 값
		answer = count;
		simulation(0, count);
		System.out.println(answer);
	}

	private static void simulation(int cur, int count) {
		if (cur == N * N) {
			answer = Math.min(count, answer);
			return;
		}

		for (int i = cur; i < N * N; i++) {
			int x = i / N;
			int y = i % N;

			int rowCount = count, colCount = count;

			
		}

	}

}
