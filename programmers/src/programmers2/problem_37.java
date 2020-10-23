package programmers2;

/*
 * 두개 뽑아서 더하기
 * TreeSet을 이용
 */

import java.util.*;

public class problem_37 {
	public static void main(String[] args) { 
		int numbers [] = {2,1,3,4,1};
		
		for(int i : solution(numbers)) {
			System.out.print(i + " ");
		}
	}
	public static int[] solution(int[] numbers) {
		Set<Integer> set = new TreeSet<>(); //중복되는 숫자를 제거함과 동시에 오름차순으로 정렬하기 위해 사용

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int sum = numbers[i] + numbers[j];

				set.add(sum);
			}
		}

		int ret[] = new int[set.size()];
		int idx = 0;
		for (int i : set) {
			ret[idx++] = i;
		}

		return ret;
	}
}
