package dp;

//내리막 길
import java.util.*;
import java.io.*;

public class problem_1520 {
	static int ud [] = {-1,0,1,0};
	static int [] rl = {0,1,0,-1};
	static int[][] array, cache;
	static int N, M;
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		
		for(int i =0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j =0 ; j < M ; j ++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cache = new int[N][M];
		for(int [] c : cache) {
			Arrays.fill(c, -1);
		}
		
		System.out.println(dp(0,0));
	
	}
	
	private static int dp(int x, int y) {
		if(x == N-1 && y == M-1) {
			return cache[x][y] = 1;
		}
		
		if(cache[x][y] != -1)
			return cache[x][y];
		
		int ret =0;
		for(int i =0 ; i < 4 ; i++) {
			int nx = x + ud[i];
			int ny = y  +rl[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || array[x][y] <= array[nx][ny])
				continue;
			
			ret += dp(nx,ny);
		}
		
		
		return cache[x][y] = ret;
	}
}
