package others;

/*
 * 아스키 도형
 *  /,\ 가 나올 경우 0.5를 더하고 /과 \의 사이에 존재하는 빈칸은 1을 더한다.
 *  \,/ 에 포함이 안되는 빈칸은 더하지 않는다.
 */
import java.util.*;
import java.io.*;

public class problem_3495 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		char [][] shape=  new char[h][w];
		
		for(int i =0 ; i < h; i++) {
			String tmp = br.readLine();
			for(int j = 0 ; j < w; j ++) {
				shape[i][j] = tmp.charAt(j);
			}
		}
		
		double ans = 0.0;
		for(int i = 0 ; i <h ; i++) {
			boolean start = false;
			for(int j =0 ; j < w ; j++) {
				if(shape[i][j] == '/' || shape[i][j] == '\\') {
					ans += 0.5;
					
					start = !start;
				}else if(start){
					ans += 1;
				}
			}
		}
		
		System.out.println((int)ans);
	}

}
