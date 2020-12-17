package programmers2;


//JadenCase 문자열 만들기
import java.util.*;

public class problem_39 {
	public static void main(String[] args) {
		String temp = "3people   unFollowed me ";
		
		System.out.println(solution(temp));
	}
	
    public static String solution(String s) {
    	StringBuilder sb = new StringBuilder();
    	
    	s = s.toLowerCase();
        for(int i =0 ; i < s.length(); i++) {
        	if(i == 0 ) {
        		if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
        			sb.append(Character.toUpperCase(s.charAt(i)));
        		else
        			sb.append(s.charAt(i));
        	}else {
        		if(i - 1 >= 0 && s.charAt(i-1) == ' ') {
        			sb.append(Character.toUpperCase(s.charAt(i)));
        		}else
        			sb.append(s.charAt(i));
        	}
        }
        
        return sb.toString();
    }
}
