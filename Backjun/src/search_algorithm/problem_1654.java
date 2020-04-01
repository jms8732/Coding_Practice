package search_algorithm;

//랜선 자르기
import java.util.*;
import java.io.*;

public class problem_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] array = new long[N];

		for (int i = 0; i < N; i++)
			array[i] = Long.parseLong(br.readLine());

		Arrays.sort(array);
		simulation(N, K, array);
	}

	private static void simulation(int N, int K, long[] array) {
		long min = 1, max = (long)Math.pow(2, 31);

		while (min < max) {
			long mid = (min + max) / 2;
			long count = cut(mid, array);

			if (K <= count)
				min = mid + 1;
			else
				max = mid;

		}

		System.out.println(min - 1);
	}

	private static long cut(long min, long[] array) {
		long value = 0;

		for (int i = array.length - 1; i >= 0; i--) {
			long tmp = array[i] / min;
			if (tmp != 0)
				value += tmp;
			else
				break;
		}

		return value;
	}
}
