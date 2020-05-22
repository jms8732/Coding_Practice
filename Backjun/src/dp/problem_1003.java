package dp;

//피보나치 함수
import java.util.*;
import java.io.*;

public class problem_1003 {
	static int [] zero, one;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		zero = new int[41];
		one = new int[41];
		
		zero[0] = 1;
		one[0] = 0;
		
		zero[1] = 0;
		one[1] = 1;
		
		for(int i = 2; i <= 40 ; i++) {
			zero[i] = zero[i-2] + zero[i-1];
			one[i] = one[i-2] + one[i-1];
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(zero[n] + " " + one[n]);
			bw.newLine();
		}
		bw.flush();
	}
}
