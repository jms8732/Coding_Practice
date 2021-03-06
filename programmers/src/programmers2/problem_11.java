package programmers2;

//[1차] 다트 게임
import java.util.*;

public class problem_11 {
	public static void main(String[] args) {
		String dartResult = "1D2S3T*";
		System.out.println(solution(dartResult));
	}

	public static int solution(String dartResult) {
		int idx = 0;
		int[] save = new int[3];
		int saveIdx = 0;
		while (idx < dartResult.length()) {
			int startIdx = idx;
			while (true) {
				if (dartResult.charAt(idx) == 'S' || dartResult.charAt(idx) == 'D' || dartResult.charAt(idx) == 'T') {
					break;
				}
				idx++;
			}

			String tmp = dartResult.substring(startIdx, idx);
			int value = Integer.parseInt(tmp); // 현재 숫자

			char action = dartResult.charAt(idx);
			switch (action) {
			case 'S':
				value = (int) Math.pow(value, 1);
				break;
			case 'D':
				value = (int) Math.pow(value, 2);
				break;
			case 'T':
				value = (int) Math.pow(value, 3);
				break;
			}
			save[saveIdx] = value;
			
			if(idx >= dartResult.length()-1)
				break;
			
			action = dartResult.charAt(++idx);
			if (action == '*' || action == '#') {
				switch (action) {
				case '*':
					if(saveIdx-1 >= 0)
						save[saveIdx-1] *= 2;
					save[saveIdx] *= 2;
					break;
				case '#':
					save[saveIdx] *= -1;
					break;
				}
				idx++;
			}
			saveIdx++;
		}

		int answer = 0;
		for (int i = 0; i < save.length; i++)
			answer += save[i];

		return answer;
	}
}
