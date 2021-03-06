package palindrome;

import java.io.BufferedReader;
import java.io.IOException;

//가장 긴 팰린드롬
import java.io.*;
import java.util.*;

public class problem_13275 {
	public static void main(String[] args0) {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int big = 0 , rightBoundary =0 , center = 0;
		int [] p = null;
		try {
			String s = getModifiedString(br.readLine()); //manacher 알고리즘을 적용하기 위해 수정된 문자열
			p = new int[s.length()];
			for(int i = 0 ; i< s.length() ; i++) {
				int mirror = 2*center -i; //mirror 값
				
				if(i < rightBoundary)
					p[i] = Math.min(rightBoundary - i, p[mirror]); 
				
				//현재 기준으로 왼쪽, 오른쪽을 확장
				int left = i-(p[i]+1);
				int right = i+(p[i]+1);
				
				//확장
				while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
					left--;
					right++;
					p[i]++;
				}
				
				//우측 경계선을 벗어나면 값 갱신
				if(i+p[i] > rightBoundary) {
					center = i;
					rightBoundary = i + p[i];
					big = Math.max(big, p[i]);
				}
			}

			System.out.println(big);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	private static String getModifiedString(String s) {
		StringBuilder sb = new StringBuilder(s);
		
		for(int i =0 ; i< s.length() ; i++) {
			sb.insert(i+i,'#'); //문자열 사이사이에 # 삽입
		}
		
		sb.append('#');
		
		return sb.toString();
		
	}
}
