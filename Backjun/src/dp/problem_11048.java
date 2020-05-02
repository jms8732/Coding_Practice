package dp;

//이동하기
import java.util.*;
import java.io.*;

public class problem_11048 {
	static int cache[][], N,M, candy[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cache = new int[N][M];
		for(int c[] : cache)
			Arrays.fill(c, -1);
		
		candy = new int[N][M];
		
		for(int i =0 ; i < N ; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j =0 ; j < M ; j++) {
				candy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(candy(0,0));
		System.out.println();
	}
	
	private static int candy(int x,int y) {
		//범위를 벗어나는 경우
		if(x == N || y == M)
			return 0;
		
		if(cache[x][y] != -1)
			return cache[x][y];
		
		//3가지 방향
		int ret = candy[x][y] + candy(x+1,y);
		ret = Math.max(candy[x][y] + candy(x,y+1), ret);
		ret = Math.max(candy[x][y]+ candy(x+1,y+1), ret);
		
		
		return cache[x][y] = ret;
		
	}
}
