package graph;

//���
import java.util.*;
import java.io.*;

public class problem_1080 {
	static int N,M;
	public static void main(String[] args) throws IOException{
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int [][] A = new int[N][M];
		int [][] B = new int[N][M];
		
		for(int i =0 ; i< N ; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j< tmp.length() ; j++) {
				A[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		for(int i =0 ; i < N ; i++) {
			String tmp = br.readLine();
			for(int j =0 ; j < tmp.length() ; j++) {
				B[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		if(N < 3 || M < 3) {
			if(isSame(A,B))
				System.out.println(0);
			else
				System.out.println(-1);
		}else
			start(A,B);
	}
	private static void start(int [][] A ,int [][] B) {
		int opCount =0 ;
		for(int i =0 ; i < N -2 ; i++) {
			for(int j =0 ; j < M -2 ; j++) {
				if(A[i][j] != B[i][j]) {
					opCount++;
					change(A,i,j);
				}
			}
		}
		
		if(isSame(A,B)) {
			System.out.println(opCount);
		}else
			System.out.println(-1);
	}
	private static boolean isSame(int[][] A ,int [][] B) {
		for(int i =0 ; i < N; i++) {
			for(int j =0 ; j < M; j++) {
				if(A[i][j] != B[i][j])
					return false;
			}
		}
		
		return true;
	}
	
	private static void change(int [][] A, int x, int y) {
		for(int i = x ; i < x+3; i++) {
			for(int j =y ; j < y+3; j++) {
				
				if(A[i][j] == 0)
					A[i][j] = 1;
				else
					A[i][j] = 0;
			}
		}
	}
}
