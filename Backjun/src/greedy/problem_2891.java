package greedy;

/*
 * 카약과 강풍
 * 프로그래머스 체육복과 동일한 문제
 */
import java.util.*;
import java.io.*;

public class problem_2891 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		boolean [] destroyed = new boolean[11];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0 ; i <S ; i++) {
			destroyed[Integer.parseInt(st.nextToken())] = true;
		}
		
		boolean [] spare = new boolean[11];
		
		st = new StringTokenizer(br.readLine());
		for(int i= 0 ; i< R ; i++) {
			spare[Integer.parseInt(st.nextToken())] = true;
		}
		
		int ban = S;
		for(int i =0 ; i < spare.length ; i++) {
			if(destroyed[i]) {
				//파손된 경우
				if(spare[i]) {
					//자기 자신이 여분이 존재한 경우
					destroyed[i] = false;
					spare[i] = false;
					ban--;
				}else {
					//여분이 존재하지 않는 경우
					int left = i -1;
					
					if(left >= 0 && spare[left]) {
						spare[left] = false;
						destroyed[i] = false;
						ban--;
						continue;
					}
					
					int right = i +1;
					
					if(right < destroyed.length && spare[right]) {
						spare[right] = false;
						destroyed[i] = false;
						ban--;
						continue;
					}
				}
			}
		}
		
		System.out.println(ban);
	}
}