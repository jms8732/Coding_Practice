package dp;

import java.util.*;
import java.io.*;

/*
 * �ڼ���
 * bit + dp�� �̿��Ͽ� ������ �ذ��� �� �ִ�.
 * ���ڸ� long, int ������ ���� �� ���� ������ ������ ������ ��� ī�� ���·� ���ڸ� �ϳ��� �����鼭 �����ؾ��Ѵ�.
 * ���������� �Ǵ��ϱ� ���� StringBuilder�� �̿��Ͽ� ������ ���, ��Ÿ�� ���� �߻�
 * 
 * bit + dp�� �̿��� ���, K�� �������� ���ڵ��� ������ ���� �� �ִ�.
 * ���м� ���·� ǥ���ؾ��ϱ� ������ ��Ŭ���� ȣ������ �̿��Ͽ� ���Ѵ�.��
 * 
 */

public class problem_1086{
	static long[][] cache;
	static String[] array;
	static int N, K;
	static int[] len, pow, rem; //����, �ڸ���, ������ ���� �����ϰ� �ִ� �迭

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

	//�� ������ �������� ���ϱ� ���� �޼ҵ�
	private static int isDivide(char[] target) {
		int ret = 0;
		for (int i = 0; i < target.length; i++) {
			ret = ((target[i] - '0') + ret * 10) % K;
		}

		return ret;
	}
}
