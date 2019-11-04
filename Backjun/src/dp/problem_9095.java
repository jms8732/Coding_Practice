package dp;

import java.util.*;

public class problem_9095 {
	static int[] array;
	static int [] tmpArray;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int test = scanner.nextInt();
		tmpArray = new int [test];
		for (int i = 0; i < test; i++) {
			int tmp = scanner.nextInt();
		tmpArray[i] = tmp;
		}
		for(int i= 0 ; i < tmpArray.length ; i++) {
			array = new int[tmpArray[i]+1];
			int result = f(tmpArray[i]);
			System.out.println(result);
		}
	}

	static int f(int n) {
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		
		array[1] = 1;
		array[2] = 2;
		array[3] = 4;
		
		if(n <= 3)
			return array[n];
		for(int i = 4 ; i <= n ; i++)
		{
			int result = array[i-1]+ array[i-2]+ array[i-3];
			array[i] = result;
		}
		return array[n];
	}
}
