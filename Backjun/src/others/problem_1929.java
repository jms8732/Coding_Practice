package others;

import java.io.*;
import java.util.*;

//치킨 먹고 싶다.
public class problem_1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Set<Integer> set = new TreeSet<>();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i = 2; i <= 1000000 ; i++) {
			if(!set.contains(i) ) {
				if(M <= i && i <= N)
					System.out.println(i);
				for(int j = i +i ; j <= 1000000 ; j+= i)
					set.add(j);
			}
		}
		
	}
}
