package kakao_2021;

import java.util.*;

/*
 * �޴� ������
 * Ǯ�� �ð�: 32��
 * 
 * �ֹ��� ������� ���� �� �ִ� ������ �����Ͽ� map�� �����Ѵ�.
 * �� ��, map�� �ִ� ���� �̿��Ͽ� ���ǿ� ���缭 ��ī�ǰ� �߰��ϰ� ���� �ڽ� �丮�� �����Ѵ�
 */
public class problem_2 {
	static Map<String, Integer> map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] orders = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
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

			Collections.sort(temp); // ������ ����
			ans.addAll(temp);
			temp.clear();
		}

		Collections.sort(ans);
		String[] ret = ans.toArray(new String[ans.size()]);
				

		return ret;
	}

	private static void combination(int depth, int next, char[] ord, String order) {
		if (depth == ord.length) {
			char[] temp = Arrays.copyOf(ord, ord.length);
			Arrays.sort(temp); // ���������� ����

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
