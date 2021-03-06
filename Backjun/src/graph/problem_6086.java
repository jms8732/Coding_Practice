package graph;

//최대 유량
import java.util.*;
import java.io.*;

public class problem_6086 {
	static int d[], f[][], c[][];
	static List<Integer> link[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		//대문자, 소문자 구분
		link = new ArrayList[52];
		d = new int[52];
		f = new int[52][52];
		c = new int[52][52];

		for (int i = 0; i < 52; i++)
			link[i] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = convert(st.nextToken().charAt(0));
			int e = convert(st.nextToken().charAt(0));

			int cc = Integer.parseInt(st.nextToken());
			link[s].add(e);
			link[e].add(s);

			//중복된 파이프가 들어올 경우, 양방향이므로
			c[s][e] += cc;
			c[e][s] += cc;
		}

		//A에서 Z까지 
		maxFlow(0, 25);
	}

	private static int convert(char a) {
		if (a >= 'A' && a <= 'Z')
			return a - 'A';
		else
			return a - 'a' + 26;
	}

	private static void maxFlow(int start, int end) {
		int result = 0;
		int INF = 100000000;
		while (true) {
			Arrays.fill(d, -1);
			Queue<Integer> q = new LinkedList<>();
			q.add(start);

			// BFS를 수행하면서 연결된 정점들을 찾는다.
			while (!q.isEmpty()) {
				int cur = q.poll();

				// 현재 연결된 정점을 찾는다.
				for (int next : link[cur]) {
					// 용량 - 유량이 양수이면서 동시에 현재 지점을 방문하지 않았을 경우
					if (c[cur][next] - f[cur][next] > 0 && d[next] == -1) {
						d[next] = cur; // 현재 좌표 저장
						q.add(next);
						if (d[next] == end)
							break;
					}
				}
			}

			// 모든 정점을 방문한 경우
			if (d[end] == -1)
				break;

			int flow = INF;
			for (int i = end; i != start; i = d[i]) {
				flow = Math.min(flow, c[d[i]][i] - f[d[i]][i]);
			}

			for (int i = end; i != start; i = d[i]) {
				f[d[i]][i] += flow;
				f[i][d[i]] -= flow;
			}

			result += flow;
		}

		System.out.println(result);
	}

}
