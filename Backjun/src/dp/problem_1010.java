package dp;

/*
 * �ٸ� ����
 * DP ������ ����
 */
import java.util.*;
import java.io.*;

public class problem_1010 {
	static int cache[][];
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			cache = new int[N][M];
			for (int c[] : cache)
				Arrays.fill(c, -1);
			
			System.out.println(dp(0,0));
		}
	}

	private static int dp(int A, int B) {
		if (A == N) // ���ʿ� �ִ� �ٸ��� �� ����� ���
			return 1;
		
		if(B == M) //������ �ٸ��� ������ ��� ��� 
			return 0;

		if (cache[A][B] != -1)
			return cache[A][B];

		int ret = 0;

		//�ݺ����� ���鼭 ���� -> ���� �ٸ��� �����Ѵ�
		for (int i = B; i < M; i++) {
			ret += dp(A+1,i+1); //�ٸ� ����
		}
		
		return cache[A][B]=ret;
}}
