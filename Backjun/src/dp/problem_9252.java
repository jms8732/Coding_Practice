package dp;

//LCS 2
import java.io.*;
import java.util.*;

public class problem_9252 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		
		int [][] lcs = new int[A.length()+1][B.length()+1];
		String [][] dir = new String[A.length()+1][B.length()+1];
		for(int i = 1; i  <lcs.length ; i++) {
			for(int j = 1; j < lcs[i].length;  j++) {
				if(A.charAt(i-1) == B.charAt(j-1)) {
					lcs[i][j] = lcs[i-1][j-1]+1;
					dir[i][j] = "diagonal";
				}else {
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
					
					if(lcs[i][j] == lcs[i-1][j]) {
						dir[i][j] = "top";
					}else
						dir[i][j] = "left";
				}
			}
		}
		
		System.out.println(lcs[A.length()][B.length()]);
		System.out.println(reconstruction(dir,A,B));
	}
	private static String reconstruction(String[][] dir, String A, String B) {
		StringBuilder sb = new StringBuilder();
		
		int x = A.length();
		int y = B.length();
		
		while(dir[x][y] != null) {
			if(dir[x][y].equals("diagonal")) {
				sb.append(A.charAt(x-1));
				
				x--;
				y--;
			}else {
				if(dir[x][y].equals("top")) {
					x--;
				}else if(dir[x][y].equals("left")) {
					y--;
				}
			}
		}
		
		return sb.reverse().toString();
	}
	
	

}
