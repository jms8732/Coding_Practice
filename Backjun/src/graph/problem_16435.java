package graph;

/*
 * 스네이크버드
 * 우선순위 큐를 이용하여 진행하면 된다
 */
import java.util.*;
import java.io.*;

public class problem_16435 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i= 0 ; i < N ; i++) {
			pq.add(Integer.parseInt(st.nextToken()));
		}
		
		while(!pq.isEmpty()) {
			if(pq.poll() <= K)
				K++;
		}
		
		System.out.println(K);
	}
}
