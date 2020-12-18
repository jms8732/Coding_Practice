package others;

//소수의 연속합

import java.util.*;
import java.io.*;

public class problem_1644 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		boolean[] prime = new boolean[N + 1];
		List<Integer> prime_list = new ArrayList<>();
		
		//에라토스테네스의 체를 이용
		for (int i = 2; i < prime.length; i++) {
			if (!prime[i]) {
				// 아직 방문하지 않은 소수
				prime_list.add(i);
				for (int j = i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}

		int count = 0, left = 0, right = 0;
		int sum = 0;

		//연속된 합이므로 투 포인터를 이용하여 합을 구한다.
		while (left < prime_list.size()) {		
			while(right < prime_list.size()) {
				sum += prime_list.get(right++);
				if(sum >= N) {
					if(sum == N) {
						count++;
					}
					break;
				}
			}
			
			while(left < right) {
				sum -= prime_list.get(left++);
				if(sum <= N) {
					if(sum == N) {
						count++;
					}
					break;
				}
			}
		}

		System.out.println(count);
	}
}
