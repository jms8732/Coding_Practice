package dp;

//가장 큰 증가 부분 수열
import java.util.*;
import java.io.*;

public class problem_11055 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] array = new int[N];
		int [] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i =0; i< N; i++) array[i] = Integer.parseInt(st.nextToken());
		
		System.arraycopy(array, 0, dp, 0, array.length);
		
		//현재 위치
		for(int i =0 ; i < N ; i++) {
			//비교 대상 위치
			for(int j = i-1 ; j >=0 ; j--) {
				if(array[i] > array[j]) {
					dp[i] = Math.max(dp[i], array[i]+ dp[j]);
				}
			}
		}
		
		int answer =0 ;
		for(int i =0 ; i< dp.length ; i++) {
			answer= Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}
