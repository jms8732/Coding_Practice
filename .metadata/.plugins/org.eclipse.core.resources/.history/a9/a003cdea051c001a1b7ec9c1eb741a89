package dp;

import java.util.Scanner;

public class problem_15988 {
	static long [] array;
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
			array = new long [tmpArray[i]+1];
			long result = f(tmpArray[i]);
			System.out.println(result);
		}
	}

	static long f(int n) {
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
			long result = (array[i-1]  %  1000000009)+ (array[i-2]  %  1000000009)+ (array[i-3] %   1000000009);
			array[i] = result %  1000000009;
		}
		return array[n];
	}
}
