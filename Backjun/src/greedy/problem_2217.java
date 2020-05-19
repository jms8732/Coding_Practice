package greedy;

//ทฮวม
import java.util.*;
import java.io.*;

public class problem_2217 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
		int N = Integer.parseInt(br.readLine());
		
		for(int i= 0 ; i < N; i ++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int answer = 0;
		while(!pq.isEmpty()) {
			int n = pq.size();
			int cur = pq.poll();
			
			answer = Math.max(Math.max(cur, answer), n*cur);
		}
		
		System.out.println(answer);
	}
	
}
