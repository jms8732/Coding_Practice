package dp;

/*
 * 돌 게임
 * 입력된 값이 홀수일 경우 SK, 짝수일 경우 CY가 이긴다.
 */
import java.util.*;

public class problem_9655 {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N % 2 == 0)
			System.out.println("CY");
		else
			System.out.println("SK");
	}	
}
