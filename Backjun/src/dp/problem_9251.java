package dp;

//LCS
import java.util.*;
import java.io.*;

public class problem_9251 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l1 = br.readLine();
		String l2 = br.readLine();
		
		int [][] lcs = new int[l1.length()+1][l2.length()+1];
	
		for(int i= 1; i <= l1.length() ; i++) {
			for(int j =1 ; j <= l2.length() ; j++) {
				if(l1.charAt(i-1) == l2.charAt(j-1))
					lcs[i][j] = lcs[i-1][j-1] +1;
				else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				}
			}
		}
	
		System.out.println(lcs[l1.length()][l2.length()]);
	}
	
	private static void print(int [][] lcs) {
		for(int i =0 ; i < lcs.length;  i++) {
			for(int j =0 ; j < lcs[i].length;  j++)
				System.out.print(lcs[i][j] + " ");
			System.out.println();
			
		}
	}
}
