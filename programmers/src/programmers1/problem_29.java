package programmers1;

import java.util.Arrays;

//����

public class problem_29 {
	public static void main(String[] args) {
		int d[] = { 1, 3, 2, 5, 4 };
		int budget = 9;

		System.out.println(solution(d, budget));

	}

	public static int solution(int[] d, int budget) {
		int count = 0;
		Arrays.sort(d); //������������ ����
		int value = 0;
		for(int i =0 ; i < d.length;i++) {
			if(budget < value + d[i])
				break;
			count++;
			value += d[i];
		}
		
		
		return count;
	}
}
