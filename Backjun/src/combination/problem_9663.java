package combination;

//N-Queen
import java.io.*;

public class problem_9663 {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long start = System.currentTimeMillis();
		int result = solution(Integer.parseInt(br.readLine()));
		long end = System.currentTimeMillis();
		System.out.println("time : " + (end - start) / 1000.0);
		System.out.println(result);
	}

	public static int solution(int n) {
		boolean[][] idx = new boolean[n][n];
		int depth = 0;

		dfs(depth, n, idx);
		return count;
	}

	private static void dfs(int depth, int n, boolean[][] idx) {
		if (depth == n) {
			count++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (check(depth, i, idx)) {
				idx[depth][i] = true;
				dfs(depth + 1, n, idx);
				idx[depth][i]= false;
			}
		}

	}

	private static boolean check(int x, int y, boolean[][] idx) {
		int tmpX = x, tmpY = y;
		
		//상
		while (true) {
			int nx = x - 1;
			if (nx < 0)
				break;
			if (idx[nx][y]) // 색칠된 곳이 있다면
				return false;
			x = nx;
		}

		x = tmpX;

		//상좌
		while (true) {
			int nx = x - 1;
			int ny = y - 1;
			if (nx < 0 || ny < 0)
				break;

			if (idx[nx][ny])
				return false;

			x = nx;
			y = ny;
		}

		x = tmpX;
		y = tmpY;

		//상우
		while (true) {
			int nx = x - 1;
			int ny = y + 1;
			if (nx < 0 || ny >= idx.length)
				break;
			if (idx[nx][ny])
				return false;
			x = nx;
			y = ny;

		}

		return true;
	}
}
