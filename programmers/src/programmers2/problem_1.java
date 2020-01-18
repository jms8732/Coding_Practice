package programmers2;

import java.util.Arrays;

//���� ���� �� �����ϱ�
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
			//�迭�� ���̰� 1�� ���
			int [] tmp = {-1};
			return tmp;
		}
		
		int [] answer = new int[arr.length- 1];
		int min = Integer.MAX_VALUE;
		
		//���� �� ã��
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
