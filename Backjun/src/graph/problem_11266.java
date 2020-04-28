package graph;

//´ÜÀýÁ¡
import java.util.*;
import java.io.*;

public class problem_11266 {
	static List<Integer> adj [];
	static int dis_cnt =0 ;
	static int[] discovered;
	static boolean [] isCutVertex;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		discovered = new int [N];
		isCutVertex = new boolean[N];
		
		adj = new ArrayList[N];
		
		for(int i =0 ; i < adj.length ; i++) adj[i] = new ArrayList<>();
		
		for(int i =0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			
			adj[s].add(e);
			adj[e].add(s);
		}
		

		List<Integer> list = new ArrayList<>();
		Arrays.fill(discovered,-1);
		
		for(int i =0 ; i <discovered.length ; i ++) {
			if(discovered[i] == -1)
				findCutVertex(i,true);
		}
		
		for(int i= 0 ; i < N ; i++)
			if(isCutVertex[i])
				list.add(i+1);
		
		System.out.println(list.size());
		for(int i : list)
			System.out.print(i + " ");
	}
	
	private static int findCutVertex(int cur, boolean isRoot) {
		discovered[cur] = dis_cnt++;
		int ret = discovered[cur];
		int children = 0;
		
		for(int next : adj[cur]) {
			if(discovered[next] == -1) {
				++children;
				int subtree = findCutVertex(next,false);
				
				if(!isRoot && subtree >= discovered[cur])
					isCutVertex[cur] = true;
				
				ret = Math.min(ret, subtree);
			}else
				ret = Math.min(ret, discovered[next]);
		}
		
		if(isRoot) isCutVertex[cur] = (children >= 2);
		
		return ret;
		
	}
}
