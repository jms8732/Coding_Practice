package programmers;

import java.util.*;

//더 맵게, 33점
public class problem_15 {
	public static void main(String[] args) {
		int[] tmp = { 1, 2, 3, 9, 10, 12};
		int k = 1000;
		int result = solution(tmp, k);
		System.out.println(result);
	}

	public static int solution(int[] scoville, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int count = 0;
		for (int i : scoville) {
			queue.add(i); // 값 대입
		}

		while(!queue.isEmpty()) { //우선 순위 큐가 빌 때 까지
			boolean check = false;
			int previous =0 ;
			if(queue.size() ==1)
				return -1;
			if(!queue.isEmpty())
				previous = queue.poll();
			int next = 0;
			if(!queue.isEmpty())
				next = queue.poll();
			int mix = previous + 2 * next;
			count++;
			queue.add(mix);
			for(int tmp : queue) {
				if(tmp < k) {
					check = true;
					break;
				}
			}
			if (!check)
				return count;
		}
		return -1;
	}

}
