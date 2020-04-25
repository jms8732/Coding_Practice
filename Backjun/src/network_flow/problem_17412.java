package network_flow;

//���� �պ��ϱ� 1

import java.util.*;
import java.io.*;

public class problem_17412 {
	static List<Integer> link[];
	static int d[], f[][], c[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		link = new ArrayList[N];
		for(int i =0 ; i < N ; i++) link[i] = new ArrayList<>();
		
		d = new int[N];
		f = new int[N][N];
		c = new int[N][N];

		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;

			link[s].add(e);
			link[e].add(s);
			// �뷮 �ʱ�ȭ
			c[s][e] = 1;
		}

		maxFlow(0, 1);
	}

	//�÷ο��� ���� ū Ư¡�� ������ �뷮�� �ִٴ� ���̴�.
	private static void maxFlow(int start , int end) {
		int result = 0;
		
		while(true) {
			Queue<Integer> q = new LinkedList<>();
			q.add(start);
			Arrays.fill(d, -1);
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(int next : link[cur]) {
					if(c[cur][next] - f[cur][next] > 0 && d[next] == -1) {
						d[next] = cur;
						q.add(next);
						
						if(d[next] == end)
							break;
					}
				}
			}
			
			if(d[end] == -1)
				break;
			
			int flow = 1;
			for(int i = end ; i !=start ; i = d[i])
				flow = Math.min(flow, c[d[i]][i] - f[d[i]][i]);
			
			for(int i = end ; i != start ; i = d[i]) {
				f[d[i]][i] += flow;
				f[i][d[i]] -= flow;
			}
			
			result += flow;
		}
		
		System.out.println(result);
	}
}
