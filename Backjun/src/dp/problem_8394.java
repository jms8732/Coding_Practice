package dp;

/*
 * 악수
 * 피보나치 수열과 동일, 일의 자리를 표현하기 위해서 10으로 나눈 나머지를 넣으면 된다.
 */
import java.util.*;

public class problem_8394 {
	public static void main(String[] args0) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] cache = new int[N];
		cache[0] = 1;
		cache[1] = 2;

		for (int i = 2; i < N; i++)
			cache[i] = (cache[i - 1] + cache[i - 2]) % 10;

		System.out.println(cache[N - 1]);
	}
}
