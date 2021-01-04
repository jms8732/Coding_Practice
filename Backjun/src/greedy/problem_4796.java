package greedy;

/*
 * 캠핑
 * 나누기, 나머지 연산자를 이용하여 문제를 해곃
 * 1) 휴가를 연속하는 캠핑일로 나눈다.
 * 2) 몫 * L이 강산이가 즐길 수 있는 휴가 일수 이다.
 * 3) 나머지가 발생할 수 있는데 나머지가 L보다 큰 경우, 강산이가 캠핑장에서 휴가를 더 즐길 수 있다는 의미이다. 따라서, (몫 + 1) * L 이 강산이가 즐길 수 있는 휴가일 수 이다. 
 */
import java.io.*;
import java.util.*;

public class problem_4796 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc =1;
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(l == 0 && p == 0 && v == 0) //종료 조건
				break;
			
			int quo = v / p;
			int mod = v % p;
			
			
			if(mod > l) {
				System.out.println("Case " + tc++ + ": " + ((quo+1) * l));
			}else {
				System.out.println("Case " + tc++ + ": " + (quo * l + mod));
			}
			
		}
	}
}
