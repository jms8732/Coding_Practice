package dp;

//quantization 
import java.util.*;
import java.io.*;

public class quantization {
	static int[] array;
	static int[] qSum, qMul;
	static int[][] cache;
	static int INF = 987654321;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			array = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				array[j] = Integer.parseInt(st.nextToken());

			cache = new int[N + 1][K + 1];

			for (int[] tmp : cache)
				Arrays.fill(tmp, -1);

			qSum = new int[N+1];
			qMul = new int[N+1];

			preCal();
			System.out.println(quantization(0, K));
		}
	}

	private static void preCal() {
		Arrays.sort(array);
		
		qSum[0] = array[0];
		qMul[0] = array[0] * array[0];
		
		for (int i = 1; i <N; i++) {
			qSum[i] = qSum[i-1] + array[i];
		}

		for (int i = 1; i < N; i++) {
			qMul[i] = qMul[i-1] + array[i] * array[i];
		}
	}

	private static int quantization(int from, int parts) {
		if (from == N)
			return 0;

		if (parts == 0)
			return INF;

		if (cache[from][parts] != -1)
			return cache[from][parts];

		int ret = (cache[from][parts] == -1 ? INF : cache[from][parts]);

		for (int size = 1; from + size <= array.length; size++) {
			ret = cache[from][parts] = Math.min(ret,
					quantization(from + size, parts - 1) + minError(from, from + size-1));
		}

		return ret;
	}

	private static int minError(int lo, int hi) {
		int sum = qSum[hi] - (lo ==0 ? 0 : qSum[lo-1]);
		int sqsum = qMul[hi] - (lo == 0 ? 0 : qMul[lo-1]);

		int m = (int) Math.round((double) sum / (hi - lo + 1));

		int ret = sqsum - 2 * m * sum + m * m * (hi - lo + 1);

		return ret;
	}
}
