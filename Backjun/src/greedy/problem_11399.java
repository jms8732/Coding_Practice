package greedy;

//ATM
import java.util.*;
import java.io.*;

public class problem_11399 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i =0 ; i <N ; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		int result = 0;
		int prev = 0;
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			cur += prev;
			result += cur;
			
			prev = cur;
		}
		
		System.out.println(result);
	}
}
