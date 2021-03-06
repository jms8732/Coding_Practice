package programmers;

//구명 보트 정확성 75점
import java.util.*;

public class problem_32 {
	public static void main(String[] args) {
		int[] tmp = { 70, 80, 50 };
		int limit = 100;
		int result = solution(tmp, limit);
		System.out.println(result);
	}

	public static int solution(int[] people, int limit) {
		int result = 0;
		Arrays.sort(people);

		int j = 0;
		for (int i = people.length - 1; i >= j; i--) {
			if (people[i] + people[j] <= limit)
				j++;

			result++;

		}
		return result;
	}
}
