package programmers1;

//올바른 괄호
public class problem_18 {
	public static void main(String[] args) {
		boolean result = solution("()))((");
		System.out.println(result);
	}
	
	private static boolean solution(String s) {
		boolean answer = false;
		int count = 0;
		
		for(int i =0 ; i< s.length() ; i++) {
			if(count < 0) //바르게 짝지어졌다는 것은 '('문자로 열였으면 반드시 ')' 문자로 닫혀야 한다는 뜻
				return false;
			if(s.charAt(i) == '(')
				count++;
			else
				count--;
		}
		
		
		if(count == 0)
			return !answer;
		return answer;
	}
}
