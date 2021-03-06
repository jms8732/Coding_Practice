package programmers;
//실패율

import java.util.*;

public class problem_37 {
	public static void main(String[] args) {
		int N = 5;
		int[] stage = { 1,1,1,1,1};
		int[] result = solution(N, stage);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(int N, int[] stages) {
		int total = stages.length;
		Arrays.sort(stages); // 오름차순으로 정렬
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			map.put(i, 0);
		}
		for (int i = 0; i < stages.length; i++) {
			if (stages[i] <= N) {
				int count = map.get(stages[i]);
				map.put(stages[i], count + 1);
			}
		}
		List<Node> result = new ArrayList<>();
		Iterator it = map.keySet().iterator();
		while (it.hasNext()) {
			int stage = (int) it.next();
			int count = map.get(stage);
			double failure = 0.0;
			if(total != 0)
				failure = (double) count / (double) total;
			Node n = new Node(stage, failure);
			result.add(n);
			total -= count;
		}

		result.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.failure < o2.failure)
					return 1;
				else if (o1.failure == o2.failure) {
					if (o1.stage < o2.stage)
						return -1;
					else
						return 1;
				} else
					return -1;
			}

		});
		int[] answer = new int[result.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i).stage;
		}

		return answer;
	}
}

class Node {
	double failure;
	int stage;

	public Node(int stage, double failure) {
		this.stage = stage;
		this.failure = failure;
	}
}
