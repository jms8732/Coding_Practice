package dp;

/*
 * 점화식
 * 자릿수 범위를 충분히 수용할 수 있는 BigInteger를 이용한다
 */
import java.util.*;
import java.math.*;

public class problem_13699 {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		BigInteger [] cache = new BigInteger[n+1];
		cache[0] = new BigInteger("1");
	
		for(int i = 1; i <= n ; i++) {
			BigInteger temp = new BigInteger("0");
			for(int j = 0 ; j < i ; j++) {
				temp = temp.add(cache[j].multiply(cache[i-(j+1)]));
			}
			
			cache[i] = temp;
		}
		
		System.out.println(cache[n]);
	}
}
