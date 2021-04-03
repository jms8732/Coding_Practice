package programmers1;

/*
 * 입국 심사
 * 시간을 이분 탐색의 대상으로 정하여 진행한다
 * 
 * (추정된 시간 / 심사관들의 시간) 은 결국 해당 심사관이 추정 시간 내에 해결 가능한 손님이다.
 * 
 */
import java.util.*;

public class problem_4 {
	public static void main(String[] args) {
		int[] tmp = { 7, 10 };
		long result = solution(6, tmp);
		System.out.println(result);
	}

	public static long solution(int n, int[] times) {
		Arrays.sort(times);

		long left = 0L, right = 1000000000 * 100000L;
		long mid = 0;

		while (left < right) {
			mid = (left + right) / 2;

			if (isPossible(n, mid, times)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}

	private static boolean isPossible(int n, long mid, int times[]) {
		long count = 0;

		for (int i = 0; i < times.length; i++) {
			count += mid / times[i];
		}

		return count >= n;
	}
}
