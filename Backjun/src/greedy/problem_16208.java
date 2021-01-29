package greedy;

/*
 * 귀찮음
 * 우선 순위 큐를 이용하여 긴 막대부터 처리한다.
 * 자료형의 범위를 벗어날 수 있으므로 long으로 처리한다.
 */
import java.util.*;
import java.io.*;

public class problem_16208 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long total = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0 ; i < N ; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			pq.add(tmp);
			total += tmp;
		}
		
		long ans = 0;
		while(!pq.isEmpty()) {
			total -= pq.peek();
			ans += total * pq.poll();
		}
		
		System.out.println(ans);
	}

}
