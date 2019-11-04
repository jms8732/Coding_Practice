package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

//������, �켱���� ť�� �̿�
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
		//�켱 ������ �������� ���Ѵ� => ū ���� ���� �� ������ ���� �������� �ȴ�.
		for(int i : properties) {
			priority.add(i);
		}
		while(!priority.isEmpty()) {
			for(int i =0 ; i< properties.length ; i++) {
				if(properties[i] == (int)priority.peek()) { //peek()�� ���� �����ְ� ������ ���� �ʴ´�.
					if(i == location)
						return answer;
				priority.poll(); //���� ����
				answer++;
				}
			}
		}
		
		return answer;
	}
}
