package programmers2;

import java.util.*;
import java.io.*;

public class test2 {
	static List<Integer> link[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] in = new int[N];
		link = new ArrayList[N];

		for (int i = 0; i < N; i++)
			link[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;

			link[s].add(e);
		}

		for (int i = 0; i < link.length; i++) {
			for (int j = 0; j < link[i].size(); j++) {
				in[link[i].get(j)] += 1;
			}
		}

		sort(in);
	}

	private static void sort(int[] in) {
		Queue<Integer> start = new LinkedList<>();

		for (int i = 0; i < in.length; i++) {
			if (in[i] == 0)
				start.add(i);
		}

		for (int i = 0; i < in.length; i++) {
			if (start.isEmpty())
				break;

			int cur = start.poll();
			System.out.print(cur+1 + " ");
			for (int next : link[cur]) {
				in[next] -= 1;
				if (in[next] == 0)
					start.add(next);
			}
		}

	}

	private static class student {
		int s, e;

		public student(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
}
