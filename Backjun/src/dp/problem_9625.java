package dp;

import java.util.*;

/*
 * BABBA
 * 피보나치 수열을 이용하여 A와 B의 개수를 구하면 된다.
 */
public class problem_9625 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int A[] = new int[46];
		int B[] = new int[46];

		A[1] = 0;
		B[1] = A[2] = B[2] = 1;

		if (N <= 2)
			System.out.println(A[N] + " " + B[N]);
		else {
			for (int i = 3; i <= N; i++) {
				A[i] = A[i - 2] + A[i - 1];
				B[i] = B[i - 2] + B[i - 1];
			}

			System.out.println(A[N] + " " + B[N]);
		}
	}
}
