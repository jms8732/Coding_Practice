package dp;

//폴리오미노

import java.util.*;
import java.io.*;

public class poly {
	static int cache[][];
	static int MOD = 10 * 1000 * 1000;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			N = Integer.parseInt(br.readLine());
			cache = new int[101][101];

			for (int[] d : cache)
				Arrays.fill(d, -1);

			int result =0 ;
			for (int j= 1; j <= N; j++) {
				result += poly(N,j);
				result %= MOD;
			}
			
			System.out.println(result);

		}
	}

	private static int poly(int bc, int first) {
		if (first == bc)
			return 1;

		if (cache[bc][first] != -1)
			return cache[bc][first];

		int ret = 0;

		for (int i = 1; i <= bc - first; i++) {
			int cc = i + first - 1;
			cc *= poly(bc - first, i);
			cc %= MOD;

			ret += cc;
			ret %= MOD;
		}

		return cache[bc][first] = ret;
	}
}
