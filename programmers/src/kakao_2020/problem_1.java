package kakao_2020;

/*
 * ���ڿ� ����
 * Ǯ�� �ð�: 35�� �ҿ�
 * Map�� �̿��Ͽ� ����Ǵ� ���ڸ� ã�� �����Ѵ�.
 * �տ������� ������ �����ϹǷ� �־��� ���ڿ� s�� ���ݸ� �ݺ����� �����ϸ� �ȴ�
 */
import java.util.*;

public class problem_1 {
	public static void main(String[] args) {
		int result = solution("a");
		System.out.println(result);
	}

	public static int solution(String s) {
		Map<String, Integer> map = new HashMap<>();

		if(s.length() == 1) //TC 5�� 
			return 1;
		
		int ret = Integer.MAX_VALUE;
		for (int len = 1; len <= s.length() / 2; len++) {
			ret = Math.min(ret, divideString(s, 0, len, map, new StringBuilder()));
			map.clear();
		}

		return ret;
	}

	private static int divideString(String s, int start, int len, Map<String, Integer> map, StringBuilder sb) {
		if (start + len > s.length()) {
			sb.append(makeString(map));
			map.clear();
			
			//���� ���ڿ� ó��
			for(int i= start ; i < s.length() ;i++) {
				sb.append(s.charAt(i));
			}
			
			return sb.length();
		}
		
		
		String sub = s.substring(start, start + len);
		if (map.isEmpty()) {
			// map�� ����ִ� ���
			map.putIfAbsent(sub, 1);
		} else {
			if (map.containsKey(sub))
				map.computeIfPresent(sub, (k, v) -> v + 1);
			else {
				sb.append(makeString(map));
				map.clear();
				map.putIfAbsent(sub, 1);
			}
		}

		return divideString(s, start + len, len, map, sb);
	}

	private static String makeString(Map<String, Integer> map) {
		for (Map.Entry<String, Integer> m : map.entrySet()) {
			return m.getValue() != 1 ? m.getValue() + m.getKey() : m.getKey();
		}
		return null;
	}
}
