package greedy;

//순회 강연
import java.util.*;
import java.io.*;

public class problem_2109 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		boolean []  days = new boolean[10001];
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if (arg0.p > arg1.p) {
					return -1;
				}else if(arg0.p == arg1.p) {
					if(arg0.d < arg1.d)
						return -1;
					else
						return 1;
				}else
					return 1;
			}

		});

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			pq.add(new Node(p, d));
		}

		int totalCost = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			for(int i = cur.d ; i >= 1; i--) {
				if(!days[i]) {
					days[i]= true;
					totalCost += cur.p;
					break;
				}
			}
			
		}
		System.out.println(totalCost);
	}

	private static class Node {
		int p, d;

		public Node(int p, int d) {
			this.p = p;
			this.d = d;
		}

	}
}
