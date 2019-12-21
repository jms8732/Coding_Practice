package kruskal;

//��Ʈ��ũ ����
import java.util.*;
import java.io.*;

public class problem_1922 {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() { //����� ������� �������� ����

			@Override
			public int compare(Node arg0, Node arg1) {
				// TODO Auto-generated method stub
				if(arg0.cost < arg1.cost)
					return -1;
				else
					return 1;
			}
			
		});
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		int parent[] = new int[N];
		for(int i =0 ;i < N ; i++) parent[i] = i;
		
		StringTokenizer st = null;
		for(int i =0 ; i< M ; i++) {
			st = new StringTokenizer(br.readLine()); //���� �о��
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Node(s-1,e-1,c));
		}
		
		int result = kruskal(pq,parent);
		System.out.println(result);
	}
	private static int kruskal(PriorityQueue<Node> pq, int [] parent) {
		int cost = 0;
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			int c1 =tmp.start;
			int c2=tmp.end;
			if(union(parent,c1,c2)){
				cost += tmp.cost;
			}
		}
		
		return cost;
	}

	private static boolean union(int[] parent, int c1,int c2) {
		c1 = find(parent,c1);
		c2 = find(parent,c2);
		
		if(c1 ==c2)
			return false;
		
		if(c1< c2)
			parent[c2] =c1;
		else
			parent[c1] = c2;
		
		return true;
	}
	
	private static int find(int [] parent, int x) {
		if(x == parent[x])
			return x;
		else
			return find(parent,parent[x]);
		
	}
	
	private static class Node{
		int start,end,cost;
		public Node(int s ,int e, int c)
		{
			this.cost = c;
			this.start = s;
			this.end =e;
		}
	}
}
