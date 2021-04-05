package kakao_2021;

import java.util.Arrays;

/*
 * 합승 택시 요금
 * 다익스트라 or 플로이드 와샬로 접근해야 한다.
 * Vertex보다 Degree가 더 많으므로 다익스트라보단 플로이드 와샬이 더 간단하다. (n이 최대 200이므로)
 */
public class problem_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6, s = 4, a = 6, b = 2;
		int[][] fares = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
				{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };

		System.out.println(solution(n, s, a, b, fares));
	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {

		int[][] floyd = new int[n][n];
		int INF = 100000000;
		for (int[] f : floyd) {
			Arrays.fill(f, INF);
		}

		for(int i =0 ; i < n ; i++) {
			floyd[i][i] = 0;
		}
		
		for (int i = 0; i < fares.length; i++) {
			int ss = fares[i][0] - 1;
			int ee = fares[i][1] - 1;
			int c = fares[i][2];

			floyd[ss][ee] = floyd[ee][ss] = c;
		}
		

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (floyd[j][k] > floyd[j][i] + floyd[i][k]) {
						// 직접 가는 것보다 거쳐 가는 경우가 빠른 경우
						floyd[j][k] = floyd[j][i] + floyd[i][k];
					}
				}
			}
		}
		
		print(floyd);

		int ans = INF;
		for (int i = 0; i < n; i++) {
			ans = Math.min(ans, floyd[s - 1][i] + floyd[i][a - 1] + floyd[i][b - 1]);
		}

		return ans;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
