package programmers;
//오픈 채팅방

import java.util.*;

public class problem_36 {
	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		String[] result = solution(record);
		for (String t : result)
			System.out.println(t);
	}

	public static String[] solution(String[] record) {
		HashMap<String, String> map = new HashMap<>();
		Vector<String> result = new Vector<>();
		for (int i = 0; i < record.length; i++) {
			String[] parse = record[i].split(" ");
			if (parse[0].equals("Enter")) {
				map.put(parse[1], parse[2]);
				String tmp = parse[1] + "님이 들어왔습니다.";
				result.add(tmp);
			} else if (parse[0].equals("Change")) {
				map.put(parse[1], parse[2]); // 닉네임 변경
			} else {
				String tmp = parse[1] + "님이 나갔습니다.";
				result.add(tmp);
			}
		}

		String v[] = new String[result.size()];
		for(int i =0 ; i< result.size() ; i++) {
			String tmp = result.get(i);
			for (int j = 0; j < tmp.length(); j++) {
				if (tmp.charAt(j) == '님') {
					String id = tmp.substring(0, j);
					String nick = map.get(id);
					tmp = tmp.replace(id, nick); // id를 닉으로 교체
					v[i] = tmp;
					break;
				}
			}
		}

		

		return v;
	}
}
