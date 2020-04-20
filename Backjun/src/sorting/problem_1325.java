package sorting;

//효율적인 해킹
import java.util.*;
import java.io.*;

public class problem_1325 {
	static List<Integer> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];

		for (int i = 0; i < N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			list[e - 1].add(s - 1);
		}

		simulation(N);
	}


	private static void simulation(int N) {
		int[] val = new int[N];

		boolean[] visited = new boolean[N];

		for (int i = 0; i < list.length; i++) {
			search(i, val, visited);
			visited = new boolean[N];
		}

		int small= Integer.MAX_VALUE;
		for (int i = 0; i < val.length; i++) {
			small = Math.min(small, val[i]);
		}

		for (int i = 0; i < val.length; i++) {
			if (small == val[i]) {
				System.out.print(i+1 + " ");
			}
		}
	}

	private static void search(int cur, int[] val, boolean[] visited) {
		visited[cur] = true;
		for(int next: list[cur]) {
			if(!visited[next]) {
				search(next,val,visited);
				val[next]++;
			}
		}
	}
}
