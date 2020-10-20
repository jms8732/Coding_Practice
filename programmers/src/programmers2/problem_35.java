package programmers2;

/*
 * 3xN
 * ���� ���� 2133�� ������ ����
 * bitmask + dp�� �̿��ؼ� ������ �ذ��Ѵ�.
 */
public class problem_35 {
	public static int solution(int n) {
		if (n % 2 == 0) { //Ȧ�� �� ���, Ÿ���� �� �� ����.
			int[][] cache = new int[n][1 << 3]; //cache���� ����� ���� �����Ѵ�.
			int mod = 1000000007;
			
			//n�� 2�� ��� ������ 3�������ϴµ� �׷��� ���ؼ��� 110, 011, 000 �� ���� 1�̿��� �Ѵ�.
			cache[0][3] = cache[0][6] = cache[0][0] = 1; 

			for (int i = 1; i < n; i++) {
				cache[i][7] = ((cache[i - 1][0] + cache[i - 1][3]) % mod + cache[i - 1][6]) % mod;
				cache[i][4] = cache[i - 1][6];
				cache[i][6] = (cache[i - 1][1] + cache[i - 1][7]) % mod;
				cache[i][3] = (cache[i-1][4] + cache[i-1][7]) % mod;
				cache[i][1] = cache[i-1][6];
				cache[i][0] = cache[i-1][7];
			}
			
			return cache[n-1][7];
		} else
			return 0;
	}
}
