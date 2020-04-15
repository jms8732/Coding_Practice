package dp;

//암호 코드
import java.util.*;
import java.io.*;

public class problem_2011 {
	static int MOD = 1000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();
		long[] one = new long[line.length()];

		long[] two = new long[line.length()];

		// 길이가 1인 경우
		if (line.length() == 1) {
			if (line.charAt(0) == '0')
				System.out.println(0);
			else
				System.out.println(1);
		} else {
			if (line.charAt(0) == '0')
				System.out.println(0);
			else {
				one[0] = 1;

				for (int i = 1; i < line.length(); i++) {
					int val = (line.charAt(i - 1) - '0') * 10 + (line.charAt(i) - '0');

					if (1 <= val && val <= 26)
						two[i] = one[i - 1];

					if (line.charAt(i) == '0')
						one[i] = 0;
					else {
						one[i] = one[i - 1];
						one[i] = (one[i] + two[i - 1]) % MOD;
					}
				}
				System.out.println((one[line.length() - 1] + two[line.length() - 1]) % MOD);

			}
		}
	}

}
