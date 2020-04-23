package floyd;

import java.util.*;
import java.io.*;

//바이러스
public class problem_2606 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		
		int [][] floyd  = new int[N][N];
		int INF = 10000000;
		
		for(int [] tmp : floyd) {
			Arrays.fill(tmp, INF);
		}
		
		int M = Integer.parseInt(br.readLine());

		for(int i =0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p1 = Integer.parseInt(st.nextToken())-1;
			int p2 = Integer.parseInt(st.nextToken())-1;
			
			floyd[p1][p2] = 1;
			floyd[p2][p1] =1;
		}
		
		for(int i =0 ; i< N  ;i++) {
			for(int j =0 ; j < N ; j++) {
				for(int k =0 ; k < N ; k++) {
					if(floyd[j][k] > floyd[j][i] + floyd[i][k]) {
						floyd[j][k] = Math.min(floyd[i][k], floyd[j][j] + floyd[i][k]);
					}	
				}
			}
		}
		
		int ans =0 ;
		for(int i =1 ; i < N ; i++) {
			if(floyd[0][i] != INF || floyd[i][0] != INF)
				ans ++;
		}
		
		System.out.println(ans);
		
	}
}
