package graph;

/*
 * �۾�
 * �ּ��� �ð��� ���ϴ� ���� �����̴�.
 * �ܼ���, �������ķ� ������ ��, ���а� ���. �ݵ��, �ð��� ������� �������� ������ �����ؾ��Ѵ�.
 */
import java.util.*;
import java.io.*;

public class problem_2056 {
	static List<Integer>[] adj;
	static int[] time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		time = new int[n];

		adj = new ArrayList[n];

		for (int i = 0; i < n; i++)
			adj[i] = new ArrayList<>();

		StringTokenizer st = null;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int t = Integer.parseInt(st.nextToken());
			time[i] = t;

			int m = Integer.parseInt(st.nextToken());

			for (int j = 0; j < m; j++) {
				int temp = Integer.parseInt(st.nextToken()) - 1;

				adj[temp].add(i);

			}
		}

		findMinTime(n);
	}

	private static void findMinTime(int n) {
		int[] degree = new int[n];

		for (int i = 0; i < degree.length; i++) {
			for (int j : adj[i])
				degree[j]++;
		}

		PriorityQueue<Node> q = new PriorityQueue<>(); //�ð��� ������� �������� ������ ����
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0)
				q.add(new Node(time[i],i));
		}

		int ans =0 ;
		for (int i = 0; i < n; i++) {
			if (q.isEmpty())
				break;

			Node cur = q.poll();
			ans = Math.max(ans, cur.time);
			for (int j : adj[cur.num]) {
				degree[j]--;

				if (degree[j] == 0) {
					q.add(new Node(time[j] + cur.time,j));
				}
			}

		}		
		System.out.println(ans);
	}
	
	private static class Node implements Comparable<Node>{
		int time, num;
		
		public Node(int t , int n) {
			this.time = t;
			this.num = n;
		}

		@Override
		public int compareTo(Node arg0) {
			// TODO Auto-generated method stub
			return Integer.compare(this.time,arg0.time);
		}
		
		
	}
}
