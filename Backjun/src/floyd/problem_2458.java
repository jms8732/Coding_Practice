package floyd;

//Ű����

import java.util.*;
import java.io.*;

public class problem_2458 {
	static BufferedReader br;
	static int N, M;
	static int INF = 10000000;

	public static void main(String[] args) {
		StringTokenizer st;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int result = floyd();
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static int floyd() throws IOException {
		int[][] map = new int[N][N];
		for (int t[] : map)
			Arrays.fill(t, INF);

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;

			map[s][e] = 1;
		}

		for(int i =0 ; i < N ; i++)
			map[i][i] = 0;
		
		for (int i = 0; i < N; i++) {
			for (int k = 0; k < N; k++) {
				for (int j = 0; j < N; j++) {
					if (map[k][j] > map[k][i] + map[i][j])
						map[k][j] = map[k][i] + map[i][j];
				}
			}
		}

		boolean member[] = new boolean[N];
		Arrays.fill(member, true);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == INF && map[j][i] == INF) {
					member[i] = false;
					break;
				}
			}
		}
		int answer = 0;
		for(int i =0 ; i< member.length ; i++) {
			if(member[i])
				answer++;
		}
		
		return answer;
	}
}
