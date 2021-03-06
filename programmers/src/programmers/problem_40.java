package programmers;

//2018 kakao blind test [1차] 뉴스 클러스터링
import java.util.*;

public class problem_40 {
	public static void main(String[] args) {
		String t1 = "E=M*C^2";
		String t2 = "e=m*c^2";
		int result = solution(t1, t2);
		System.out.println(result);
	}

	public static int solution(String str1, String str2) {
		HashMap<String, Integer> pair1 = new HashMap<>(); // str1를 저장하기 위한 map
		HashMap<String, Integer> pair2 = new HashMap<>(); // str2를 저장하기 위한 map
		int totalCount =0 ;
		// parsing
		str1 = str1.toLowerCase(); // 대소문자 구문을 없애기 위해
		str2 = str2.toLowerCase();
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z') {
				// 해당 문자가 문자일 경우
				StringBuilder sb = new StringBuilder();
				if (i + 1 >= str1.length())
					break;
				char next = str1.charAt(i + 1); // 다음 문자도 확인
				if (next >= 'a' && next <= 'z') {
					int count = 1;
					sb.append(str1.charAt(i)).append(next); // 붙인다.
					if (pair1.get(sb.toString()) == null)
						pair1.put(sb.toString(), 1);
					else {
						count = pair1.get(sb.toString());
						pair1.put(sb.toString(), count+1);
					}
					totalCount += 1;
				}
			}
		}

		for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z') {
				// 해당 문자가 문자일 경우
				StringBuilder sb = new StringBuilder();
				if (i + 1 >= str2.length())
					break;
				char next = str2.charAt(i + 1); // 다음 문자도 확인
				if (next >= 'a' && next <= 'z') {
					int count = 1;
					sb.append(str2.charAt(i)).append(next); // 붙인다.
					if (pair2.get(sb.toString()) == null)
						pair2.put(sb.toString(), 1);
					else {
						count = pair2.get(sb.toString());
						pair2.put(sb.toString(), count+1);
					}
					totalCount += 1;
				}
				
			}
		}

		int union = 0;
		
		int interaction = 0;
		// 교집합
		if (pair1.size() < pair2.size()) {
			Iterator it = pair1.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				int count1 = pair1.get(key);
				int count2 = 0;

				if (pair2.get(key) != null)
					count2 = pair2.get(key);

				interaction += Math.min(count1, count2);
			}
		} else {
			Iterator it = pair2.keySet().iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				int count1 = 0;
				int count2 = pair2.get(key);

				if (pair1.get(key) != null)
					count1 = pair1.get(key);

				interaction += Math.min(count1, count2);
			}
		}
		union = totalCount- interaction;
		if(union == 0)
			return 65536; //합집합이 0인 경우
		
		int result = (int) (65536 * (double) interaction / (double) union);
		return result;
	}
}
