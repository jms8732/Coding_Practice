package samsung;

//치킨 배달
import java.util.*;
import java.io.*;

public class problem_15686 {
	static List<List<Integer>> house;
	static List<List<Integer>> chicken;
	static int totalDist = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		house = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				List<Integer> list = new ArrayList<>();

				if (tmp == 1) {
					// 집의 좌표
					list.add(i);
					list.add(j);
					house.add(list);
				} else if (tmp == 2) {
					// 치킨 집의 좌표
					list.add(i);
					list.add(j);
					chicken.add(list);
				}
			}
		}
		int depth = 0, next = 0;
		List<List<Integer>> combination = new ArrayList<>();
		distance(depth, next, M, combination);
		System.out.println(totalDist);
	}

	private static void distance(int depth, int next, int M, List<List<Integer>> list) {
		if (depth == M) {
			int tmpDist = 0;

			for (int j = 0; j < house.size(); j++) {
				List<Integer> hcur = house.get(j);
				int hx = hcur.get(0);
				int hy = hcur.get(1);

				int dist = Integer.MAX_VALUE;
				for (int i = 0; i < list.size(); i++) {
					List<Integer> cur = list.get(i);
					int cx = cur.get(0);
					int cy = cur.get(1);
					int calDist = Math.abs(cx - hx) + Math.abs(cy - hy);
					dist = Math.min(dist, calDist);
				}
				
				tmpDist += dist;
			}

			totalDist = Math.min(totalDist, tmpDist);

			return;
		}

		for (int i = next; i < chicken.size(); i++) {
			list.add(chicken.get(i));
			distance(depth + 1, i + 1, M, list);
			list.remove(list.size() - 1);
		}
	}
}
