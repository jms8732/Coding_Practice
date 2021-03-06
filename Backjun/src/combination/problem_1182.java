package combination;

//부분 수열의 합
import java.util.*;
import java.io.*;

public class problem_1182 {
	static boolean[] visited;
	static int [] array;
	static int sum;
	static int N;
	static int count;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			array=  new int[N];
			visited = new boolean[N];
			sum = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			//배열에 값 할당
			for(int i =0 ; i < N ; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			
			//bitmask
			for(int i = 1;  i<(1<<N); i++) {
				if(masking(i))
					count++;
			}
			
			System.out.println(count);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	private static boolean masking(int i) {
		int s = 0;
		for(int bitmask = 0 ; bitmask < N; bitmask++) {
			if((i & (1<<bitmask)) == (1<<bitmask)) {
				s += array[bitmask];
			}
		}
		
		if(s == sum)
			return true;
		
		return false;
	}
	
}
