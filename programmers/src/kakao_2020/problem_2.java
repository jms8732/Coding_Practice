package kakao_2020;
/*
 * 괄호 변환
 * 풀이 시간: 26분 소요
 * 구현 문제
 * 문제에서 주어진 방식대로 구현을 진행한다.
 */

public class problem_2 {
	public static void main(String[] args) {
		String result = solution("()))((()");
		System.out.println(result);
	}

	public static String solution(String p) {

		return divideString(p);
	}
	
	private static String divideString(String p) {
		if(p.isEmpty())
			return "";
		
		String u = null;
		String v = null;
		
		StringBuilder sb = new StringBuilder();
		
		int count = 0;
		for(int i =0 ; i < p.length() ; i++) {
			if(p.charAt(i) == '(')
				count++;
			else
				count--;
			
			if(count == 0) {
				u = p.substring(0,i+1);
				v = p.substring(i+1,p.length());
				break;
			}
		}
		
		if(u.charAt(0) == ')') {
			//올바르지 못한 문자열
			sb.append("(").append(divideString(v)).append(")").append(convertString(u));
		}else {
			//올바른 문자열
			sb.append(u).append(divideString(v));
		}
		
		return sb.toString();
	}
	
	private static String convertString(String u) {
		StringBuilder sb = new StringBuilder(u);
		sb.deleteCharAt(0);
		sb.deleteCharAt(sb.length()-1);
		
		char [] temp = sb.toString().toCharArray();
		
		for(int i =0 ; i < temp.length ; i++) {
			if(temp[i] == '(')
				temp[i] = ')';
			else
				temp[i] = '(';
		}
		
		return String.valueOf(temp);
	}
}
