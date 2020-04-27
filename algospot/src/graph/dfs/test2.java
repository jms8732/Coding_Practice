package graph.dfs;

//무방향 그래프에서 절단점 찾기

import java.util.*;

public class test2 {
	static List<Integer> adj[];
	static int[] discovered;
	static int count; // 순서를 나타내기 위한 변수
	static boolean[] isCutVertex;

	public static void main(String[] args) {
		adj = new ArrayList[8];
		for (int i = 0; i < adj.length; i++)
			adj[i] = new ArrayList<>();

		discovered = new int[8];
		Arrays.fill(discovered, -1);
		isCutVertex = new boolean[8];

		init();

		/*
		 * for (int i = 0; i < 8; i++) { findCutVertex(i,true); Arrays.fill(discovered,
		 * -1); }
		 */
		
		Arrays.fill(discovered, -1);
		findCutVertex(0,true);
		
		for(boolean t : isCutVertex)
			System.out.print(t + " ");
	}

	/*
	 * 절단점 찾기 
	 * 역방향 간선을 이용해서 찾는다. 역방향 간선은 현재 정점의 방문 순서와 다음 정점의 방문 순서를 비교해서 찾는다.
	 */
	private static int findCutVertex(int cur , boolean isRoot) {
		discovered[cur] = count++; //현재 방문 순서
		int ret = discovered[cur]; //현재 방문 순서
		
		int children = 0;
		for(int next : adj[cur]) {
			if(discovered[next] == -1) {
				//아직 방문하지 않은 노드인 경우
				++children; //자식 개수
				int subtree = findCutVertex(next,false);
				
				if(!isRoot && subtree >= discovered[cur]) {
					isCutVertex[cur] = true;
				}
				
				ret = Math.min(ret, subtree);
			}else
				ret = Math.min(ret, discovered[next]); //역방향 간선을 이용해서 서브 트리의 루트 노드를 찾는다.
			
		}
		
		if(isRoot) isCutVertex[cur] = (children >= 2) ; //자식 개수가 2개 이상인 경우 true값 할당.
		
		return ret;
	}
	
	private static void init() {
		adj[0].add(1);
		adj[1].add(0);

		adj[1].add(2);
		adj[2].add(1);

		adj[1].add(3);
		adj[3].add(1);

		adj[2].add(3);
		adj[3].add(2);

		adj[2].add(5);
		adj[5].add(2);

		adj[3].add(5);
		adj[5].add(3);

		adj[3].add(4);
		adj[4].add(3);

		adj[5].add(6);
		adj[6].add(5);

		adj[5].add(7);
		adj[7].add(5);

	}
}
