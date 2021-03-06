package programmers;

//단속 카메라
import java.util.*;

public class problem_47 {
	public static void main(String[] args) {
		int [][] tmp = {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
		int result = solution(tmp);
		System.out.println(result);
	}

	public static int solution(int[][] routes) {
		int answer =0 ;
		int min  = Integer.MIN_VALUE;
		
		List<Node> list = new ArrayList<>();
		for(int i =0 ; i< routes.length ; i++) {
			list.add(new Node(routes[i][0],routes[i][1]));
		}
		list.sort(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if(o1.end < o2.end)
					return -1;
				else
					return 1;
			}
			
		});
		for(Node current : list) {
			if(min < current.start) {
				min = current.end;
				answer++;
				
			}
		}
		
		return answer;
	}

	private static class Node {
		int start, end;

		public Node(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}
}
