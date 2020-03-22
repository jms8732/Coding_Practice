package topology_sort;

//게임 개발
import java.util.*;
import java.io.*;

public class problem_1516 {
	static int N;
	static List<Integer> list[];
	static int[] indegree;
	static int[] time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N];
		indegree = new int[N];
		time = new int[N];

		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<>();

		StringTokenizer st = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int timer = Integer.parseInt(st.nextToken());
			time[i] = timer;

			int next = Integer.parseInt(st.nextToken());

			while (next != -1) {
				list[next - 1].add(i);
				next = Integer.parseInt(st.nextToken());
			}
		}

		topology_sort();
	}

	private static void topology_sort() {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				indegree[list[i].get(j)] += 1;
			}
		}

		for (int i = 0; i < N; i++) {
			if (indegree[i] == 0)
				queue.add(new Node(time[i],i));
		}

		int answer[] = new int[N];
		int big = 0;
		for (int i = 0; i < N; i++) {
			if (queue.isEmpty())
				break;
			Node current = queue.poll();
			answer[i] = current.time;

			for (int j = 0; j < list[current.index].size(); j++) {
				int next = list[current.index].get(j);
				indegree[next] -= 1;

				if (indegree[next] == 0) {
					time[next] += current.time;
					queue.add(new Node(time[next],next));
				}
			}

		}

		for (int i = 0; i < N; i++) {
			System.out.println(time[i]);
		}
	}

	private static class Node implements Comparable<Node> {
		int time, index;

		public Node(int t, int i) {
			this.time = t;
			this.index = i;
		}

		@Override
		public int compareTo(Node arg0) {
			// TODO Auto-generated method stub
			if (this.time < arg0.time)
				return -1;
			else
				return 1;
		}

	}
}
