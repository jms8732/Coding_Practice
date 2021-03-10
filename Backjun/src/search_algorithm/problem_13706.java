package search_algorithm;

/*
 * 제곱근
 * N의 길이가 800 이하이므로 BigInteger로 구현해야한다.
 * 제곱근의 의미는 해당 숫자를 두 번 곱한것을 의미한다.
 */
import java.util.*;
import java.math.*;

public class problem_13706 {
	public static void main(String []args) {
		Scanner sc =new Scanner(System.in);
		String n = sc.nextLine();
		
		BigInteger val = new BigInteger(n);
		
		sqrt(n,val);
	}
	
	private static void sqrt(String n, BigInteger val) {
		BigInteger left  =new BigInteger("1");
		BigInteger two = new BigInteger("2");
		BigInteger right = new BigInteger(n);
		BigInteger mid = null;
		
		while(left.compareTo(right) < 0) {
			mid = left.add(right).divide(two);
			BigInteger temp = mid.pow(2);
			
			if(val.compareTo(temp) == 0)
				break;
			
			if(val.compareTo(temp) < 0)
				right = mid;
			else
				left = mid.add(new BigInteger("1"));
				
		}
		
		
		System.out.println(mid);
	}
}
