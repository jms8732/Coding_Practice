package graph;

//¿­Ç÷ °­È£2
import java.util.*;
import java.io.*;

public class problem_11376 {
	static List<Integer> link[];
	static int work [];
	static boolean c [];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		link = new ArrayList[N*2];
		work = new int[M];
		c = new boolean[M];
		
		
		for(int i =0 ; i < N*2 ; i+=2) {
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			
			link[i] = new ArrayList<>();
			link[i+1] = new ArrayList<>();
			
			for(int j =0 ; j < k ; j++) {
				String tmp = st.nextToken();
				link[i].add(Integer.parseInt(tmp)-1);
				link[i+1].add(Integer.parseInt(tmp)-1);
			}
		}
		
		Arrays.fill(work, -1);
		int count = 0 ;
		for(int i= 0 ; i < N*2 ; i++) {
			if(dfs(i))
				count++;
			
			Arrays.fill(c, false);
		}
		
		System.out.println(count);
	}
	
	private static boolean dfs(int cur) {
		for(int w : link[cur]) {
			if(c[w])
				continue;
			c[w] = true;
			
			if(work[w] == -1 || dfs(work[w])) {
				work[w] = cur;
				return true;
			}
		}
		
		return false;
	}
}
