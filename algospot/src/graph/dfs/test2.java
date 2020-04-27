package graph.dfs;

//������ �׷������� ������ ã��

import java.util.*;

public class test2 {
	static List<Integer> adj[];
	static int[] discovered;
	static int count; // ������ ��Ÿ���� ���� ����
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
	 * ������ ã�� 
	 * ������ ������ �̿��ؼ� ã�´�. ������ ������ ���� ������ �湮 ������ ���� ������ �湮 ������ ���ؼ� ã�´�.
	 */
	private static int findCutVertex(int cur , boolean isRoot) {
		discovered[cur] = count++; //���� �湮 ����
		int ret = discovered[cur]; //���� �湮 ����
		
		int children = 0;
		for(int next : adj[cur]) {
			if(discovered[next] == -1) {
				//���� �湮���� ���� ����� ���
				++children; //�ڽ� ����
				int subtree = findCutVertex(next,false);
				
				if(!isRoot && subtree >= discovered[cur]) {
					isCutVertex[cur] = true;
				}
				
				ret = Math.min(ret, subtree);
			}else
				ret = Math.min(ret, discovered[next]); //������ ������ �̿��ؼ� ���� Ʈ���� ��Ʈ ��带 ã�´�.
			
		}
		
		if(isRoot) isCutVertex[cur] = (children >= 2) ; //�ڽ� ������ 2�� �̻��� ��� true�� �Ҵ�.
		
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
