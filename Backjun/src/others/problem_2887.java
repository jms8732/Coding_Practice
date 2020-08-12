package others;

//행성 터널
import java.util.*;
import java.io.*;

public class problem_2887 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		parent = new int[N];

		for (int i = 0; i < parent.length; i++)
			parent[i] = i;

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if (arg0.cost < arg1.cost)
					return -1;
				else if (arg0.cost == arg1.cost)
					return 0;
				else
					return 1;
			}

		});


		StringTokenizer st = null;
		List<Plant> p = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			p.add(new Plant(x,y,z,i));
		}
		
		p.sort(new Comparator<Plant>() {

			@Override
			public int compare(Plant arg0, Plant arg1) {
				// TODO Auto-generated method stub
				if(arg0.x < arg1.x)
					return -1;
				else if(arg0.x == arg1.x)
					return 0;
				else
					return 1;
			}
			
		});
		
		for(int i = 1;  i< N ; i++) {
			pq.add(new Node(p.get(i).num , p.get(i-1).num,Math.abs(p.get(i).x - p.get(i-1).x)));
		}
		
		p.sort(new Comparator<Plant>() {

			@Override
			public int compare(Plant o1, Plant o2) {
				// TODO Auto-generated method stub
				if(o1.y < o2.y)
					return -1;
				else if(o1.y == o2.y)
					return 0;
				else
					return 1;
			}
			
		});
		
		for(int i = 1;  i< N ; i++) {
			pq.add(new Node(p.get(i).num , p.get(i-1).num,Math.abs(p.get(i).y - p.get(i-1).y)));
		}
		
		
		p.sort(new Comparator<Plant>() {

			@Override
			public int compare(Plant o1, Plant o2) {
				// TODO Auto-generated method stub
				if(o1.z < o2.z)
					return -1;
				else if(o1.z == o2.z)
					return 0;
				else
					return 1;
			}
			
		});
		
		
		for(int i = 1;  i< N ; i++) {
			pq.add(new Node(p.get(i).num , p.get(i-1).num,Math.abs(p.get(i).z - p.get(i-1).z)));
		}
		min_spanning_tree(pq);
	}

	private static void min_spanning_tree(PriorityQueue<Node> pq) {

		long answer = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (union(cur.n1, cur.n2)) {
				answer += cur.cost;
			}
		}

		System.out.println(answer);
	}

	private static boolean union(int c1, int c2) {
		int p1 = find(c1);
		int p2 = find(c2);

		if (p1 == p2)
			return false;

		if (p1 < p2) {
			parent[p2] = p1;
		} else
			parent[p1] = p2;
		return true;
	}

	private static int find(int child) {
		if (child == parent[child])
			return child;
		else
			return parent[child] = find(parent[child]);
	}

	private static class Plant {
		int x, y, z, num;

		public Plant(int x, int y, int z, int n) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.num = n;
		}
	}

	private static class Node {
		int n1, n2;
		long cost;

		public Node(int n1, int n2, long c) {
			this.n1 = n1;
			this.n2 = n2;
			this.cost = c;
		}
	}
}
