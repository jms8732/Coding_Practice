package greedy;

//회의실 배정
import java.util.*;
import java.io.*;

public class problem_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N  = Integer.parseInt(br.readLine());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		StringTokenizer st = null;
		for(int i =0 ; i < N ; i++) {
			st=  new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(start,end));
		}
		
		int count = 0;
		int idx = -1;
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			count++;
			
			if(cur.start >= idx) {
				idx = cur.end;
				continue;
			}
			
			if(cur.start <= idx && cur.end <= idx) {
				count--;
				idx = cur.end;
				continue;
			}
			
			if(cur.start <= idx && idx <= cur.end)
				count--;
		}
		
		System.out.println(count);
	}

	private static class Node implements Comparable<Node>{
		int start,end;

		public Node(int s, int e) {
			this.start = s;
			this.end = e;
		}

		@Override
		public int compareTo(Node arg0) {
			// TODO Auto-generated method stub
			if(this.start < arg0.start)
				return -1;
			else if(this.start == arg0.start) {
				if(this.end < arg0.end)
					return -1;
				else
					return 1;
			}else
				return 1;
		}
		
		
	}
}
