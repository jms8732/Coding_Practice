package others;

import java.util.*;

public class problem_1110 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int init = N;
		
		int answer =0 ;
		while(true) {
			N = change_val(N);
			answer++;
			
			if(init == N) {
				break;
			}
			
		}
		
		System.out.println(answer);
	}
	private static int change_val(int N) {
		int div = N / 10;
		int mod = N % 10;
		
		int result = div + mod;
		return mod *10 + (result % 10);
	}
}
