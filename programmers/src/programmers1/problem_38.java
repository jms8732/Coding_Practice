package programmers1;

//서울에서 김서방 찾기

public class problem_38 {
	public static String solution(String[] seoul) {
		int answer =0 ;
		for(int i = 0; i < seoul.length ; i++) {
			if(seoul[i].equals("Kim")) {
				answer =i ;
				break;
			}
		}
		
		
		return "김서방은 " + answer +"에 있다";
	}
}
