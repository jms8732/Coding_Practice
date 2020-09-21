package dp;

import java.util.*;
import java.io.*;

/*
 * 박성원
 * bit + dp를 이용하여 문제를 해결할 수 있다.
 * 숫자를 long, int 형으로 담을 수 없기 때문에 나머지 연산을 라빈 카프 형태로 문자를 하나씩 꺼내면서 진행해야한다.
 * 나눠지는지 판단하기 위해 StringBuilder를 이용하여 진행할 경우, 런타임 에러 발생
 * 
 * bit + dp를 이용한 경우, K로 나눠지는 숫자들의 개수를 얻을 수 있다.
 * 기약분수 형태로 표현해야하기 때문에 유클리드 호제법을 이용하여 구한다.
 * 
 */

public class problem_1086{
	static long[][] cache;
	static String[] array;
	static int N, K;
	static int[] len, pow, rem; //길이, 자릿수, 나머지 값을 저장하고 있는 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		array = new String[N];
		len = new int[N];
		pow = new int[51];
		rem = new int[N];
		
		for (int i = 0; i < N; i++)
			array[i] = br.readLine();
		
		K = Integer.parseInt(br.readLine());
		
		for(int i =0 ; i < N  ;i++) {
			len[i] = array[i].length();
			rem[i] = isDivide(array[i].toCharArray());
		}
		
		pow[0] = 1 % K;
		for(int i = 1 ; i < 51 ; i++) pow[i] = (pow[i-1] * 10) % K;
		
		
		cache = new long[1 << N][K + 1];

		for (long[] c : cache)
			Arrays.fill(c, -1);

		long result = dp(0, 0);
		if (result == 0)
			System.out.println(0 + "/" + 1);
		else {
			long total = 1;
			for (int i = 2; i <= N; i++) {
				total *= i;
			}

			lrreducible(total, result);
		}
	}

	private static void lrreducible(long total, long result) {
		long big = total;
		long small = result;

		while (true) {
			long mod = big % small;

			if (mod == 0)
				break;

			big = small;
			small = mod;
		}

		total /= small;
		result /= small;

		System.out.println(result + "/" + total);
	}

	private static long dp(int bit, int mod) {
		if (Integer.bitCount(bit) == N) {
			if (mod == 0)
				return 1;
			return 0;
		}

		if (cache[bit][mod] != -1)
			return cache[bit][mod];

		long ret = 0;

		for (int i = 0; i < N; i++) {
			if ((1 << i) != (bit & 1 << i)) {
				ret += dp(bit | 1<< i,(mod * pow[len[i]] + rem[i]) % K); 
			}
		}

		return cache[bit][mod] = ret;
	}

	//긴 숫자의 나머지를 구하기 위한 메소드
	private static int isDivide(char[] target) {
		int ret = 0;
		for (int i = 0; i < target.length; i++) {
			ret = ((target[i] - '0') + ret * 10) % K;
		}

		return ret;
	}
}
