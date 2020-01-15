package programmers1;

//문자열 내 p와 y의 개수
public class problem_41 {
	public static boolean solution(String s) {
		int pCount = 0, yCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'p' || s.charAt(i) == 'P')
				pCount++;
			if(s.charAt(i) == 'y' || s.charAt(i) == 'Y')
				yCount++;
		}

		if (pCount == yCount)
			return true;
		return false;
	}
}
