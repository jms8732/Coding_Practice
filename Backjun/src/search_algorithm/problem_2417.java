package search_algorithm;

/*
 * 정수 제곱근
 * 백준 13706과는 다르게 제곱근의 값이 정수형이 아닐 수 있으므로 이분 탐색을 하여 찾는 경우는 mid 값을 
 * 아닌 경우는 left값을 출력한다.
 * left 값을 출력하는 이유는 q^2 >= n 인 가장 작은 음이 아닌 정수 q를 출력해야하므로
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
