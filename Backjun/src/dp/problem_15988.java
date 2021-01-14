package dp;

/*
 * 1, 2, 3, 더하기 3
 * Scanner 를 이용할 경우, 시간 초과가 발생한다.
 */
import java.util.*;
import java.io.*;

public class problem_15988 {

	static int MOD = 1000000009;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());

		long [] array = new long[1000001];
	
		array[1] = 1;
		array[2] = 2;
		array[3] = 4;
		
		for(int i = 4 ; i < array.length ; i++) {
			array[i] = (array[i-3] % MOD ) + (array[i-2] % MOD) + (array[i-1] + MOD);
			array[i] %= MOD;
		}
		
		
		for(int i=0 ; i < tc;  i++) {
			int tar = Integer.parseInt(br.readLine());
			
			bw.write(String.valueOf(array[tar]));
			bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();

	}
}
