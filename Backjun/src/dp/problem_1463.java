package dp;
import java.util.*;

public class problem_1463 {
	static int[] array;
	public static void main(String []args) {
		Scanner scanner =new Scanner(System.in);
		int size = scanner.nextInt();
		array = new int[size+1];
		int result = f(size);
		System.out.println(result);
	}
	static int f(int idx) {
		if(idx ==1)
			return 0;
		if(array[idx] != 0)
			return array[idx];
		
		int result = f(idx-1) + 1;
		if(idx % 3 == 0) result = min(result, f(idx/3)+1);
		if(idx % 2 == 0) result = min(result, f(idx/2)+1);
		array[idx] = result;
		return result;
	}
	static int min(int a, int b) {
		return a > b ? b : a;
	}
}

