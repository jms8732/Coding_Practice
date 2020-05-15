package bruteForce;

//ºÐÇØÇÕ
import java.util.*;
import java.io.*;

public class problem_2231 {
	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int target = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		for(int i = target ; i > 0 ; i--) {
			String tmp = String.valueOf(i);
			
			int part = 0;
			for(int j =0 ; j < tmp.length() ; j++) {
				part += tmp.charAt(j) - '0';
			}
			
			int result = i + part;
			if(target == result) {
				answer = i;
			}
		}
		
		System.out.println(answer);
	}
}
