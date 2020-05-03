package dp;

//1,2,3 ¥ı«œ±‚ 4
import java.util.*;
import java.io.*;

public class problem_15989 {
	static int array[] = {1,2,3}, N , cache[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		for(int i =0 ; i< N ; i++) {
			int target = Integer.parseInt(br.readLine());
			cache = new int[4][target+1];
			
			for(int c [] : cache)
				Arrays.fill(c, -1);
			
			System.out.println(summation(0,target));
		}
	}
	
	private static int summation(int cur,int remain) {
		if(remain == 0)
			return 1;
		
		if(cache[cur][remain] != -1)
			return cache[cur][remain];
		
		int ret = (cache[cur][remain] == -1 ? 0 : cache[cur][remain]);
		
		for(int i = cur ; i < array.length ; i++) {
			if(array[i] <= remain)
				ret += summation(i,remain - array[i]);
		}
		
		return cache[cur][remain] =ret ; 
	}
}
