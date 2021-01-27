package greedy;

/*
 * 사탕
 * 우선 순위 큐를 이용하여 R*C의 값을 내림차순으로 정렬한다.
 * 정렬된 값을 하나씩 빼 오면서 캔디가 0이 될때까지 박스 수를 누적한다.
 * 
 */
import java.util.*;
import java.io.*;

public class problem_11256 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int candy = Integer.parseInt(st.nextToken());
			int boxes = Integer.parseInt(st.nextToken());

			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			for (int j = 0; j < boxes; j++) {
				st = new StringTokenizer(br.readLine());
				int R = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				
				pq.add(R*C);
			}
			
			int count = 0;
			while(!pq.isEmpty() && candy > 0) {
				candy -= pq.poll();
				count++;
			}
			
			System.out.println(count);
		}
	}
}
