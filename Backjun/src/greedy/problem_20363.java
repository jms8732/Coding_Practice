package greedy;

/*
 * 당근 키우기
 * 가장 큰 값을 대상으로 먼저 준 다음 진행하면 된다.
 */
import java.util.*;

public class problem_20363 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringTokenizer st = new StringTokenizer(sc.nextLine());

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int ans = 0;

		int max = Math.max(X, Y);
		int min = Math.min(X, Y);

		ans = max + (min / 10) + min;
		System.out.println(ans);
	}
}
