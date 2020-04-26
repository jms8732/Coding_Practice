package graph.dfs;

import java.util.*;

//�ܾ� ���� �����ձ�

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

			// �ʱ�ȭ
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
		 * ���Ϸ� Ʈ���� Ȯ�� ���Ϸ� Ʈ������ ���Ϸ� ��Ŷó�� �����Ͽ� �� �������� ������ ������ ������ ���� +1 �� ���, ���Ϸ� ��Ŷ�� �ȴ�.
		 */
		for (int i = 0; i < 26; i++) {
			if (outdegree[i] == indegree[i] + 1) {
				getEulerCircuit(i, val);
				return val;
			}
		}

		// ���Ϸ� ��Ŷ
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
	 * ���⼺ �׷������� ���Ϸ� ��Ŷ�� ���, �� �������� ������ ������ ����ŭ ������ ������ �ʿ��ϴ�. ���Ϸ� Ʈ���� ���, ������ ������
	 * �Ѱ� �� ���� ������ �� ���� ������ ������ �� �� �� ���� �������� �� �� �־���Ѵ�.
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
