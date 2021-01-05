package dp;

/*
 * 피보나치 수 2
 * 전형적인 DP 유형의 문제
 * 단, 입력 n이 90 이하의 자연수이므로 int형 범위를 벗어나기 때문에 long형으로 값을 저장해야 한다.
 */
import java.util.*;
public class problem_2748 {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long [] array = new long[n+1];
		
		array[1] = 1;
		
		for(int i =2 ; i < array.length ; i++) {
			array[i] = array[i-1] + array[i-2];
		}
		
		System.out.println(array[n]);
	}
}
