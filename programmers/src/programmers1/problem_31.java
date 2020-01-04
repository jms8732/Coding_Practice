package programmers1;

//�ְ��� ����

import java.util.*;

public class problem_31 {
	public static void main(String[] args) {
		int n = 2,  s= 9;
		int [] result = solution(n,s);
		
		for(int i : result)
			System.out.print(i + " ");
		
	}

	public static int[] solution(int n, int s) {
		int [] answer = null;
		if(s / n == 0) {
			answer = new int[1];
			answer[0] = -1;
			return answer;
		}
		else {
			answer = new int[n];
			Arrays.fill(answer, s/n);
			int rest = s% n;
			for(int i = 0 ; i< rest;  i++) {
				answer[i] += 1;
			}
		}
		
		Arrays.sort(answer);
		
		return answer;
	}
}
