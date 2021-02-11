package dp;

/*
 * 투자의 귀재 배주형
 * 각각의 년도마다 큰 금액을 저장한다.
 */
import java.util.*;
import java.io.*;

public class problem_19947 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken()) + 1;

		int[] array = new int[D];
		array[0] = N;

		for (int i = 1; i < D; i++) {
			int o = (int) (array[i - 1] * 1.05);
			int t = (i - 3) >= 0 ? (int) (array[i - 3] * 1.2) : 0;
			int f = (i - 5) >= 0 ? (int) (array[i - 5] * 1.35) : 0;

			array[i] = Math.max(o, Math.max(t, f));
		}

		System.out.println(array[D - 1]);
	}
}
