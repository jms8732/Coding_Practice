package programmers1;

//��� ���� ��������
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
			//Ȧ��
			sb.append(s.charAt(s.length() /2));
		}else
		{
			//¦��
			int mid = (s.length() / 2) -1;
			sb.append(s.charAt(mid)).append(s.charAt(mid+1));
		}
		
		return sb.toString();
	}
}
