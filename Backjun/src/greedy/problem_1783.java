package greedy;

/*
 * 병든 나이트 (Case work)
 * 경우에 따라 나이트가 방문하는 개수가 다르다.
 */
import java.util.*;

public class problem_1783 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		sc.close();

		greedy(N, M);
	}

	private static void greedy(int N, int M) {

		if (N >= 3) {
			if (M >= 7) {
				System.out.println(M - 2);
			} else {
				if (M >= 4)
					System.out.println(4);
				else
					System.out.println(M);

			}
		} else if (N >= 2) {
			if (M >= 7) {
				System.out.println(4);
			} else {
				System.out.println(M / 2 + (M % 2 > 0 ? 1 : 0));
			}
		} else
			System.out.println(1);
	}
}
