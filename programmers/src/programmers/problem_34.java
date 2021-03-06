package programmers;

import java.util.*;

//숫자 야구
public class problem_34 {
	static Vector<String> v;

	public static void main(String[] args) {
		int tmp[][] = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };
		int result = solution(tmp);
		System.out.println(result);
	}

	public static int solution(int[][] baseball) {
		v = new Vector<>();

		// 각각의 서로 다른 수로 구성된 3자리 숫자르 모두 생성한다.
		boolean visited[] = new boolean[10];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 9; i++) {
			visited[i] = true;
			sb.append(i);
			for (int j = 1; j <= 9; j++) {
				if (!visited[j]) {
					visited[j] = true;
					sb.append(j);
					for (int k = 1; k <= 9; k++) {
						if (!visited[k]) {
							sb.append(k);
							v.add(sb.toString());
							sb.deleteCharAt(2);
						}
					}
					sb.deleteCharAt(1);
					visited[j] = false;
				}
			}
			sb.deleteCharAt(0);
			visited[i] = false;
		}

		Vector<String> result = new Vector<>();
		for (String value : v) {
			boolean check = false;
			for (int i = 0; i < baseball.length; i++) {
				int strike = baseball[i][1];
				int ball = baseball[i][2];
				String compareValue = Integer.toString(baseball[i][0]);
				int strikeCount = 0;
				int ballCount = 0;
				for (int j = 0; j < compareValue.length(); j++) {
					if (compareValue.charAt(j) == value.charAt(j))
						strikeCount++;
				}
				if(strike != strikeCount) {
					check = true;
					break;
				}
				
				for (int j = 0; j < compareValue.length(); j++) {
					char target = value.charAt(j);
					int previous = (compareValue.length() + j - 1) % compareValue.length();
					int next = (j + 1) % compareValue.length();
					if (compareValue.charAt(previous) == target)
						ballCount++;
					if (compareValue.charAt(next) == target)
						ballCount++;
				}

				if (ballCount != ball) {
					check =true;
					break;
				}
			}
			if(!check)
				result.add(value);
		}
		return result.size();
	}
}
