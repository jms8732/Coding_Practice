package bruteForce;

//새로운 수
import java.util.*;

public class problem_1748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		
		int [] array = new int[10];
		
		for(int i = 1; i <= number; i++) {
			
			int cur = i;
			while(cur / 10 != 0) {
				array[cur%10] += 1;
				cur /= 10;
			}
			
			array[cur %10] += 1;
		}
		
		int answer = 0;
		
		for(int i= 0 ; i < array.length ; i++) {
			answer += array[i];
		}
		System.out.println(answer);
	}
}
