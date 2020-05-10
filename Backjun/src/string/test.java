package string;
//kmp �˰��� �׽�Ʈ

import java.util.*;

public class test {
	public static void main(String[] args) {
		String text = "abfabcabcabe";
		String pattern = "abcabe";
		int[] SP = new int[pattern.length()];
		computeSP(SP, pattern);
		KMP(SP,pattern,text);
	}
	
	private static void computeSP(int [] SP, String pattern) {
		int k = 0;
		SP[k] = 0;
		
		for(int j = 1 ; j< pattern.length() ; j++) {
			while(k> 0 && pattern.charAt(k) != pattern.charAt(j))
				k = SP[k-1];
			
			if(pattern.charAt(k) == pattern.charAt(j))
				k++;
			
			SP[j] = k;
		}
		
		print(SP);
	}
	private static void print(int [] sp) {
		for(int i =0 ; i< sp.length ; i++) {
			System.out.print(sp[i] + " ");
		}
		System.out.println();
	}
	
	private static void KMP(int [] SP, String pattern, String text) {
		int k =0 ;
		
		for(int i =0 ; i< text.length() ; i++) {
			while(k> 0 && pattern.charAt(k) != text.charAt(i))
				k = SP[k-1];
			if(pattern.charAt(k) == text.charAt(i))
				k++;
			
			if(k == pattern.length()) {
				int idx = i - pattern.length() + 1;
				System.out.println(idx +"������ ��ġ");
				k = SP[k-1];
			}
		}
	}
}
