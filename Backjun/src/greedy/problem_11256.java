package greedy;

/*
 * ����
 * �켱 ���� ť�� �̿��Ͽ� R*C�� ���� ������������ �����Ѵ�.
 * ���ĵ� ���� �ϳ��� �� ���鼭 ĵ�� 0�� �ɶ����� �ڽ� ���� �����Ѵ�.
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
