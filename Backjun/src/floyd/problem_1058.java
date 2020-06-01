package floyd;

//Ä£±¸
import java.util.*;
import java.io.*;

public class problem_1058 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				if (tmp.charAt(j) == 'N')
					map[i][j] = 0;
				else
					map[i][j] = 1;
			}
		}
		floyd(map, N);
		//print(map, N);
	}

	private static void print(int[][] map, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void floyd(int[][] map, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (i == j || j == k || k == i)
						continue;

					if (map[j][k] == 0) {
						if(map[j][i] !=0 && map[i][k] != 0 && map[j][i] + map[i][k] <= 2)
							map[j][k] = map[j][i] + map[i][k];
						
					}
				}
			}
		}

		int answer = 0;
		for (int m[] : map) {
			int count = 0;
			for (int i = 0; i < m.length; i++) {
				if (m[i] != 0)
					count++;
			}
			answer = Math.max(count, answer);
		}
		System.out.println(answer);
	}
}
