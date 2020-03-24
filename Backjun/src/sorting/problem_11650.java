package sorting;

//��ǥ �����ϱ�
import java.util.*;
import java.io.*;

public class problem_11650 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i =0 ; i< N ; i++) {
			st =new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(x,y));
		}
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			System.out.println(cur.x + " " + cur.y);
		}
	}
	
	private static class Node implements Comparable<Node>{
		int x ,y;
		public Node(int x ,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Node arg0) {
			// TODO Auto-generated method stub
			if(this.x < arg0.x)
				return -1;
			else if(this.x == arg0.x) {
				if(this.y < arg0.y)
					return -1;
				else
					return 1;
			}else
				return 1;
		}
		
	}
}
