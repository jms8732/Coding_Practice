package graph;

/*
 * 학회원
 * Union Find 문제로 접근하면 쉽게 해결할 수 있다.
 */
import java.util.*;
import java.io.*;

public class problem_3865 {
	static List<String> adj;
	static int [] parent; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			Map<String, Set<String>> map = new HashMap<>();
			Set<String> temp = new LinkedHashSet<>(); // 넘버링을 하기 위한 집합
			for (int i = 0; i < n; i++) {
				String[] split = br.readLine().split(":");
				String key = split[0];
				temp.add(key);
				Set<String> val = makeValue(temp, split[1]);

				map.put(key, val);
			}

			unionFind(temp, map);
			map = null;
			temp = null;
		}

		br.close();
	}

	private static void unionFind(Set<String> total, Map<String, Set<String>> map) {
		adj = new ArrayList<>(total);
		parent = new int[adj.size()];
		
		for(int i =0 ; i < parent.length ; i++)
			parent[i] = i;
		
		Queue<String> q = new LinkedList<>();
		q.add(adj.get(0));

		int ans= 0;
		while(!q.isEmpty()) {
			String cur = q.poll();
			
			for(String val : map.get(cur)) {
				if(union(val,cur)) {
					if(map.containsKey(val)) {
						//학회 인 경우
						q.add(val);
					}else
						ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	private static boolean union(String c1, String c2) {
		int p1 = find(adj.indexOf(c1));
		int p2 = find(adj.indexOf(c2));
		
		if(p1 == p2)
			return false;
		
		if(p1 < p2)
			parent[p2] = p1;
		else
			parent[p1] = p2;
		
		return true;
	}
	
	private static int find(int p1) {
		if(p1 == parent[p1])
			return p1;
		else
			return find(parent[p1]);
	}

	private static Set<String> makeValue(Set<String> temp, String split) {
		split = split.replace(".", "");
		Set<String> ret = new HashSet<>();

		String[] tmp = split.split(",");

		for (int i = 0; i < tmp.length; i++) {
			temp.add(tmp[i]);
			ret.add(tmp[i]);
		}

		return ret;
	}
}
