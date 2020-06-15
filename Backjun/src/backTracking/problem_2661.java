package backTracking;

//좋은 수열
import java.util.*;
import java.io.*;

public class problem_2661 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder("12");

		backtracking(N, sb);
	}

	private static void backtracking(int N, StringBuilder sb) {
		if (sb.length() == N) {
			System.out.println(sb.toString());
			System.exit(0);
		}

		for (int i = 1; i <= 3; i++) {
			sb.append(i);
			if (isPerfect(sb.toString())) {
				backtracking(N, sb);
			}
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static boolean isPerfect(String line) {
		int len = line.length();
		
		for(int i = 1 ; i <= len/2 ; i++) {
			StringBuilder sb1=  new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			
			for(int j =0 ; j < i ; j++) {
				sb1.append(line.charAt(len-(2*i)+j));
				sb2.append(line.charAt(len-i+j));
			}
			
			if(sb1.toString().equals(sb2.toString()))
				return false;
		}

		return true;
	}

}
