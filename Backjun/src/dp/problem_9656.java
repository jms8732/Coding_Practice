package dp;

/*
 * 돌 게임2
 * 돌 게임1의 반대 상황으로 조건을 주면 된다.
 */
import java.util.*;

public class problem_9656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N % 2 == 0)
			System.out.println("SK");
		else
			System.out.println("CY");
	}
}
