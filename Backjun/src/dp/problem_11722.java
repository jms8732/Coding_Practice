package dp;

/*
 * 가장 긴 감소하는 부분수열
 * 감소하는 부분 수열을 찾기 때문에 현재 숫자에를 기준으로 우측 값만 확인하면 된다
 */

import java.util.*;
import java.io.*;

public class problem_11722 {
	public static void main(String []args )throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int [] array = new int[N];
		for(int i= 0 ; i < array.length ; i++)
			array[i] = Integer.parseInt(st.nextToken());
		
		int cache[] = new int[N];
		Arrays.fill(cache,1);
		
		for(int i =  array.length-1; i >=0; i--) {
			for(int j = i ; j < array.length ; j++) {
				if(array[i] > array[j])
					cache[i]= Math.max(cache[i], cache[j]+1);
			}
		}
		
		int ans = 0;
		
		for(int i : cache)
			ans = Math.max(ans, i);
		System.out.println(ans);
	}
	
}
