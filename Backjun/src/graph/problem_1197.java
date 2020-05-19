package graph;

//최소 스패닝 트리
import java.util.*;
import java.io.*;

public class problem_1197 {
	static int parent[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> pq= new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if(arg0.weight < arg1.weight)
					return -1;
				else
					return 1;
			}
			
		});
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(s,e,w));
		}
		
		min_spanningTree(N,pq);
	}
	private static void min_spanningTree(int N,PriorityQueue<Node> pq) {
		parent = new int[N];
		for(int i =0 ; i < parent.length ; i++) {
			parent[i] = i;
		}
		
		int answer = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			int v1 = cur.start;
			int v2 = cur.end;
			
			
			if(union_find(v1,v2)) {
				answer += cur.weight;
			}
		}
		
		System.out.println(answer);
	}
	
	private static boolean union_find(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);
		
		if(p1 == p2)
			return false;
		
		if(p1 > p2) {
			parent[p1] = p2;
		}else
			parent[p2] = p1;
		
		return true;
	}

	private static int find(int p1) {
		if(p1 == parent[p1])
			return p1;
		else
			return find(parent[p1]);
	}
	
	private static class Node {
		int start, end, weight;

		public Node(int s, int e, int w) {
			this.start = s;
			this.end = e;
			this.weight = w;
		}
	}
}
