package bitmask;

//선발 명단
import java.util.*;
import java.io.*;

public class problem_3980 {
	static int answer =0 ;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i= 0 ; i < tc ; i++) {
			int [][] position = new int[11][11];
			
			for(int j =0 ; j < 11 ; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int k =0 ; k < 11; k++) {
					position[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			int remainPosition = 0;
			for(int j =0 ; j < 11; j++) {
				remainPosition |= 1<<j;
			}

			startMatch(position,0,remainPosition,0);
			System.out.println(answer);
			answer = 0;
		}
	}
	
	private static void startMatch(int [][] position,int depth, int remainPosition, int sum) {
		if(depth == 11) {
			answer = Math.max(answer, sum);
			return;
		}
		
		
		for(int i =0 ; i < 11; i++) {
			if((remainPosition & 1<<i) == (1<<i) && position[depth][i] != 0) {
				remainPosition &= ~(1<<i);
				startMatch(position,depth+1,remainPosition,sum+ position[depth][i]);
				remainPosition |= 1<<i;
			}
		}
	}
}
