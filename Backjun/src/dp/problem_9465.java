package dp;

/*
 * 스티커
 * 스티커를 떼는 경우, 안 떼는 경우 두가지를 고려해서 DP를 진행한다.
 */
import java.io.*;
import java.util.*;

public class problem_9465 {
	static int [][]cache, array;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i =0 ; i < tc ; i++) {
			int n = Integer.parseInt(br.readLine());
			
			StringTokenizer st =null;
			array = new int[2][n];
			for(int j =0 ; j < 2 ; j++) {
				st= new StringTokenizer(br.readLine());
				
				for(int k =0 ; k < n ; k++) {
					array[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			cache = new int[2][n];
			
			for(int [] c : cache)
				Arrays.fill(c, -1);
			
			System.out.println(Math.max(dp(0,0), dp(1,0)));
		}
	}
	
	private static int dp(int x, int y) {
		if(y == array[x].length)
			return 0;
		
		if(cache[x][y] != -1)
			return cache[x][y];
		
		int ret =0;
		
		//현재 스티커를 떄는 경우
		ret = dp((x+1)%2, y+1) + array[x][y];
		
		//안 때는 경우
		ret = Math.max(dp(x,y+1),ret);
		
		return cache[x][y] = ret;
	}
}