package programmers1;

//���� ����
import java.util.*;

public class problem_22 {
	public static void main(String[] args) {
		int[] a = { 5, 1, 3, 7 };
		int[] b = { 2, 2, 6, 8 };

		int result = solution(a, b);
		System.out.println(result);
	}

	public static int solution(int[] A, int[] B) {
		PriorityQueue<Integer> pqA = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < A.length; i++) {
			pqA.add(A[i]);
			pqB.add(B[i]);
		}
		int answer = 0;
		while (!pqA.isEmpty() && !pqB.isEmpty()) {
			int a = pqA.peek();
			int b = pqB.peek();

			if (a < b) {
				answer++;
				pqB.poll();
			}
			pqA.poll();
		}
		return answer;
	}
}
