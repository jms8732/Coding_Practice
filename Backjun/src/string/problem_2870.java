package string;

//수학 문제
import java.util.*;
import java.io.*;
import java.math.*;

public class problem_2870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<BigInteger> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			findNumber(tmp, list);
		}

		Collections.sort(list);

		for (BigInteger val : list) {
			System.out.println(val);
		}
	}

	private static void findNumber(String target, List<BigInteger> list) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i) >= '0' && target.charAt(i) <= '9')
				sb.append(target.charAt(i));
			else {
				if (!sb.toString().isEmpty()) {
					list.add(new BigInteger(sb.toString()));
					sb = new StringBuilder();
				}
			}
		}

		if (!sb.toString().isEmpty()) {
			list.add(new BigInteger(sb.toString()));
		}
	}
}
