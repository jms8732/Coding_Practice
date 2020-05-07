package dp;

//µ¿Àü 1
import java.util.*;
import java.io.*;

public class problem_2293 {
	static int N , target, array[], cache[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		array=  new int[N];
		cache=  new int[N][target + 1];
		
		for(int i =0 ; i < N ; i++) array[i] = Integer.parseInt(br.readLine());
		
		for(int c[] : cache)
			Arrays.fill(c, -1);
		
		System.out.println(coin(0,target));
	}
	
	private static int coin(int cur, int remain) {
		if(remain == 0)
			return 1;
		
		if(cache[cur][remain] != -1)
			return cache[cur][remain];
		
		int ret = (cache[cur][remain] == -1 ? 0 : cache[cur][remain]);
		
		for(int i =cur ; i < N ; i++) {
			if(array[i] <= remain) {
				ret += coin(i,remain - array[i]);
			}
		}
		
		return cache[cur][remain] = ret;
	}
}
