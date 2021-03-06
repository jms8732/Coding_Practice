package programmers1;

//디스크 컨트롤, 30점 -> 45점 
import java.util.*;

public class problem_1 {
	public static void main(String[] args) {
		int[][] tmp = {{24, 10}, {18, 39}, {34, 20}, {37, 5}, 
				{47, 22}, {20, 47}, {15, 34}, {15, 2}, 
				{35, 43}, {26, 1}};
		int result = solution(tmp);
		System.out.println(result);
	}

	public static int solution(int[][] jobs) {
		boolean[] visited = new boolean[jobs.length];
		PriorityQueue<Node> queue = new PriorityQueue<>(); // 작업 시간을 넣기위한 우선순위 큐
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				if (arg0[0] < arg1[0]) // 도착한 시간을 대상으로 오름 차순 정렬
					return -1;
				else if (arg0[0] == arg1[0]) {
					if (arg0[0] < arg1[1])
						return -1;
					else
						return 1;
				} else
					return 1;
			}

		});

		int total = 0; // 총 시간
		int average = 0; // 요청에서 종료까지
		for (int i = 0; i < jobs.length; i++) {
			for (int j = 0; j < jobs.length; j++) {
				if (total >= jobs[j][0] && !visited[j]) { // 한번도 오지 않았으며 진행 시간내에 있는 경우
					queue.add(new Node(jobs[j][0], jobs[j][1])); // 작업 시간을 넣는다.
					visited[j] = true;
				}
			}

			if (!queue.isEmpty()) {
				// 큐에 값이 있는 경우
				Node tmp = queue.poll();
				total += tmp.duration;
				average += total - tmp.start;
			} else {
				// 큐에 값이 없는 경우, 즉 시간 내에 있지 않고 멀리 떨어져 있는 경우
				// 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리한다.
				total = jobs[i][0] + jobs[i][1]; //시작시간보다 작기 떄문에
				average += jobs[i][1];
				visited[i] = true;
			}
		}

		return average / jobs.length;
	}

	public static class Node implements Comparable<Node> {
		int start, duration;

		public Node(int s, int d) {
			this.start = s;
			this.duration = d;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if (this.duration < o.duration) // 작업 길이 순으로 오름차순 정렬
				return -1;
			else
				return 1;
		}

	}
}
