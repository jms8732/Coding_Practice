package programmers1;

//문자열 내림차순으로 배치하기
import java.util.*;
public class problem_42 {
	public static void main(String[] args0) {
		String s = "Zbcdefg";
		String result = solution(s);
		System.out.println(result);
	}
	
	public static String solution(String s) {
		List<Character> list = new ArrayList<>();
		
		for(int i =0 ; i< s.length() ; i++) {
			list.add(s.charAt(i));
		}
		
		list.sort(new Comparator<Character>() {

			@Override
			public int compare(Character arg0, Character arg1) {
				// TODO Auto-generated method stub
				if(arg0 < arg1)
					return 1;
				else 
					return -1;
			}
			
		});
		
		StringBuilder sb= new StringBuilder();
		for(int i =0 ; i< list.size() ; i++) sb.append(list.get(i));
		
		return sb.toString();
	}
}
