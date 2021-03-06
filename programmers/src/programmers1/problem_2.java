package programmers1;

//가운데 글자 가져오기
import java.util.*;

public class problem_2 {
	public static void main(String[] args) {
		String result = solution("abcd");
		System.out.println(result);
	}
	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		int len = s.length() % 2;
		if(len != 0) {
			//홀수
			sb.append(s.charAt(s.length() /2));
		}else
		{
			//짝수
			int mid = (s.length() / 2) -1;
			sb.append(s.charAt(mid)).append(s.charAt(mid+1));
		}
		
		return sb.toString();
	}
}
