package others;

import java.util.*;
import java.io.*;

//GCD�� ��
public class problem_9613 {
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int [] array= new int[N];
			
			for(int j =0 ; j < N ; j++)
				array[j] = Integer.parseInt(st.nextToken());
		
			int depth = 0, next = 0;
			int [] answer = new int[2];
			GCD_pair(depth,next,array,answer);
			System.out.println(result);
			
			result = 0;
		}

	}
	
	private static void GCD_pair(int depth ,int next, int [] array, int [] answer) {
		if(depth == answer.length) {
			int big = 0 ,small = 0;
			
			if(answer[0] < answer[1]) {
				big = answer[1];
				small = answer[0];
			}else {
				big = answer[0];
				small = answer[1];
			}
			
			int mod = 0;
			while(true) {
				mod = big % small;
				
				if(mod == 0)
					break;
				
				big = small;
				small = mod;
			}
			result += small;
			return;
		}
		
		for(int i = next ;i < array.length ; i++) {
			answer[depth] = array[i];
			GCD_pair(depth+1,i+1,array,answer);
		}
	}
}
