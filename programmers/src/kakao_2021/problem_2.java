package kakao_2021;

import java.util.*;

/*
 * 메뉴 리뉴얼
 * 풀이 시간: 32분
 * 
 * 주문을 대상으로 만들 수 있는 조합을 구성하여 map에 저장한다.
 * 그 후, map에 있는 값을 이용하여 조건에 맞춰서 스카피가 추가하고 싶은 코스 요리를 구성한다
 */
public class problem_2 {
	static Map<String, Integer> map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		int[] course = { 2, 3, 5 };

		for (String s : solution(orders, course)) {
			System.out.print(s + " ");
		}
	}

	public static String[] solution(String[] orders, int[] course) {
		map = new HashMap<>();

		for (int i = 0; i < orders.length; i++) {

			for (int j = 2; j <= orders[i].length(); j++) {
				char[] temp = new char[j];
				combination(0, 0, temp, orders[i]);
			}
		}

		List<String> temp = new ArrayList<>();
		List<String> ans = new ArrayList<>();

		for (int i = 0; i < course.length; i++) {
			int big = 0;
			for (Map.Entry<String, Integer> m : map.entrySet()) {
				int val = m.getValue();
				String key = m.getKey();

				if (course[i] == key.length() && val >= 2 &&  big <= val) {
					if (big < val) {
						temp.clear();
						big = val;
					}

					temp.add(key);
				}
			}

			Collections.sort(temp); // 사전순 정렬
			ans.addAll(temp);
			temp.clear();
		}

		String[] ret = new String[ans.size()];
		Collections.sort(ans);

		for (int i = 0; i < ret.length; i++) {
			ret[i] = ans.get(i);
		}

		return ret;
	}

	private static void combination(int depth, int next, char[] ord, String order) {
		if (depth == ord.length) {
			char[] temp = Arrays.copyOf(ord, ord.length);
			Arrays.sort(temp); // 사전순으로 정렬

			String key = String.valueOf(temp);
			if (map.containsKey(key)) {
				map.replace(key, map.get(key) + 1);
			} else
				map.put(key, 1);

			return;
		}

		for (int i = next; i < order.length(); i++) {
			ord[depth] = order.charAt(i);
			combination(depth + 1, i + 1, ord, order);
		}
	}

}
