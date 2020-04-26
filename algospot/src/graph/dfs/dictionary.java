package graph.dfs;

//고대어 사전
import java.util.*;
import java.io.*;

public class dictionary {
	static List<Integer> adj[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int N = Integer.parseInt(br.readLine());

			adj = new ArrayList[26];

			for (int j = 0; j < adj.length; j++)
				adj[j] = new ArrayList<>();

			String[] tmp = new String[N];
			for (int j = 0; j < N; j++) {
				tmp[j] = br.readLine();
			}

			makeGraph(tmp);
			System.out.println(start());
		}
	}

	private static String start() {
		int[] indegree = new int[26];

		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				indegree[adj[i].get(j)] += 1;
			}
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < indegree.length; i++) {
			if (q.isEmpty())
				break;

			int cur = q.poll();
			sb.append((char) (cur + 'a'));
			for (int next : adj[cur]) {
				indegree[next] -= 1;

				if (indegree[next] == 0)
					q.add(next);
			}
		}

		for (int i = 'a'; i <= 'z'; i++) {
			if (sb.toString().indexOf(i) < 0)
				return "INVALID HYPOTHESIS";
		}

		return sb.toString();
	}

	private static void makeGraph(String[] tmp) {
		for (int i = 1; i < tmp.length; i++) {
			String pre = tmp[i - 1];
			String cur = tmp[i];

			int len = Math.min(pre.length(), cur.length());

			int idx = 0;
			while (idx < len) {
				if (pre.charAt(idx) != cur.charAt(idx)) {
					char pre_char = pre.charAt(idx);
					char cur_char = cur.charAt(idx);

					//해당 값이 존재하지 않는 경우에
					if (!adj[pre_char - 'a'].contains(cur_char - 'a'))
						adj[pre_char - 'a'].add(cur_char - 'a');

					break;
				}
				idx++;
			}

		}
	}
}
