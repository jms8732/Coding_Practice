package dp;
import java.util.*;
public class problem_11727 {
	static int [] array = new int[1001];
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int result = f(n);
		System.out.println(result);
	}
	static int f(int n) {
		if(n == 1)
			return 1;
		if(n== 2)
			return 3;
		if(array[n] != 0)
			return array[n];
		
		int result= f(n-1) % 10007 + (2*f(n-2)) % 10007;
		array[n] = result  % 10007;
		return array[n];
	}
}
