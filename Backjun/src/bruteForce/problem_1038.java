package bruteForce;

//감소하는 수
import java.util.*;
import java.io.*;

public class problem_1038 {
	static int current = 10;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N <= 10)
			System.out.println(N);
		else {
			int_to_string(N);
		}

	}

	private static void int_to_string(int N) {
		int range = 2; //자리 수
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			for(int i = 1 ; i <=9 ; i++) {
				sb.append(i);
				find_number(1,range,i,N,sb);
				sb.delete(sb.length()-1, sb.length());
			}
			
			if(current >= 1023) {
				System.out.println(-1);
				System.exit(0);
			}
			range++;
		}
	}
	
	
	private static void find_number(int depth, int range, int pre,int N,StringBuilder sb ) {
		if(depth == range) {
			if(current == N) {
				System.out.println(sb.toString());
				System.exit(0);
			}
			
			current++; //현재 번호
			return;
		}
		
		for(int i = 0 ; i < pre ; i++) {
			sb.append(i);
			find_number(depth+1,range,i,N,sb);
			sb.delete(sb.length()-1, sb.length());
		}
	}
}
