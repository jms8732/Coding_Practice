package programmers;
//큰수 만들기 25점
import java.util.*;
public class problem_13 {
	public static void main(String[] args) {
		String result = solution("1924",2);
		System.out.println(result);
	}
	public static String solution(String number, int k) {
		Stack<Character> stack = new Stack<>();
		char[] result = new char[number.length() - k]; //결과 값 저장
		for(int i =0 ; i< number.length() ; i++) {
			char c = number.charAt(i); //현재 값
			while(!stack.empty() && stack.peek() < c && k-- > 0)
				stack.pop();
			stack.push(c);
		}
		for(int i =0 ; i  < result.length ; i++) {
			result[i] = stack.get(i);
		}
		return new String(result);
    }
	
}
