package string;

//����

import java.util.*;
import java.io.*;
public class problem_1305 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String pattern = br.readLine();
		int [] pi = new int[N];
		
		int result = computePI(pi,pattern);
		System.out.println(result);
	}
	
	private static int computePI(int []pi,String p) {
		int k =0 ;
		pi[k] =0;
		
		for(int i = 1 ; i< p.length() ; i++) {
			while(k >0 && p.charAt(k) != p.charAt(i))
				k = pi[k-1];
			if(p.charAt(k)== p.charAt(i))
				k++;
			
			pi[i] = k;
		}
		print(pi);
		return p.length() - pi[pi.length-1];
	}
	private static void print(int [] pi) {
		for(int i =0 ; i< pi.length ; i++)
			System.out.print(pi[i]+ " " );
		System.out.println();
	}
}
