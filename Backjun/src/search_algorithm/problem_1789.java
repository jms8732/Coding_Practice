package search_algorithm;

/*
 * 수들의 합
 * 1~n까지의 합은 (n*(n+1))/2 로 계산할 수 있다. 이 점을 이용하여 이분 탐색을 진행한다.
 */

import java.util.*;
import java.io.*;

public class problem_1789 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());

		binary_search(n);
	}

	/*
	 * 이분 탐색
	 * 1~mid까지 수들의 합을 구한다.
	 * left와 right가 같아지는 지점이 곧 합을 만들기 위한 필요한 최대 개수이다.
	 * 
	 */
	private static void binary_search(long n) {
		long left = 0, right = 4294967295L;
		long mid = 0; 
		while (left < right) {
			mid = (left + right) / 2; 
			long sum = (mid * (mid + 1)) / 2;

			if (sum > n)
				right = mid;
			else
				left = mid + 1;
		}
		System.out.println(left-1);
	}
}
