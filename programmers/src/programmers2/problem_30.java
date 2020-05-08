package programmers2;

//[3차] n진수 게임

public class problem_30 {
	public static void main(String[] args) {
		System.out.println(solution(4, 1, 10, 2));
	}

	public static String solution(int n, int t, int m, int p) {
		String line = makeString(n, t);
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < line.length(); i++) {
			if (result.length() == t)
				break;

			if ((i % m) + 1 == p)
				result.append(line.charAt(i));
		}

		return result.toString();
	}

	// n진수를 t개 만든다.
	private static String makeString(int n, int t) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <= 1000 * 100; i++) {
			StringBuilder tmp = new StringBuilder();

			int div = i / n;
			int mod = i % n;

			if (mod >= 10 && mod <= 15) {
				tmp.append(convert(mod));
			} else
				tmp.append(mod);

			while (div >= n) {
				mod = div % n;
				div = div / n;

				if (mod >= 10 && mod <= 15) {
					tmp.insert(0, convert(mod));
				} else
					tmp.insert(0, mod);
			}

			if (div != 0) {
				if (div >= 10 && div <= 15)
					tmp.insert(0, convert(div));
				else
					tmp.insert(0, div);
			}

			sb.append(tmp.toString());
		}

		return sb.toString();
	}

	private static String convert(int val) {
		if (val == 10)
			return "A";
		else if (val == 11)
			return "B";
		else if (val == 12)
			return "C";
		else if (val == 13)
			return "D";
		else if (val == 14)
			return "E";
		else
			return "F";
	}
}
