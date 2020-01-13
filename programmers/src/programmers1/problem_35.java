package programmers1;

//야근 지수
import java.util.*;

public class problem_35 {
	public static void main(String[] args0) {
		int[] works = {1,1};
		long result = solution(3,works);
		System.out.println(result);
	}

	public static long solution(int n, int[] works) {
		long answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i =0 ;i <works.length ; i++) pq.add(works[i]);
		for(int i =1 ; i <= n ; i++) {
			if(pq.isEmpty())
				break;
			int tmp = pq.poll()- 1;
			
			if(tmp != 0)
				pq.add(tmp);
		}
		
		while(!pq.isEmpty()) {
			answer += Math.pow(pq.poll(),2);
		}
		return answer;
	}
}
