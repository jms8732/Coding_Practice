package others;

/*
 * 자리수로 나누기
 * 조합 + 큰 수 MOD 연산을 이용
 */
import java.util.*;

public class problem_1490 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String n = sc.nextLine();

		System.out.println(simulation(n));
	}

	private static String simulation(String n) {
		StringBuilder sb = new StringBuilder(n);

		if (isModZero(n, n)) {
			return n;
		}

		int max = 1;
		while (true) {
			int depth = 0;
			String ret = makeNumber(depth, max++, n, sb);
			if(ret != null)
				return ret;
		}
	}

	private static String makeNumber(int depth, int max, String n, StringBuilder sb) {
		if (depth == max) {
			if (isModZero(n, sb.toString())) {
				return sb.toString();
			}
			return null;
		}

		String ret = null;
		for (int i = 0; i <= 9; i++) {
			sb.append(i);

			ret = makeNumber(depth + 1, max, n, sb);

			if (ret != null)
				return ret;

			sb.deleteCharAt(sb.length() - 1);
		}

		return ret;
	}

	private static boolean isModZero(String n, String target) {
		char[] temp = n.toCharArray();
		char[] temp_tar = target.toCharArray();

		for (int i = 0; i < temp.length; i++) {
			char cur = temp[i];

			if (cur == '0')
				continue;

			int mod = 0;
			for (int j = 0; j < temp_tar.length; j++) {
				mod = ((temp_tar[j] - '0') + mod * 10) % (cur - '0');
			}

			if (mod != 0)
				return false;
		}

		return true;
	}
}
