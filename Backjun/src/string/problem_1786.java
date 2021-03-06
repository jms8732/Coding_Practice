package string;

//ã��
import java.util.*;
import java.io.*;

public class problem_1786 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String text = br.readLine();
		String pattern = br.readLine();

		int[] sp = new int[pattern.length()];
		List<Integer> list = new ArrayList<>();
		computeSP(sp, pattern);
		int result = KMP(sp,pattern,text,list);
		
		System.out.println(result);
		for(int i : list)
			System.out.print(i + " ");
	}
	private static int KMP(int [] SP, String pattern, String text,List<Integer> list) {
		int k =0 ;
		SP[k] = 0;
		int count = 0;
		for(int j = 0 ; j< text.length() ; j++) {
			while(k >0 && pattern.charAt(k) != text.charAt(j))
				k = SP[k-1];
			if(pattern.charAt(k) == text.charAt(j))
				k++;
			
			if(k == pattern.length()) {
				int idx = j - (k-1) +1;
				list.add(idx);
				count++;
				k = SP[k-1];
			}
		}
		
		return count;
	}

	private static void computeSP(int[] SP, String pattern) {
		int k = 0;
		SP[k] = 0;

		for (int j = 1; j < pattern.length(); j++) {
			while (k > 0 && pattern.charAt(k) != pattern.charAt(j))
				k = SP[k - 1];
			
			if(pattern.charAt(k) == pattern.charAt(j))
				k++;
			
			SP[j] = k;
		}
	}
}
