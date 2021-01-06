package dp;

/*
 * 줄세우기 (DP)
 * LIS(Longest Increase Sequence) 문제
 * LIS를 이용하는 이유
 * 1) 오름차순으로 정렬을 진행하는 점
 * 2) 가장 긴 증가하는 수열(오름차순으로 선 어린이들)를 고정시키고 나머지 어린이를 이동시키는 방법
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
