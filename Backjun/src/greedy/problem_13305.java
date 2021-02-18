package greedy;

/*
 * 주유소
 * 거리와 기름의 범위가 10억이기 때문에 long, int형에 벗어난다.
 * BigInteger 클래스를 이용한다.
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class problem_13305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		Queue<Integer> dis = new LinkedList<>();
		
		for (int i = 0; i < n-1; i++) {
			dis.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		
		Queue<Integer> oil = new LinkedList<>();
		
		for(int i =0 ; i < n ; i++)
			oil.add(Integer.parseInt(st.nextToken()));
		
		BigInteger cost = new BigInteger("0");
		int oil_price = oil.poll();
		int dist = 0;
		while(!dis.isEmpty()) {
			dist += dis.poll();
			int next_price = oil.poll();
			if(next_price <= oil_price) {
				BigInteger dis_tmp = new BigInteger(String.valueOf(dist));
				BigInteger oil_tmp = new BigInteger(String.valueOf(oil_price));
				
				cost = cost.add(dis_tmp.multiply(oil_tmp));
				oil_price = next_price;
				dist = 0;
			}	
		}
		
		if(dist !=0) {
			BigInteger dis_tmp = new BigInteger(String.valueOf(dist));
			BigInteger oil_tmp = new BigInteger(String.valueOf(oil_price));
			
			cost = cost.add(dis_tmp.multiply(oil_tmp));
		}
			
		
		System.out.println(cost);
	}
}
