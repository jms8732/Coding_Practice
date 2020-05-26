package others;

//음식 평론가
import java.util.*;
import java.io.*;

public class problem_1188 {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int cut = 0;
		cut = LCM_GCD(N, M);

		System.out.println(cut);

	}

	private static int LCM_GCD(int N, int M) {
		int big = Math.max(N, M);
		int small = Math.min(N, M);

		int div = 0, mod = 0;

		while (true) {
			mod = big % small;

			if (mod == 0)
				break;

			big = small;
			small = mod;
		}

		return M - small;
	}
}
