package dp;

/*
 * 타일 장식 물
 * 피보나치 수열로 N개로 구성된 직사각형의 한 변의 길이를 구한다.
 * 나머지 한 변은 tile[N] + tile[N-1]로 구하면 된다.
 */

import java.util.*;

public class problem_13301 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		long[] tile = new long[81];

		tile[1] = 1;
		tile[2] = 1;

		for (int i = 3; i <= 80; i++)
			tile[i] = tile[i - 2] + tile[i - 1];

		System.out.println((tile[N] + tile[N-1]) * 2 + tile[N] * 2);
	}
}
