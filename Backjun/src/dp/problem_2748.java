package dp;

/*
 * �Ǻ���ġ �� 2
 * �������� DP ������ ����
 * ��, �Է� n�� 90 ������ �ڿ����̹Ƿ� int�� ������ ����� ������ long������ ���� �����ؾ� �Ѵ�.
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
