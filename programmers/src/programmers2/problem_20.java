package programmers2;

import java.util.*;

//징검다리 건너기
public class problem_20 {
	public static void main(String[] args) {
		int[] stones = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int k = 5;

		System.out.println(solution(stones, k));
	}

	public static int solution(int[] stones, int k) {
		int totalPeople = Integer.MAX_VALUE;
		int idx = 0;
		boolean check = false;

		for (int i = 1; i < stones.length; i++) {
			if (stones[i - 1] < stones[i]) {
				check = true;
				break;
			}
		}

		if (!check) {
			totalPeople = stones[stones.length-k];
		} else {
			while (idx < stones.length) {
				int count = 1;
				int cur = idx;
				int big = stones[idx++];

				while (idx < stones.length && count < k) {
					int tmp = stones[idx];
					if (big <= tmp) {
						cur = idx;
						big = tmp;
					}
					idx++;
					count++;
				}

				// 뛸 수 있는 칸이 이미 배열 범위 밖이라면
				if (count < k) {
					big = Integer.MAX_VALUE;
				}

				totalPeople = Math.min(totalPeople, big);

				idx = cur + 1;
			}
		}
		return totalPeople;
	}
}
