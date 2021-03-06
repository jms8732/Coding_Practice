package programmers;

//무지의 먹방 라이브 16.5점 => 71.4점

import java.util.*;

public class problem_39 {
	public static void main(String[] args) {
		int[] food_times = { 3, 1, 1, 1, 2, 4, 3 };
		int k = 12;
		int result = solution(food_times, k);

		System.out.println(result);
	}

	public static int solution(int[] food_times, long k) {
		List<Node> list = new ArrayList<Node>();
		for (int i = 0; i < food_times.length; i++) {
			list.add(new Node(food_times[i], i));
		}

		list.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.count < o2.count) // 남은 시간으로 오름차순 정렬
					return -1;
				else
					return 1;
			}
		});

		long previousCount = 0;
		for(int i =0 ; i< list.size() ; i++) {
			long currentCount = list.get(i).count;
			int size = list.size() - i;
			int idx= 0;
			
			for(int j = i+1 ; j< list.size() ; j++) {
				if(list.get(j).count != currentCount)
					break;
				idx = j;
			}
			
			if(k < (currentCount - previousCount) * size) {
				list = list.subList(i, list.size());
				
				list.sort(new Comparator<Node>() {

					@Override
					public int compare(Node o1, Node o2) {
						// TODO Auto-generated method stub
						if(o1.idx < o2.idx)
							return -1;
						else
							return 1;
					}
					
				});
				
				long iidx = k % list.size();
				return list.get((int)iidx).idx+1;
			}
			if(idx !=0)
				i = idx;
			k -= (currentCount- previousCount) * size;
			previousCount = currentCount;
		}
		return -1;

	}

	public static class Node {
		long count;
		int idx;

		public Node(long count, int idx) {
			this.count = count;
			this.idx = idx;
		}
	}
}
