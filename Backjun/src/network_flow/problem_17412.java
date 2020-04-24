package network_flow;

//도시 왕복하기 1

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
			// 용량 초기화
			c[s][e] = 1;
		}

		maxFlow(0, 1);
	}

	//플로우의 가장 큰 특징은 간선의 용량이 있다는 점이다.
	private static void maxFlow(int start , int end) {
		int result = 0;
		int INF = 10000000;
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
			
			int flow = INF;
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
