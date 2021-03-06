package programmers2;

//[3차] 압축
import java.util.*;

public class problem_14 {
	static HashMap<String, Integer> map;

	public static void main(String[] args) {
		int[] result = solution("KAKAO");
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(String msg) {
		map = new HashMap<>();

		// 한 글자 사전 삽입
		for (char i = 'A'; i <= 'Z'; i++) {
			map.put(Character.toString(i), (i - 'A') + 1);
		}

		int idx = 27;
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String prev = null;
		int i = 1;
		sb.append(msg.charAt(0));
		while (sb.toString() != null) {
			if (i >= msg.length())
				break;

			sb.append(msg.charAt(i++));

			// 사전에 값이 없을 경우
			if (!map.containsKey(sb.toString())) {
				prev = sb.substring(0, sb.length() - 1);
				list.add(map.get(prev));

				prev = sb.substring(0, sb.length());
				map.put(prev, idx++);

				sb.delete(0, sb.length() - 1);
			}
		}

		list.add(map.get(sb.toString()));

		int[] answer = new int[list.size()];

		for (int j = 0; j < answer.length; j++)
			answer[j] = list.get(j);

		return answer;
	}
}
