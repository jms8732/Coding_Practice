package dp;

/*
 * 연속부분최대곱
 * 메모이제이션 할 대상은 이전 연속된 값들 중 가장 큰 값을 저장한다.
 */

import java.util.*;
import java.io.*;

public class problem_2670 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		double[] array = new double[N];

		for (int i = 0; i < array.length; i++) {
			array[i] = Double.parseDouble(br.readLine());

		}

		double[] cache = new double[N];
		System.arraycopy(array, 0, cache, 0, N);

		double ans = array[0];
		for (int i = 1; i < array.length; i++) {
			cache[i] = Math.max(cache[i], Math.max(array[i - 1] * cache[i], cache[i-1] * cache[i]));
			//cache[i] = Double.parseDouble(String.format(".4f", cache[i]));
			ans = Math.max(ans, cache[i]);
		}

		System.out.println(String.format("%.3f",ans));
	}
}
