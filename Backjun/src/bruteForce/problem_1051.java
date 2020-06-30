package bruteForce;

import java.util.*;
import java.io.*;

public class problem_1051 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] array = new int[N][M];
		
		for(int i =0 ; i < N ; i ++) {
			String tmp = br.readLine();
			for(int j =0 ; j < M ; j++) {
				array[i][j] = tmp.charAt(j) -'0';
			}
		}
		int len = 0;
		
		int answer = 0;
		while(len < N && len < M ) {
			if(search_square(array,N,M,len))
				answer = (len+1) * (len+1);
			len++;
		}
		
		System.out.println(answer);
	}
	
	private static boolean search_square(int [][] array ,int N , int M, int len) {
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < M ; j++) {
				if(i + len < N && j + len < M ) {
					if(array[i][j] == array[i+len][j] && array[i][j] == array[i][j+len] && array[i][j] == array[i+len][j+len])
						return true;
				}
			}
		}
		
		return false;
	}
}
