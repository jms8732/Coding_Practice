package dp;

/*
 * Four Squaure
 * sqrt와 pow를 이용하여 문제를 해결
 */
import java.util.*;

public class problem_17626 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = (int) Math.sqrt(N);

		int[] array = new int[N + 1];
		array[0] = 1;

		for (int i = 1; i < array.length; i++) {
			for (int j = (int) Math.sqrt(i); j >= 1; j--) {
				int left = i - (int) Math.pow(j, 2);
				int right = (int) Math.pow(j, 2);

				array[i] = Math.min(array[i] == 0 ? 5 : array[i], array[left] + array[right]);

			}
		}

		System.out.println(array[N]);
	}

}
