package greedy;

/*
 * 우유 축제
 * 최대한 많은 우유를 먹기 위해서는 영학이가 우유를 먹는 순서와 가게가 파는 우유가 동일할 경우, 사 먹어야 한다.
 */

import java.util.*;
import java.io.*;

public class problem_14720 {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int []store=  new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		for(int i =0 ; i <N ; i++) {
			store[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] order = {0,1,2};
		int pos =0 ;
		int ans = 0;
		for(int i =0 ; i < N ; i++) {
			if(store[i] == order[pos % order.length]) {
				pos++;
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}

}
