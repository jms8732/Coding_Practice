package programmers;
import java.util.*;
//전화 번호 목록 46점  => 84.6점
public class problem_26 {
	public static void main(String[] args) {
		String[] book = {"123","13","3"};
		boolean result = solution(book);
		System.out.print(result);
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		HashMap<String, Boolean> map = new HashMap<>();
		
		for(int i =0 ; i< phone_book.length ; i++) {
			if(!map.isEmpty()) {
				//맵에 값이 있는 경우
				Iterator it = map.keySet().iterator();
				while(it.hasNext()) {
					//맵에 인쓴 값들을 돌면서 확인
					String tmp = (String)it.next();
					String sub;
					if(tmp.length() >= phone_book[i].length()) {
						//길이가 tmp가 더 길거나 같은 경우
						sub = tmp.substring(0,phone_book[i].length());
						if(sub.equals(phone_book[i]))
							return false;
					}
					else {
						//phone_book[i]이 더 긴 경우
						sub = phone_book[i].substring(0,tmp.length());
						if(sub.equals(tmp))
							return false;
					}		
				}
				map.put(phone_book[i], true);
			}
			else
				map.put(phone_book[i], true);
		}
		
		return answer;
	}
}
