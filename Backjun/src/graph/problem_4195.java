package graph;

/*
 * 친구 네트워크
 * Union-find 문제
 * 
 */
import java.util.*;
import java.io.*;

public class problem_4195 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			
			//map을 이용하여 사람 이름에 대한 인덱싱을 한다.
			HashMap<String, Integer> map = new HashMap<>();
			Queue<friendship> q = new LinkedList<>();

			int idx = 0; // 사람 번호

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();

				int f1 = 0, f2 = 0;
				if (map.containsKey(name1)) {
					// 현재 이름을 포함하고 있으면
					f1 = map.get(name1);
				} else {
					// 없다면
					f1 = idx;
					map.put(name1, idx++);
				}

				if (map.containsKey(name2)) {
					f2 = map.get(name2);
				} else {
					f2 = idx;
					map.put(name2, idx++);
				}

				q.add(new friendship(f1, f2));
			}

			union_find(q, idx);
			map = null;
			q = null;
		}

	}

	private static void union_find(Queue<friendship> q, int n) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int parent[] = new int[n];

		// 초기화
		for (int i = 0; i < parent.length; i++)
			parent[i] = i;

		while (!q.isEmpty()) {
			friendship cur = q.poll();

			if (union(cur.f1, cur.f2,parent)) {
				/*
				 * 예제 2와 같이, f1과 f2가 이전에 맺은 친구들에게도 영향을 줘야하기 때문에 친구 번호를 갱신
				 */
				for(int i =0 ; i < parent.length;  i++)
					parent[i] = find(i,parent);
			}

			//연결된 친구들의 수를 계산
			int p= parent[cur.f1];
			int count = 0;
			for(int i =0 ; i < parent.length ; i++) {
				if(p == parent[i])
					count++;
			}
			
			bw.write(count + "\n");
		}
		bw.flush();

	}

	//union-find
	private static boolean union(int c1, int c2, int[] parent) {
		int p1 = find(c1, parent);
		int p2 = find(c2, parent);

		if (p1 == p2)
			return false;

		if (p1 < p2)
			parent[p2] = p1;
		else
			parent[p1] = p2;

		return true;
	}

	private static int find(int c, int[] parent) {
		if (c == parent[c])
			return c;
		else
			return parent[c] = find(parent[c], parent);
	}

	//서로 친구임을 나타내는 클래스
	private static class friendship {
		int f1, f2;

		public friendship(int f1, int f2) {
			this.f1 = f1;
			this.f2 = f2;
		}
	}
}
