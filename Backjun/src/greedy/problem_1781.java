package greedy;

//ÄÅ¶ó¸é
import java.util.*;
import java.io.*;

public class problem_1781 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list.add(new Node(d, c));
		}

		list.sort(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.deadline < o2.deadline)
					return -1;
				else if (o1.deadline == o2.deadline) {
					if (o1.cupramen > o2.cupramen)
						return -1;
					else if(o1.cupramen == o2.cupramen)
						return 0;
					else
						return 1;
				} else
					return 1;
			}

		});

		int time = 1;
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i = 0; i < list.size(); i++) {
			int cur_cup = list.get(i).cupramen;
			int cur_dead = list.get(i).deadline;

			if (time > cur_dead) {
				if(!pq.isEmpty() && pq.peek() < cur_cup) {
					answer -= pq.poll();
					answer += cur_cup;
					pq.add(cur_cup);
				}
				continue;
			}

			answer += cur_cup;
			pq.add(cur_cup);
			time++;
		}
		System.out.println(answer);
	}

	private static class Node {
		int deadline, cupramen;

		public Node(int d, int c) {
			this.deadline = d;
			this.cupramen = c;
		}
	}
}
