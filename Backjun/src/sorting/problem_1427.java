package sorting;

//소트인사이드
import java.util.*;
import java.io.*;

public class problem_1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		String tmp = br.readLine();
		
		for(int i =0 ; i < tmp.length() ; i++) {
			int val = tmp.charAt(i) - '0';
			
			pq.add(val);
		}
		
		
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll());
		}
		
		System.out.println(sb.toString());
	}
}
