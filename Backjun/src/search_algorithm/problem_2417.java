package search_algorithm;

/*
 * ���� ������
 * ���� 13706���� �ٸ��� �������� ���� �������� �ƴ� �� �����Ƿ� �̺� Ž���� �Ͽ� ã�� ���� mid ���� 
 * �ƴ� ���� left���� ����Ѵ�.
 * left ���� ����ϴ� ������ q^2 >= n �� ���� ���� ���� �ƴ� ���� q�� ����ؾ��ϹǷ�
 */
import java.util.*;
import java.math.*;
import java.io.*;

public class problem_2417 {
	public static void main(String []args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		
		sqrt(n);
	}
	
	private static void sqrt(String n) {
		BigInteger target = new BigInteger(n);
		BigInteger left = new BigInteger("0");
		BigInteger right = new BigInteger(n);
		BigInteger two = new BigInteger("2");
		BigInteger mid = null;
		
		boolean check= false;
		while(left.compareTo(right) < 0) {
			mid = left.add(right).divide(two);
			
			BigInteger temp = mid.pow(2);
			
			if(target.compareTo(temp) == 0) {
				check = true;
				break;
			}
			
			if(target.compareTo(temp) < 0)
				right = mid;
			else
				left = mid.add(new BigInteger("1"));
		}
		System.out.println(check == true ? mid : left);
	}
}
