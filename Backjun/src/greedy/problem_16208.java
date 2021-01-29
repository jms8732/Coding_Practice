package greedy;

/*
 * ������
 * �켱 ���� ť�� �̿��Ͽ� �� ������� ó���Ѵ�.
 * �ڷ����� ������ ��� �� �����Ƿ� long���� ó���Ѵ�.
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
