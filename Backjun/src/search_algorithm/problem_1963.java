package search_algorithm;

//소수 경로
import java.util.*;
import java.io.*;

public class problem_1963 {
	static Set<Integer> prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		prime = new LinkedHashSet<>();

		// 에라토스테네스 체
		boolean[] visited = new boolean[10000];
		for (int i = 2; i < 10000; i++) {
			if (!visited[i]) {
				visited[i] = true;
				prime.add(i);
				for (int j = i; j < 10000; j += i) {
					visited[j] = true;
				}
			}
		}

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			convert(A, B);
		}
	}

	private static void convert(int A, int B) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[10000];

		q.add(new Node(A, 0));
		visited[A] = true;

		int answer = 0;
		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.val == B) {
				answer = cur.count;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int p = (int) Math.pow(10, 3 - i);

				int div = cur.val / p;
				int c = cur.val - (div % 10) * p;
				for (int j = 0; j <= 9; j++) {
					int tmp = c;
					tmp += j * p;

					if (tmp >= 1000 && tmp <= 10000 && !visited[tmp] && prime.contains(tmp)) {
						visited[tmp] = true;
						q.add(new Node(tmp, cur.count + 1));
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static class Node {
		int val, count;

		public Node(int v, int c) {
			this.val = v;
			this.count = c;
		}
	}
}
