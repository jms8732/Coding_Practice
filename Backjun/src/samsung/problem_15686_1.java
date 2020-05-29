package samsung;

//치킨 배달
import java.util.*;
import java.io.*;

public class problem_15686_1 {
	static int[][] map;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		List<Point> chicken = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());

				if (t == 2) {
					chicken.add(new Point(i, j));
				}

				map[i][j] = t;

			}
		}
		List<Point> val = new ArrayList<>();

		combination(0, M, val, chicken);
		System.out.println(answer);
	}

	private static void combination(int next, int M, List<Point> val, List<Point> chicken) {
		if (val.size() == M) {
			// 치킨 집을 모두 선택
			int dis = cal_distance(val);
			answer = Math.min(answer, dis);
			return;
		}

		for (int i = next; i < chicken.size(); i++) {
			val.add(chicken.get(i));
			combination(i + 1, M, val, chicken);
			val.remove(val.size() - 1);
		}
	}

	private static int cal_distance(List<Point> val) {
		int N = map.length;

		int total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					int dist = Integer.MAX_VALUE;
					for (Point chick : val)
						dist = Math.min(dist, Math.abs(chick.x - i) + Math.abs(chick.y - j));

					total += dist;
				}
			}
		}

		return total;
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
