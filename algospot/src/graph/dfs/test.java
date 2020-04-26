package graph.dfs;

//������, ������, ���� ���� �׽�Ʈ

import java.util.*;

public class test {
	static List<Integer> adj [];
	static int count =0 ; //�湮 ������ ǥ���ϱ� ���� ����
	static int [] discovered, finish;
	
	public static void main(String[] args) {
		adj = new ArrayList[4];
		
		for(int i = 0 ; i < 4 ; i++) adj[i] = new ArrayList<>();
		
		init();
		discovered = new int[4];
		Arrays.fill(discovered, -1);
		finish = new int[4];
		
		dfs(0);
	}
	
	private static void dfs(int cur) {
		discovered[cur] = count; //���� �湮 ����
		
		//���� ������ ����� ������ Ȯ��
		for(int next : adj[cur]) {
			//���� �湮���� ���� ������ �߰ߵ� ���
			if(discovered[next] == -1) {
				System.out.println("tree edge : " + cur + " --> " + next);
				count++; //������ �ø� ��,
				dfs(next); //dfs ����
			}else {
				/*
				 * ���� ������ �湮���� ���.
				 * 1. ���� ������ ���� ������ �湮 ������ �ľ��Ѵ�.
				 * 2. ���� �������� ���� ������ ������ ū ���, �������̴�.
				 * 3. ���� ������ ���� ������� ���� ��O(dfs�� ������� ���� ����)�̸� ���� ������ ������ ���� �������� ���� ���, �������̴�.
				 * 4. 2��, 3�� ��Ȳ�� �ƴ� ���, ���� �����̴�. 
				 */
				if(discovered[cur] < discovered[next]) {
					System.out.println("forward edge : " + cur + " --> " + next);
				}else {
					if(finish[next] == 1)
						System.out.println("cross edge : " + cur + " --> " + next);
					else
						System.out.println("back edge : " + cur + " --> " + next);
						
				}
			}
		}
		
		finish[cur] = 1; //���� ���� ����
	}
	
	private static void init() {
		adj[0].add(1);
		adj[0].add(3);
		adj[0].add(2);
		
		adj[1].add(2);
		
		adj[2].add(1);
		adj[3].add(1);
		adj[3].add(2);
		
	}
}
