package dp;

import java.util.*;

public class problem_1904 {
	static int[] array;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		array = new int[size + 1];
		int result = (f(size)) ;
		System.out.println(result);
	}

	static int f(int idx) {
		if (idx < 0)
			return 0;
		if (idx == 1)
			return 1;
		if (idx == 2)
			return 2;
		if (array[idx] != 0)
			return array[idx];
		array[idx] = ((f(idx-1) + f(idx-2)) % 15746);
		return array[idx];
	}
}
