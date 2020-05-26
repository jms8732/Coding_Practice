package others;

//숫자의 개수
import java.util.*;

public class problem_2577 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a= sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int result = a*b*c;
		
		int [] array = new int[10];
		
		while(result /10 !=0){
			array[result % 10] += 1;
			result /= 10;
		}
		
		array[result%10] += 1;
		
		for(int i : array)
			System.out.println(i);
	}
}
