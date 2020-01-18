package programmers2;

import java.util.Arrays;

//제일 작은 수 제거하기
public class problem_1 {
	public static void main(String[] args) {
		int[] arr = {10};
		for(int i : solution(arr)) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] solution(int [] arr) {
		if(arr.length == 1)
		{
			//배열의 길이가 1인 경우
			int [] tmp = {-1};
			return tmp;
		}
		
		int [] answer = new int[arr.length- 1];
		int min = Integer.MAX_VALUE;
		
		//작은 값 찾기
		for(int i =0 ; i < arr.length ; i++)
			min = Math.min(arr[i], min); 
		int idx =0 ;
		for(int i =0 ; i< arr.length ; i++) {
			if(min != arr[i])
				answer[idx++] = arr[i];
		}
		
		return answer;
		
	}
}
