package programmers2;

/*
 * �ΰ� �̾Ƽ� ���ϱ�
 * TreeSet�� �̿�
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
		Set<Integer> set = new TreeSet<>(); //�ߺ��Ǵ� ���ڸ� �����԰� ���ÿ� ������������ �����ϱ� ���� ���

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
