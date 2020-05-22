package dp;

//계단 오르기
import java.util.*;
import java.io.*;

public class problem_2579 {
	static int cache[][], stair[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		cache = new int[N][2];
		
		for(int[] c : cache)
			Arrays.fill(c, -1);
		
		stair = new int[N];

		for(int i =0 ; i < N ; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(dp(N-1,0));
	}
	
	private static int dp(int cur,int count) {
		if(cur < 0)
			return 0;
		
		if(cache[cur][count]!= -1)
			return cache[cur][count];
		
		int ret = 0;
		
		if(count < 1)
			ret = Math.max(ret,dp(cur-1,count+1) + stair[cur]);
		
		ret = Math.max(ret,dp(cur-2,0)+ stair[cur]);
		
		return cache[cur][count] = ret;
	}
}
