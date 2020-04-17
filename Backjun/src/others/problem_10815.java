package others;

//숫자 카드 1:30 -> 1:20 (10분 소요)

import java.util.*;
import java.io.*;

public class problem_10815 {
	public static void main(String[] args ) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> set =  new LinkedHashSet<>();
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i =0 ; i < N ; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i =0 ; i < M ; i++) {
			int val = Integer.parseInt(st.nextToken());
			
			if(set.contains(val))
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");
		}
	}
}
