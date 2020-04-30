package dp;

//비대칭 타일링
import java.util.*;
import java.io.*;

public class asymtiling {
	static int cache[], cache2[] ;
	static int MOD = 1000000007;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i =0 ; i < tc ; i++) {
			int N = Integer.parseInt(br.readLine());
			cache = new int[N+1];
			cache2 = new int[N+1];
			
			Arrays.fill(cache, -1);
			Arrays.fill(cache2, -1);
			
			System.out.println(asymmetic(N));
			
		}
	}
	
	private static int asymmetic(int width) {
		if(width <= 2)
			return 0;
		
		if(cache2[width] != -1)
			return cache2[width];
		
		cache2[width] = asymmetic(width - 2) % MOD;
		cache2[width] = (cache2[width] + asymmetic(width - 4)) % MOD;
		cache2[width] = (cache2[width] + tiling(width - 3)) % MOD;
		cache2[width] = (cache2[width] + tiling(width- 3)) %MOD;
		
		return cache2[width];
		
	}
	
	private static int tiling(int width) {
		if(width <= 1)
			return 1;
		
		if(cache[width] != -1)
			return cache[width];
		
		return cache[width] = (tiling(width-1)+ tiling(width- 2)) % MOD;
		
	}
}
