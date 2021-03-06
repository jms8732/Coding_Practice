package programmers1;
//가장 긴 팰린드롬 
//manacher 알고리즘
import java.util.*;

public class problem_12 {
	public static void main(String[] args) {
		int result = solution("abcdcba");
		System.out.println(result);
	}

	public static int solution(String s) {
		String updateString = getUpdateString(s);
		int answer =0 ;
		int p[] = new int[updateString.length()];
		int c=0,r=0; //center, rightBounday
		
		for(int i = 1; i< updateString.length() ; i++) {
			//String 순회
			int mirror = 2*c - i;
			
			if(i < r)
				p[i] = Math.min(r-i, p[mirror]);
			
			
			int left = i-(1+p[i]);
			int right = i+(1+p[i]);
			while(right < updateString.length() && left >= 0 && updateString.charAt(left) == updateString.charAt(right) ) {
				//확장
				left--;
				right++;
				p[i]++; 
			}
			
			if(i+ p[i] > r) {
				//rightBoundary를 넘었을 경우
				c = i; //center 갱신
				r = i + p[i]; //right boundary 갱신
				
				answer = Math.max(p[i],answer); //가장 큰 값을 구하기 위한 
			}
		}
		
		
		return answer;
		
	}
	private static String getUpdateString(String s) {
		//#을 붙인 String을 얻기 위한 메소드
		StringBuilder sb  =new StringBuilder(s);
		for(int i =0 ; i< s.length() ; i++) {
			sb.insert(i+(i+1), '#');
		}
		sb.insert(0, '#');
		
		return sb.toString();
	}
}
