package graph;

//Æ®¸®
import java.util.*;
import java.io.*;

public class problem_1068 {
	static List<Integer> parent[];
	static int child = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		parent = new ArrayList[N];
		for (int i = 0; i < parent.length; i++)
			parent[i] = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int delete = Integer.parseInt(br.readLine());
		int root = 0;

		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());

			if (p == -1 || i == delete || p == delete) {
				if (p == -1)
					root = i;
				continue;
			}

			parent[p].add(i);
		}
		if (delete != root)
			leafNode(root);
		System.out.println(child);
	}

	private static void leafNode(int p) {
		if (parent[p].isEmpty()) {
			child++;
			return;
		}

		for (int child : parent[p]) {
			leafNode(child);
		}
	}
}
