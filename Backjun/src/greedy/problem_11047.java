package greedy;

//µ¿Àü 0
import java.util.*;
import java.io.*;

public class problem_11047 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int value = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int i =0 ; i< N ; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int count = 0;
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			
			if(value == 0)
				break;
			
			int c = value / cur;
			count += c;
			
			value = value - cur *c;
		}
		
		System.out.println(count);
	}
}
