package dp;

/*
 * �ټ���� (DP)
 * LIS(Longest Increase Sequence) ����
 * LIS�� �̿��ϴ� ����
 * 1) ������������ ������ �����ϴ� ��
 * 2) ���� �� �����ϴ� ����(������������ �� ��̵�)�� ������Ű�� ������ ��̸� �̵���Ű�� ���
 */
import java.util.*;

public class problem_2631 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] array = new int[N];

		for (int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
		}

		sc.close();
		
		int [] cache = new int[N];
		Arrays.fill(cache, 1);
		//LIS
		for(int i = N-1 ; i >= 0  ; i--) {
			for(int j = i+1 ; j < N ; j++) {
				if(array[i] < array[j]) {
					cache[i] = Math.max(cache[i], cache[j] + 1);
				}
			}
		}
		
		int max =0;
		
		for(int i : cache)
			max = Math.max(i,max);
		
		System.out.println(N - max);
		
	}
}
