package floyd;

//를로이드

import java.util.*;
import java.io.*;
public class problem_11404 {
	static BufferedReader br;
	static int N,M;
	static int INF = 100000000;
	public static void main(String[] args) {
		br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int[][] tmp = floyd();
			br.close();
			
			for(int [] i : tmp)
			{
				for(int j =0 ; j< i.length ; j++) {
					System.out.print(i[j] + " ");
				}
				System.out.println();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	private static int [][] floyd() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int [][] map = new int[N][N];
		for(int [] t : map) {
			Arrays.fill(t, INF);
		}
		for(int i =0 ; i  < M ; i++) {
			st = new StringTokenizer(br.readLine()); 
			int s = Integer.parseInt(st.nextToken()) -1;
			int e = Integer.parseInt(st.nextToken()) -1;
			int w = Integer.parseInt(st.nextToken());
			
			map[s][e] = Math.min(map[s][e], w);
		}
		
		for(int i =0 ; i < N ;i++)
			map[i][i] = 0; //자기자신은 0
		
		//플로이드 와샬 알고리즘
		for(int i =0 ; i< N ; i++) {
			for(int k = 0; k < N ; k++) {
				for(int j = 0 ; j < N; j++) {
					if(map[k][j] > map[k][i] + map[i][j])
						map[k][j] = map[k][i] + map[i][j];
				}
			}
		}
		
		for(int i =0 ; i< N ; i++) {
			for(int j =0 ; j < N ; j++) {
				if(map[i][j] == INF)
					map[i][j] = 0;
			}
		}
		return map;
	}
}
