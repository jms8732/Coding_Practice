package simulation;

//회전하는 큐
import java.util.*;
import java.io.*;

public class problem_1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Deque<Integer> dq = new LinkedList<>();
		for (int i = 1; i <= N; i++)
			dq.add(i);

		Queue<Integer> q = new LinkedList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			q.add(Integer.parseInt(st.nextToken()));
		}

		simulation(q, dq);
	}

	private static void simulation(Queue<Integer> goal, Deque<Integer> dq) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(dq, goal, 0));

		int answer = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			// 첫 번째 액션
			while (!cur.dq.isEmpty() && !cur.goal.isEmpty() && cur.dq.peek() == cur.goal.peek()) {
				cur.dq.poll();
				cur.goal.poll();
			}

			if (cur.goal.isEmpty()) {
				answer = Math.min(answer, cur.count);
				continue;
			}

			Deque<Integer> tmp_f = new LinkedList<>(cur.dq);
			int count_f = cur.count;
			// 두 번째 액션
			int first = 0;
			while ((first = tmp_f.peekFirst()) != cur.goal.peek()) {
				tmp_f.addLast(tmp_f.pollFirst());
				count_f += 1;
			}
			
			Deque<Integer> tmp_l = new LinkedList<>(cur.dq);
			int count_l = cur.count;
			
			int last = 0;
			while ((last = tmp_l.peekFirst()) != cur.goal.peek()) {
				tmp_l.addFirst(tmp_l.pollLast());
				count_l += 1;
			}

			if(count_f < count_l) {
				q.add(new Node(tmp_f,cur.goal,count_f));
			}else
				q.add(new Node(tmp_l,cur.goal,count_l));

		}

		System.out.println(answer);
	}

	private static class Node {
		Queue<Integer> goal;
		Deque<Integer> dq;
		int count;

		public Node(Deque<Integer> dq, Queue<Integer> g, int c) {
			this.dq = new LinkedList<>(dq);
			this.goal = new LinkedList<>(g);
			this.count = c;
		}
	}
}
