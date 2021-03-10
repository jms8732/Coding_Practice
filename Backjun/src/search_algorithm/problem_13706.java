package search_algorithm;

/*
 * ������
 * N�� ���̰� 800 �����̹Ƿ� BigInteger�� �����ؾ��Ѵ�.
 * �������� �ǹ̴� �ش� ���ڸ� �� �� ���Ѱ��� �ǹ��Ѵ�.
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
