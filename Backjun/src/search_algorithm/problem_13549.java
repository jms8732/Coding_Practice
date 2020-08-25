package search_algorithm;

//숨바꼭질 3
import java.util.*;
import java.io.*;

public class problem_13549 {
	static int[] side = { -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[100001];

		Queue<Subin> pq = new LinkedList<>();
		pq.add(new Subin(0, N));

		int answer = 0;
		while (!pq.isEmpty()) {
			Subin cur = pq.poll();

			visited[cur.index] = true;
			if (cur.index == K) {
				answer = cur.time;
				break;
			}

			//순간이동 
			int nx = cur.index*2;
			if(nx >=  0 && nx < visited.length && !visited[nx]) {
				visited[nx] = true;
				pq.add(new Subin(cur.time,nx));
			}
			
			for(int i =0 ; i < side.length ; i++) {
				nx = cur.index + side[i];
				
				if(nx < 0 || nx >= visited.length || visited[nx])
					continue;
				
				visited[nx] = true;
				pq.add(new Subin(cur.time+1,nx));
			}
		}
		
		System.out.println(answer);
	}

	private static class Subin {
		int time, index;

		public Subin(int t, int i) {
			this.time = t;
			this.index = i;
		}

	}
}
