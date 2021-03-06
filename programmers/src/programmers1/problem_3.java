package programmers1;
//예산 65점

import java.util.*;

public class problem_3 {
	public static void main(String[] args) {
		int[] tmp = { 120, 110, 140, 150 };
		int result = solution(tmp, 485);
		System.out.println(result);
	}

	public static int solution(int[] budgets, int M) {
		Arrays.sort(budgets);//오름차순으로 정렬
		
		long sum = 0;
		int low = 0,high = M;
		int mid, premid = 0;
		
		for(int i =0 ; i< budgets.length ; i++) {
			sum += budgets[i];
		}
		
		if(sum <= M)
			return budgets[budgets.length-1];
		
		while(true) {
			sum =0 ;
			mid = (low + high) /2;
			
			if(premid == mid)
				break;
			
			for(int i =0 ; i< budgets.length ; i++) {
				if(budgets[i] >= mid) {
					sum += mid * (budgets.length - i);
					break;
				}else
					sum += budgets[i];
			}
			
			if(sum >= M) {
				high = mid;
			}else
				low = mid;
			
			premid = mid;
		}
		
		return mid;
	}
}
