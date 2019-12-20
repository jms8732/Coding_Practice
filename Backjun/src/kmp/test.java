package kmp;
//kmp 알고리즘 테스트

import java.util.*;

public class test {
	public static void main(String[] args) {
		String text = "abfabcabcabe";
		String pattern = "abcabe";
		int[] SP = new int[pattern.length()];
		computeSP(SP, pattern);
		KMP(SP,pattern,text);
	}

	private static void computeSP(int[] SP, String pattern) {
		SP[0] = 0;
		int k = 0;
		int m = pattern.length();
		for (int j = 1; j < m; j++) {
			while (k > 0 && pattern.charAt(j) != pattern.charAt(k))
				k = SP[k-1];
			if (pattern.charAt(j) == pattern.charAt(k))
				k++;

			SP[j] = k;
		}

		print(SP);
	}

	private static void KMP(int[] SP, String pattern, String text) {
		int k =0 ;
		for(int i = 0 ; i < text.length();  i++) {
			while(k >0 && pattern.charAt(k) != text.charAt(i))
				k = SP[k-1];
			if(pattern.charAt(k) == text.charAt(i))
				k++;
			if(k == pattern.length())
			{
				System.out.println("패턴이 " + k + "번에서 일치함");
				print(text);
			}
		}
	}
	private static void print(String s) {
		for(int i =0 ; i< s.length() ; i++) {
			System.out.print(i + " " );
		}
		System.out.println();
		for(int i =0 ; i <s.length() ; i++) {
			System.out.print(s.charAt(i) + " ");
		}
	}

	private static void print(int[] sp) {
		for (int i = 0; i < sp.length; i++) {
			System.out.print(sp[i] + " ");
		}
		System.out.println();
	}
}
