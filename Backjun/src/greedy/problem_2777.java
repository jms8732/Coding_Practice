package greedy;

/*
 * 숫자 놀이
 * 2~9까지의 수를 Div, Mod를 이용하여 문제를 해결한다.
 * 
 */
import java.util.*;
import java.io.*;

public class problem_2777 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int N = Integer.parseInt(br.readLine());
			if (N >= 1 && N <= 9)
				System.out.println(1);
			else
				System.out.println(computeNumber(N));
		}
	}

	private static int computeNumber(int N) {
		StringBuilder sb = new StringBuilder();

		for (int i = 9; i >= 2; i--) {
			while (N % i == 0) {
				sb.append(i);
				N /= i;
			}
		}

		if (N == 1)
			return sb.length();

		return -1;
	}
}
