package combination;

//1ÇÐ³â
import java.util.*;
import java.io.*;

public class problem_5557 {
	static int[] array;
	static long [][] cache;
	static long answer = 0;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		array = new int[N];
		cache = new long[N][21];
		
		for(long c[] : cache) {
			Arrays.fill(c, -1);
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(find_case(1,array[0]));

	}

	
	private static long find_case(int cur, int val) {
		if(cur == N -1) {
			if(val == array[N-1])
				return 1;
			else
				return 0;
		}
		
		if(cache[cur][val] != -1)
			return cache[cur][val];
		
		long ret =0 ;
		
		if(val + array[cur] <= 20)
			ret += find_case(cur+1,val+array[cur]);
		
		if(0<= val - array[cur])
			ret += find_case(cur+1,val-array[cur]);
		
		return cache[cur][val] = ret;
	}
}
