package graph.dfs;

import java.util.*;

//단어 제한 끝말잇기

import java.io.*;

public class wordchain {
	static List<Integer> adj[];
	static int indegree[], outdegree[];
	static List<String> graph[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int N = Integer.parseInt(br.readLine());

			String[] tmp = new String[N];

			for (int j = 0; j < N; j++) {
				tmp[j] = br.readLine();
			}

			adj = new ArrayList[26];
			graph = new ArrayList[26][26];

			// 초기화
			for (int j = 0; j < adj.length; j++)
				adj[j] = new ArrayList<>();

			for (int j = 0; j < graph.length; j++) {
				for (int k = 0; k < graph[j].length; k++)
					graph[j][k] = new ArrayList<>();
			}

			indegree = new int[26];
			outdegree = new int[26];

			makeGraph(tmp);

			if (!checkEuler())
				System.out.println("IMPOSSIBLE");
			else {
				List<Integer> val = EulerCircuitOrEulerTrail();
				if (val.size() - 1 != tmp.length)
					System.out.println("IMPOSSIBLE");
				else {
					Collections.reverse(val);

					for (int j = 1; j < val.size(); j++) {
						int s = val.get(j - 1);
						int e = val.get(j);
						
						System.out.print(graph[s][e].get(0) + " ");
						graph[s][e].remove(0);
					}
					System.out.println();
				}
				
			}
		}
	}

	private static List<Integer> EulerCircuitOrEulerTrail() {
		List<Integer> val = new ArrayList<>();

		/*
		 * 오일러 트레일 확인 오일러 트레일을 오일러 서킷처럼 생각하여 한 정점에서 나가는 간선이 들어오는 간선 +1 인 경우, 오일러 서킷이 된다.
		 */
		for (int i = 0; i < 26; i++) {
			if (outdegree[i] == indegree[i] + 1) {
				getEulerCircuit(i, val);
				return val;
			}
		}

		// 오일러 서킷
		for (int i = 0; i < 26; i++) {
			if (outdegree[i] > 0) {
				getEulerCircuit(i, val);
				return val;
			}
		}

		return val;
	}

	private static void getEulerCircuit(int cur, List<Integer> val) {
		for (int i = 0; i < adj[cur].size(); i++) {
			while (!adj[cur].isEmpty()) {
				int next = adj[cur].get(i);
				adj[cur].remove(0);
				getEulerCircuit(next, val);
			}
		}

		val.add(cur);
	}

	private static void makeGraph(String[] tmp) {
		for (int i = 0; i < tmp.length; i++) {
			String cur = tmp[i];

			char cur_first = cur.charAt(0);
			char cur_last = cur.charAt(cur.length() - 1);

			adj[cur_first - 'a'].add(cur_last - 'a');
			outdegree[cur_first - 'a'] += 1;
			indegree[cur_last - 'a'] += 1;
			graph[cur_first - 'a'][cur_last - 'a'].add(cur);

		}
	}

	/*
	 * 방향성 그래프에서 오일러 서킷인 경우, 한 정점에서 들어오는 간선의 수만큼 나가는 간선이 필요하다. 오일러 트레일 경우, 나가는 간선이
	 * 한개 더 많은 시작점 한 개와 들어오는 간선이 한 개 더 많은 도착점이 한 개 있어야한다.
	 */
	private static boolean checkEuler() {
		int start = 0, end = 0;
		for (int i = 0; i < 26; i++) {
			int diff = outdegree[i] - indegree[i];

			if (diff < -1 || diff > 1)
				return false;

			if (diff == -1)
				end++;
			else if (diff == 1)
				start++;

		}

		return (start == 1 && end == 1) || (start == 0 && end == 0);
	}

}
