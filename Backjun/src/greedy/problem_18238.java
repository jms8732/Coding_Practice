package greedy;

/*
 * ZOAC 2
 * 현재 문자를 기준으로 오른쪽, 왼쪽의 거리를 계산 후, 거리 중 최솟값을 찾는다.
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
