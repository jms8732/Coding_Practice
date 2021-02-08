package graph;

/*
 * ������ũ����
 * �켱���� ť�� �̿��Ͽ� �����ϸ� �ȴ�
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
