package sorting;

//수 정렬하기2
import java.util.*;
import java.io.*;

public class problem_2751 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer>pq = new PriorityQueue<Integer>();
		
		for(int i= 0 ; i <N ; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
