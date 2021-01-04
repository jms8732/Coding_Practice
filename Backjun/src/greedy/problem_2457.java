package greedy;

/*
 * 강의실 배정
 * 그리디 방법으로 문제를 접근
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
		
		PriorityQueue<Integer> used =new PriorityQueue<Integer>(); //강의실 끝나는 시간을 넣는 우선순위 큐
		
	
		while(!pq.isEmpty()) {
			Room current = pq.poll();
			
			if(used.isEmpty()) {
				used.add(current.e);
			}else {
				//현재 강의의 시작 시간이 강의가 끝나는 시간보다 작은 경우, 강의실을 하나 더 추가한다.
				if(used.peek() > current.s) {
					used.add(current.e);
				}else {
					//강의가 끝나는 시간과 현재 강의의 시작 시간이 동일하거나, 이미 강의가 끝났기에 값을 뺀 후, 현재 강의의 끝나는 시간을 추가한다.
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
