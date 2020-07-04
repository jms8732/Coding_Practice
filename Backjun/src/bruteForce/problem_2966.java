package bruteForce;

//Âï±â
import java.util.*;
import java.io.*;

public class problem_2966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String line = br.readLine();
		int[] score = new int[3];
		char[] Adrian = { 'A', 'B', 'C' };
		char[] bruno = { 'B', 'A', 'B', 'C' };
		char[] Goran = { 'C', 'C', 'A', 'A', 'B', 'B' };

		for (int i = 0; i < line.length(); i++) {
			char tar = line.charAt(i);

			if (tar == Adrian[i % 3])
				score[0]++;

			if (tar == bruno[i % 4])
				score[1]++;

			if (tar == Goran[i % 6])
				score[2]++;
		}

		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if (arg0.count > arg1.count)
					return -1;
				else if (arg0.count == arg1.count) {
					if (arg0.name.compareToIgnoreCase(arg1.name) < 0)
						return -1;
					else
						return 1;
				} else
					return 1;
			}

		});

		pq.add(new Node(score[0], "Adrian"));
		pq.add(new Node(score[1], "Bruno"));
		pq.add(new Node(score[2], "Goran"));
		
		Node cur = pq.poll();
		
		int big = cur.count;
		System.out.println(big);
		System.out.println(cur.name);
		while(!pq.isEmpty()) {
			cur = pq.poll();
			
			if(big == cur.count) {
				System.out.println(cur.name);
			}
		}
	}

	private static class Node {
		int count;
		String name;

		public Node(int c, String n) {
			this.count = c;
			this.name = n;
		}
	}
}
