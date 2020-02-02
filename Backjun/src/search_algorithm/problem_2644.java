package search_algorithm;

//ÃÌ¼ö °è»ê
import java.util.*;
import java.io.*;

public class problem_2644 {
	static List<Integer> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		list = new ArrayList[N];

		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;

		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken()) - 1;
			int v2 = Integer.parseInt(st.nextToken()) - 1;

			list[v1].add(v2);
			list[v2].add(v1);
		}

		bfs(start, end,N);
	}

	private static void bfs(int start, int end, int N) {
		int answer = -1;
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];
		for (int i = 0; i < list[start].size(); i++) {
			queue.add(list[start].get(i));
		}
		visited[start] = true;

		int size= queue.size();
		int step = 1;
		total: while (!queue.isEmpty()) {
			for (int i = 0; i < size; i++) {
				int current = queue.poll();

				if (current == end) {
					answer = step;
					break total;
				}
				if (!visited[current]) {
					visited[current] = true;
					for (int j = 0; j < list[current].size(); j++) {
						queue.add(list[current].get(j));
					}
				}
			}
			size = queue.size();
			step++;
		}

		System.out.println(answer);
	}
}
