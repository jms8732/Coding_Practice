package programmers1;

//보행자 천국
public class problem_11 {
	static int MOD = 20170805;

	public static void main(String[] args) {
		int[][] t = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };
		int result = solution(3, 6, t);
		System.out.println(result);
	}

	public static int solution(int m, int n, int[][] cityMap) {
		int[][] rl = new int[m + 1][n + 1];
		int[][] ud = new int[m + 1][n + 1];

		ud[1][1] = rl[1][1] = 1;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (cityMap[i - 1][j - 1] == 0) {
					// 0일 경우
					rl[i][j] = (ud[i - 1][j] + +rl[i][j] + rl[i][j - 1]) % MOD;
					ud[i][j] = (ud[i][j] + ud[i - 1][j] + rl[i][j - 1]) % MOD;
				} else if (cityMap[i - 1][j - 1] == 2) {
					// 2인 경우,
					rl[i][j] = rl[i][j - 1] % MOD;
					ud[i][j] = ud[i - 1][j] % MOD;
				} else if (cityMap[i - 1][j - 1] == 1) {
					rl[i][j] = 0;
					ud[i][j] = 0;
				}
			}
		}

		return (ud[m - 1][n] + rl[m][n - 1]) % MOD;
	}
}
