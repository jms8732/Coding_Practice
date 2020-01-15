package programmers1;

//문자열 다루기 기본

public class problem_43 {
	public static boolean solution(String s) {
		for(int i =0 ; i< s.length() ; i++) {
			
			//문자열 내부에 영문자가 존재한 경우
			if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
				return false;
			if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
				return false;
		}
		
		if(s.length() == 4 || s.length() == 6)
			return true;
		
		return false;
	}
}
