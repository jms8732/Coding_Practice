package bruteForce;

//��¥ ���
import java.util.*;
public class problem_1476 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		int start = 1;
		while(true) {
			if((start % 15) == E %15 && (start % 28) == S %28 && (start % 19) ==M % 19)
				break;
			start++;
		}
		System.out.println(start);
	}
}
