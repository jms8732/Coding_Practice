package greedy;

/*
 * ZOAC 2
 * ���� ���ڸ� �������� ������, ������ �Ÿ��� ��� ��, �Ÿ� �� �ּڰ��� ã�´�.
 */

import java.util.*;

public class problem_18238 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char[] line = sc.next().toCharArray();
		sc.close();

		char current = 'A';
		int time = 0;

		for (int i = 0; i < line.length; i++) {
			char next = line[i];
			int right = Math.abs(current - next);
			int left = 26 - right;

			time += Math.min(right, left);
			current = next;
		}
		System.out.println(time);
	}

}
