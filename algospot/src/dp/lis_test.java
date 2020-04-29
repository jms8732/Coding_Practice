package dp;

import java.util.Arrays;

//증가하는 부분 수열

public class lis_test {
	static int cache[], target[];
	
	
	public static void main(String[] args) {
		cache = new int[5];
		target = new int[5];
		
		Arrays.fill(cache, -1);
		target[0] = 10;
		target[1] = 20;
		target[2] = 30;
		target[3] = 1;
		target[4] = 2;
		
		System.out.println(lis(0));
		
	}
	
	public static int lis(int start) {
		if(cache[start] != -1)
			return cache[start];
		
		int ret = 1;
		
		
		for(int next = start+1 ; next < cache.length ; next++) {
			if(target[start] < target[next])
				ret = cache[start] =  Math.max(ret, lis(next)+1);
		}
		
		return cache[start] = ret;
	}
}
