package programmers2;

//최솟값 만들기
import java.util.*;
public class problem_7 {
	public static void main(String[] args) {
		int [] A = {1,4,2};
		int [] B = {5,4,4};
		
		System.out.println(solution(A,B));
	}
	
	
	public static int solution(int [] A, int[] B) {
		PriorityQueue<Integer> pqA = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				if(arg0 < arg1)
					return -1;
				else
					return 1;
			}
			
		});
		PriorityQueue<Integer> pqB = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i =0 ; i< A.length ; i++) {
			pqA.add(A[i]);
			pqB.add(B[i]);
		}
		
		int answer=0;
		
		while(!pqA.isEmpty()) {
			int a = pqA.poll();
			int b = pqB.poll();
			
			answer += a*b;
		}
		
		return answer;
	}
}
