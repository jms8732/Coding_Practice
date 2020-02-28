package others;

import java.util.*;
import java.io.*;

//�Ҽ� ã��
public class problem_1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] array = new int[N];
		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(array);
		int count = 0;
		for(int i =0 ; i < array.length ; i++) {
			if(checkPrime(array[i]))
				count++;
		}
		System.out.println(count);
	}
	private static boolean checkPrime(int value) {
		if(value == 1)
			return false;
		
		for(int i = value -1 ; i >= 2 ; i--) {
			if(value % i == 0)
				return false;
		}
		return true;
	}
}
