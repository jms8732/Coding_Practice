package search_algorithm;

/*
 * ������ ��
 * 1~n������ ���� (n*(n+1))/2 �� ����� �� �ִ�. �� ���� �̿��Ͽ� �̺� Ž���� �����Ѵ�.
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
	 * �̺� Ž��
	 * 1~mid���� ������ ���� ���Ѵ�.
	 * left�� right�� �������� ������ �� ���� ����� ���� �ʿ��� �ִ� �����̴�.
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
