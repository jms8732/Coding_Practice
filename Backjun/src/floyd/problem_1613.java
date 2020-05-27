package floyd;

//¿ª»ç
import java.util.*;
import java.io.*;

public class problem_1613 {
	static int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] array = new int[N][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;

			array[s][e] = -1;
			array[e][s] = 1;
		}

		floyd(array, N);
		print(array,N);
		int S = Integer.parseInt(br.readLine());

		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			
			System.out.println(array[s][e]);
		}
	}

	private static void print(int[][] array, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void floyd(int[][] array, int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(array[j][k] == 0 ) {
						if(array[j][i] == 1 && array[i][k]== 1)
							array[j][k] = 1;
						
						if(array[j][i] == -1 && array[i][k] == -1)
							array[j][k] = -1;
					}
				}
			}
		}
	}
}