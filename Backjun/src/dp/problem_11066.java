package dp;

//파일 합치기
import java.util.*;
import java.io.*;

public class problem_11066 {
	static int array[], k, INF = Integer.MAX_VALUE;
	static boolean [] chapter;
	static int [][] cache;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		
		for(int i =0 ; i < tc ; i++) {
			k = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			array=  new int[k];
			chapter = new boolean[k];
			
			for(int j = 0 ; j < k ; j++) array[j] = Integer.parseInt(st.nextToken());
			
			
			
		}
	}
	
	private static int cost(int remain, int cur) {
		if(remain == 0)
			return 0;
		
		if(cache[remain][cur] != -1)
			return cache[remain][cur];
		
		int ret = (cache[remain][cur] == -1 ? INF : cache[remain][cur]);
		
		for(int i = 0; i < k ; i++) {
			if(!chapter[i]) {
				chapter[i] = true;
				ret = Math.min(ret, cost(remain-1,i) )
			}
		}
	}
}
