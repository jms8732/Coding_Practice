package samsung;

import java.util.*;


public class test2 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		queue.add(5);
		queue.add(1);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(queue);
		
		while(!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
	}
}
