package others;

import java.util.*;

public class problem_1837 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String big = scanner.next();
		int K = scanner.nextInt();

		boolean[] array = new boolean[K];
		List<Integer> list = new ArrayList<>(); // 소수를 찾는다.

		for (int i = 2; i < K; i++) {
			if (!array[i]) {
				list.add(i);
				for (int j = i; j < K; j += i) {
					if (!array[j])
						array[j] = true;
				}
			}
		}

		boolean check = false;
		int value = 0;
		for (int i = 0; i < list.size(); i++) {
			if (mod(big, list.get(i)) ==0) {
				value = list.get(i);
				check = true;
				break;
			}
		}
		if (!check) {
			System.out.println("GOOD");
		} else {
			System.out.println("BAD " + value);
		}
	}

	private static int mod(String big, int i) {
		int ret = 0;

		for (int j = 0; j < big.length(); j++) {
			ret = (ret * 10 + big.charAt(j) - '0') % i;
		}
		
		return ret;
	}
}
