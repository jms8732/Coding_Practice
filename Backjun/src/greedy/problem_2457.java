package greedy;

/*
 * ���ǽ� ����
 * �׸��� ������� ������ ����
 */

import java.util.*;
import java.io.*;

public class problem_2457 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		PriorityQueue<Room> pq = new PriorityQueue<>();
		for(int i =0 ; i <N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			pq.add(new Room(st.nextToken(),st.nextToken()));
		}
		
		PriorityQueue<Integer> used =new PriorityQueue<Integer>(); //���ǽ� ������ �ð��� �ִ� �켱���� ť
		
	
		while(!pq.isEmpty()) {
			Room current = pq.poll();
			
			if(used.isEmpty()) {
				used.add(current.e);
			}else {
				//���� ������ ���� �ð��� ���ǰ� ������ �ð����� ���� ���, ���ǽ��� �ϳ� �� �߰��Ѵ�.
				if(used.peek() > current.s) {
					used.add(current.e);
				}else {
					//���ǰ� ������ �ð��� ���� ������ ���� �ð��� �����ϰų�, �̹� ���ǰ� �����⿡ ���� �� ��, ���� ������ ������ �ð��� �߰��Ѵ�.
					used.poll();
					used.add(current.e);
				}
			}
		}
		
		System.out.println(used.size());
	}
	
	private static class Room implements Comparable<Room>{
		int s, e;
		
		public Room(String s, String e) {
			this.s = Integer.parseInt(s);
			this.e = Integer.parseInt(e);
		}

		@Override
		public int compareTo(Room o) {
			// TODO Auto-generated method stub
			if(this.s < o.s)
				return -1;
			else if(this.s == o.s) {
				return Integer.compare(this.e, o.e);
			}else
				return 1;
		}
		
	}
}
