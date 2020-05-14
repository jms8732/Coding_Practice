package string;

//¾ËÆÄºª Ã£±â
import java.util.*;
import java.io.*;

public class problem_10809 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [] alpha = new int[26];
		
		Arrays.fill(alpha, -1);
		
		String tmp = br.readLine();
		
		for(int i= 0 ; i < tmp.length() ; i++) {
			char cur = tmp.charAt(i);
			if(alpha[cur % 'a'] == -1) {
				alpha[cur % 'a'] = i;
			}
		}
		
		for(int i : alpha)
			System.out.print(i + " ");
	}
}
