package others;

//�κ� ��

import java.io.*;
import java.util.*;

public class problem_1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		simulation(array, N, S);
	}

	private static void simulation(int[] array, int N, int S) {
		int s = 0, e = 0;
		int val = 0;
		int ans = Integer.MAX_VALUE;

		while (true) {
			if (s == N && e == N)
				break;

			// ��ǥġ�� ���� ������ ���
			if (val >= S) {
				ans = Math.min(ans, Math.abs(s - e));
				val -= array[s++];

			} else {				
				//�� ������ �迭�� ���� �ȿ� �����ϴ� ���
				if (e != N) {
					val += array[e++];
				} else {
					val -= array[s++];
				}
			}

		}
		if (ans == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(ans);
	}
}
