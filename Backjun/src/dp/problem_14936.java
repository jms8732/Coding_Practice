package dp;

/*
 * 엘레베이터 장난
 * 조건을 나눠서 진행해야 한다.
 */
import java.util.*;

public class problem_14936 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String tmp = sc.nextLine();

		StringTokenizer st = new StringTokenizer(tmp);

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if (N == 1) {
			if (M <= 0)
				System.out.println(1);
			else if (M >= 1)
				System.out.println(2);
		} else if (N == 2) {
			if (M <= 0)
				System.out.println(1);
			else if (M == 1)
				System.out.println(3);
			else
				System.out.println(4);
		} else {
			int count = 1;
			for (int i = 1; i < 10; i++) {

				if ((i & 1 << 1) == 1 << 1 && (i & 1 << 2) == 1 << 2) {
					// 짝,홀 일 경우
					continue;
				} else {
					int temp = M;
					for (int j = 0; j < 4; j++) {
						if ((i & 1 << j) == 1 << j) {
							if (j == 0)
								temp -= ((N - 1) / 3) + 1;
							else if (j == 1)
								temp -= (N / 2) + (N % 2);
							else if (j == 2)
								temp -= N / 2;
							else
								temp -= N;
						}
					}

					if (temp >= 0) {
					//	System.out.println(i + ": " + Integer.toBinaryString(i));
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
