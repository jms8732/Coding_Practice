package programmers;
//후보키

import java.util.*;

public class problem_38 {
	public static void main(String[] args) {
		String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } };

		int result = solution(relation);
		System.out.println(result);
	}

	public static int solution(String[][] relation) {
		int row = relation.length; // 릴레이션
		int col = relation[0].length; // 컬럼
		int result = 0;
		List<Integer> list = new ArrayList<>(); // 유일성을 담는 리스트
		for (int i = 1; i < (1 << col); i++) {
			// 컬럼의 종류 생성
			int bitmask = i;
			
			if(minmum(bitmask,list))
				continue;

			if (Unique(bitmask, relation)) // 유일성에 만족 할 경우
				list.add(bitmask);
			
			
		}
		return list.size();
	}

	public static boolean Unique(int bitmask, String[][] relation) {
		int row = relation.length;
		int col = relation[0].length;

		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < row; i++) {
			// 컬럼으로 반복문 수행
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < col; j++) {
				if ((bitmask & (1<<j)) == (1<<j)) {
					// 해당 비트 마스크가 값보다 크면
					String tmp = relation[i][j];
					sb.append(tmp);
				}
			}
			String tmp = sb.toString();
			if (set.contains(tmp))
				return false; // 값이 이미 존재할 경우 유일성에 배제
			set.add(tmp);
		}

		return true;
	}
	public static boolean minmum(int bitmask, List<Integer> list) {
		for(int tmp : list) {
			if((bitmask & tmp) == tmp)
				return true;		
		}
		
		return false;
	}
}
