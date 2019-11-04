package samsung;

import java.util.*;

public class problem_13458 {
	static int[] classRoom;
	static int B, C;
	static int N;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		classRoom = new int[N];
		for (int i = 0; i < N; i++) {
			classRoom[i] = scanner.nextInt(); // 배열에 값 할당
		}
		B = scanner.nextInt();
		C = scanner.nextInt();
		long result = f();
		System.out.println(result);
	}

	static long  f() {
		long count = 0;
		for (int i = 0; i < classRoom.length; i++) {
			int tmp = classRoom[i] - B;
			count++;
			if (tmp > 0) {
				count += isZero(tmp);
				tmp /= C;
				count += tmp;
			}
		}

		return count;
	}

	static int isZero(int t) {
		return t % C > 0 ? 1 : 0;
	}
}
