package combination;

import java.util.*;
import java.io.*;

//N과 M (9)
public class problem_15663 {
	static Set<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		set = new HashSet<>();
		int[] value = new int[N];
		boolean[] visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			value[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(value); // 오름차순 정렬
		int depth = 0;
		StringBuilder sb = new StringBuilder();
		permutation(depth, 0, M, value,visited, sb);
	}

	private static void permutation(int depth, int next, int M, int[] value, boolean[] visited, StringBuilder sb) {
		if (depth == M) {
			if (!set.contains(sb.toString().trim())) {
				// 이전 값과 동일하지 않을 경우
				print(sb.toString());
				set.add(sb.toString().trim());
			}
		}

		for (int i = 0; i < value.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				String tmp = Integer.toString(value[i]);
				sb.append(tmp + " ");
				permutation(depth + 1, i + 1, M, value,visited, sb);
				sb.delete(sb.length() - tmp.length() - 1, sb.length());
				visited[i] = false;
			}

		}
	}

	private static void print(String s) {
		System.out.println(s);
	}
}
