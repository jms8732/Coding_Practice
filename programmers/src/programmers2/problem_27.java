package programmers2;

//핸드폰 번호 가리기

public class problem_27 {
	public static void main(String[] args0) {
		String tmp = "01033334444";
		
		System.out.print(solution(tmp));
	}
	public static String solution(String phone_number) {
		StringBuilder sb =new StringBuilder();
		
		for(int i =0 ; i < phone_number.length() ; i++) {
			if(i < phone_number.length() - 4)
				sb.append("*");
			else
				sb.append(phone_number.charAt(i));
		}
		
		
		return sb.toString();
	}
}
