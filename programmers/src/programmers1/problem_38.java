package programmers1;

//���￡�� �輭�� ã��

public class problem_38 {
	public static String solution(String[] seoul) {
		int answer =0 ;
		for(int i = 0; i < seoul.length ; i++) {
			if(seoul[i].equals("Kim")) {
				answer =i ;
				break;
			}
		}
		
		
		return "�輭���� " + answer +"�� �ִ�";
	}
}
