package programmers1;
//가장 긴 팰린드롬 25점

import java.util.*;

public class problem_12 {
	public static void main(String[] args) {
		int result = solution("aaa");
		System.out.println(result);
	}

	public static int solution(String s) {
		int answer = 0;
		int len = s.length();
		
		for(int i =0 ;i  < s.length() ; i++) {
			for(int j = len; j > answer; j--) {
				int left = i;
				int right = left+j-1;
				while(left < right && s.charAt(left) == s.charAt(right)) {
					left ++;
					right --;
				}
				if(left >= right && answer < j)
				{
					answer = j;
					break;
				}
			}
		}
		
		return answer;
	}
}
