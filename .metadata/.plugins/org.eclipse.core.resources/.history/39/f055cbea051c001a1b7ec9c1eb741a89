package dp;

import java.util.*;

public class problem_2193 {
	static long [] array ;
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int size=  scanner.nextInt();
		array = new long [size+1];
		long result = f(size);
		System.out.println(result);
	}
	static long f(int idx) {
		if(idx <0 )
			return 0;
		if(idx == 1)
			return 1;
		if(idx ==2)
			return 1;
		if(array[idx] != 0)
			return array[idx];
		
		array[idx] = f(idx-2) + f(idx-1);
		
		long result = array[idx]; 
		
		return result;
	}
}
