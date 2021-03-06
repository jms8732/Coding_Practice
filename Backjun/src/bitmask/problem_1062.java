package bitmask;

//����ħ
import java.util.*;
import java.io.*;

public class problem_1062 {
	static int N,K;
	static String[] words;
	static int totalCount;
	
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int alphabet =0;
		words =new String[N];
		
		
		for(int i =0 ; i< N ; i++) {
			String target = br.readLine();
			
			int start = target.indexOf("anta") + 4;
			int end = target.indexOf("tica");
			
			words[i] = target.substring(start,end);
		}

		int combination = 0, next =0 ;
		char [] base = {'a','n','t','i','c'};
		for(int i=0 ; i < base.length ; i++) {
			combination |= 1<<base[i] -'a';
		}
		
		teachLetter(Integer.bitCount(combination),next,combination);
		System.out.println(totalCount);
	}
	
	private static void teachLetter(int count, int next, int current) {
		if(count == K) {
			int c = 0;
			outter : for(int i =0 ; i< N ; i++) {
				String target = words[i];
				
				for(int j =0 ; j < target.length() ; j++) {
					char tmp = target.charAt(j);
					
					if((current & 1<<tmp-'a') != 1<<tmp-'a') {
						continue outter;
					}
				}	
				c++;
			}
			
			
			totalCount = Math.max(totalCount, c);
			return;
		}
		
		for(int i = next ; i < 26 ; i++) {
			if((current & 1<<i) != (1<<i)) {
				teachLetter(count+1,i+1,current |= 1<<i);
				current &= ~(1<<i);
			}
		}
	}
}
