package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

//프린터, 우선순위 큐를 이용
public class problem_3 {
	public static void main(String[] args) {
		int pro[] = {1, 1, 9, 1, 1, 1};
		int location = 0;
		int result = solution(pro,location);
		System.out.println(result);
	}
	public static int solution(int[] properties, int location) {
		int answer = 1;
		PriorityQueue priority = new PriorityQueue(Collections.reverseOrder());
		//우선 순위를 역순으로 정한다 => 큰 값이 가장 맨 앞으로 오는 형식으로 된다.
		for(int i : properties) {
			priority.add(i);
		}
		while(!priority.isEmpty()) {
			for(int i =0 ; i< properties.length ; i++) {
				if(properties[i] == (int)priority.peek()) { //peek()는 값을 보여주고 삭제는 하지 않는다.
					if(i == location)
						return answer;
				priority.poll(); //값을 삭제
				answer++;
				}
			}
		}
		
		return answer;
	}
}
