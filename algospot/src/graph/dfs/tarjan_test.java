package graph.dfs;

//Ÿ�� �˰��� �׽�Ʈ
import java.util.*;
public class tarjan_test {
	static List<Integer> adj[];
	static int[] discovered, sccId;
	static Stack<Integer> st;
	static int dis_num = 0, scc_num = 0;
	
	public static void main(String[] args) {
		tarjan();
	}
	
	private static void tarjan() {
		adj = new ArrayList[12];
		
		for(int i =0 ; i < adj.length ; i++) adj[i] = new ArrayList<>();
		discovered = new int[12];
		sccId = new int[12];
		
		Arrays.fill(discovered,-1);
		Arrays.fill(sccId, -1);
		
		st = new Stack<>();
		
		init();
		
		for(int i =1 ; i < discovered.length;  i++) {
			if(discovered[i] == -1)
				scc(i);
		}
		
		for(int i =0 ; i < sccId.length ; i++)
			System.out.print(sccId[i] + " " );
		
	}
	private static void init() {
		adj[1].add(2);
		adj[2].add(3);
		adj[3].add(1);
		
		adj[4].add(2);
		adj[4].add(5);
		
		adj[5].add(7);
		adj[7].add(6);
		adj[6].add(5);
		
		adj[8].add(5);
		adj[8].add(9);
		adj[9].add(10);
		adj[10].add(11);
		
		adj[11].add(8);
		adj[11].add(3);
	}
	
	
	private static int scc(int cur) {
		discovered[cur] = dis_num++; //���� ������ �湮 ���� ���
		
		int ret = discovered[cur];
		st.add(cur);
		
		for(int next : adj[cur]) {
			//���� ������ �ľ�.
			if(discovered[next] == -1) {
				//���� ������ ���� �湮���� �ʾ��� ���
				ret = Math.min(ret,scc(next)); //��Ʈ ������ ã�´�.
			}
			else if(sccId[next] == -1) {
				//���� �������� ���ص��� ���� ������ ���
				ret = Math.min(ret, discovered[next]);
			}
		}
		
		//���� DFS spanning tree�� �θ� ������ ���
		if(ret == discovered[cur]) {
			while(!st.isEmpty() && st.peek() != ret) {
				//���ص� ������ ��ȣ�� ���
				sccId[st.pop()] = scc_num;
			}
			++scc_num;
		}
		
		return ret;
	}
}
