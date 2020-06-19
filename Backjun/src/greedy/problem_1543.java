package greedy;

//문서 검색
import java.util.*;
import java.io.*;

public class problem_1543 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String target = br.readLine();
		String pattern = br.readLine();
		int [] pattern_sp = new int[pattern.length()];
		
		makeSP(pattern,pattern_sp);
		kmp(target,pattern,pattern_sp);
	}
	
	private static void kmp(String tar, String pat, int [] sp) {
		int k =0 ;
		sp[k] = 0;
		List<Integer> start_idx = new ArrayList<>();
		
		for(int i = 0 ; i < tar.length() ; i++) {
			while(k > 0 && tar.charAt(i) != pat.charAt(k)) {
				k = sp[k-1];
			}
			
			if(tar.charAt(i) == pat.charAt(k))
				k++;
			
			if(k == pat.length()) {
				start_idx.add(i - (k-1));
				k = 0;
			}
		}
		
		System.out.println(start_idx.size());
	}
	
	
	private static void makeSP(String line, int [] SP) {
		SP[0] = 0;
		int K = 0;
		
		for(int i = 1 ; i < line.length() ; i ++) {
			while(K > 0 && line.charAt(K) != line.charAt(i)) {
				K = SP[K-1];
			}
			
			if(line.charAt(K) == line.charAt(i))
				K++;
			
			SP[i] = K;
		}
	}
}
