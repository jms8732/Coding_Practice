package scc;

//strongly connected component
import java.util.*;
import java.io.*;

public class problem_2150 {
	static List<Integer> adj[];
	static int[] discovered, sccId;
	static int dis_cnt = 0, scc_cnt = 0;
	static Stack<Integer> stt;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		stt = new Stack<>();

		discovered = new int[N];
		sccId = new int[N];

		Arrays.fill(discovered, -1);
		Arrays.fill(sccId, -1);

		adj = new ArrayList[N];
		for (int i = 0; i < adj.length; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;

			// 방향 그래프
			adj[s].add(e);

		}

		for (int i = 0; i < N; i++) {
			if (discovered[i] == -1) {
				scc(i);
			}
		}

		List<List<Integer>> totalList = new ArrayList<>();
		System.out.println(scc_cnt);
		for (int i = 0; i < scc_cnt; i++) {
			List<Integer> tmp = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				if(i == sccId[j]) {
					tmp.add(j+1);
				}
			}
			tmp.add(-1);
			totalList.add(tmp);
		}
		
		
		totalList.sort(new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> arg0, List<Integer> arg1) {
				// TODO Auto-generated method stub
				if(arg0.get(0) < arg1.get(0))
					return -1;
				else
					return 1;
			}
			
		});
		
		for(List<Integer> tmp : totalList) {
			for(int i : tmp) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	private static int scc(int cur) {
		discovered[cur] = dis_cnt++;
		stt.add(cur);

		int ret = discovered[cur];

		for (int next : adj[cur]) {
			if (discovered[next] == -1) {
				ret = Math.min(ret, scc(next));
			} else if (sccId[next] == -1) {
				ret = Math.min(ret, discovered[next]);
			}
		}

		if (ret == discovered[cur]) {
			while (!stt.isEmpty()) {
				int t = stt.pop();
				sccId[t] = scc_cnt;
				
				if(t == cur)
					break;
			}
			scc_cnt++;
		}

		return ret;
	}
}
