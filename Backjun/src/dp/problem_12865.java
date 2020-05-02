package dp;

//평범한 배낭
import java.util.*;
import java.io.*;

public class problem_12865 {
	static int val[], weight[], N;
	static int cache[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int tw = Integer.parseInt(st.nextToken());
		
		val = new int[N];
		weight = new int[N];
		
		cache = new int[N+1][tw+1];
		
		for(int c [] : cache)
			Arrays.fill(c, -1);
		
		for(int i =0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			val[i] = v;
			weight[i] = w;
		}
		
		System.out.println(pack(0,tw));
	}
	
	/*
	 * 준서가 할 수 있는 일은 현재 물건을 선택하냐 안하냐에 따라 달라진다.
	 */
	private static int pack(int cur , int capacity) {
		
		//다 탐색한 경우
		if(cur == N)
			return 0;
		
		if(cache[cur][capacity] != -1)
			return cache[cur][capacity];
		
		//현재 물건을 선택하지 않은 경우
		int ret = pack(cur+1,capacity);
		
		//물건을 선택한 경우
		if(weight[cur] <= capacity)
			ret = Math.max(ret, pack(cur+1,capacity- weight[cur])+val[cur]);
		
		
		return cache[cur][capacity] = ret;
	}
}
