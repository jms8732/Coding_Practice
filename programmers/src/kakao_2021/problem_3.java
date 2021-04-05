package kakao_2021;

import java.util.*;

/*
 * 순위 검색
 * 첫 번째 접근 방법 => 언어, 직군, 경력, 음식에 대해서 각각의 Map을 만들고 retainAll을 이용하여 진행한다.(교집합)
 * 두 번째 접근 방법 => 그룹을 만들어서 해결한다.
 * 풀이 시간: 1시간 이상
 */
public class problem_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] infos = {"java backend junior pizza 150",
				"java backend junior pizza 150",
				"java backend junior pizza 150",
				"java backend junior pizza 150"};
		String[] query = {"- and - and - and - 1"};

		for (int i : solution(infos, query))
			System.out.print(i + " ");
	}

	public static int[] solution(String[] info, String[] query) {
		Map<String, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < info.length; i++) {
			String[] split = info[i].split(" ");

			// info 정보를 통해 만들 수 있는 그룹
			String[] l = { split[0], "-" };
			String[] p = { split[1], "-" };
			String[] c = { split[2], "-" };
			String[] f = { split[3], "-" };

			String[][] total = { l, p, c, f };
			int s = Integer.parseInt(split[4]);

			combination(0, s, total, new StringBuilder(), map);

		}
		
		
		for(Map.Entry<String, List<Integer>> m : map.entrySet()) {
			m.getValue().sort(null);
		}

		int[] ret = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			String[] split = query[i].split(" ");

			String l = split[0];
			String p = split[2];
			String c = split[4];
			String f = split[6];

			String t = String.join("", l, p, c, f);
			int s = Integer.parseInt(split[7]);

			/*
			 * TC 2,3,4,7,13,16이 런타임 에러가 발생할 경우 
			 * info의 그룹에 없는 쿼리가 날라올 수 있다는 점을 유의해야 한다.
			 */
			ret[i] = lowerBound(map.getOrDefault(t, new ArrayList<>()), s);
		}

		return ret;
	}

	//이분 탐색을 할 때마다 정렬을 진행하게 되면 효율성이 떨어지게 된다
	private static int lowerBound(List<Integer> list, int target) {
		int left = 0;
		int right = list.size();

		while (left < right) {
			int mid = (left + right) / 2;

			if (list.get(mid) < target) {
				left = mid + 1;
			} else
				right = mid;
		}

		return list.size() - left;
	}

	private static void combination(int depth, int score, String[][] total, StringBuilder sb,
			Map<String, List<Integer>> map) {
		if (depth == total.length) {
			if (map.containsKey(sb.toString()))
				map.computeIfPresent(sb.toString(), (k, v) -> v).add(score);
			else
				map.computeIfAbsent(sb.toString(), x -> new ArrayList<>()).add(score);
			return;
		}

		for (int i = 0; i < total[depth].length; i++) {
			sb.append(total[depth][i]);
			combination(depth + 1, score, total, sb, map);
			sb.delete(sb.length() - total[depth][i].length(), sb.length());
		}
	}
}
