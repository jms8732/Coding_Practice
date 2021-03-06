package others;
//�������� ����

import java.util.*;
import java.io.*;

public class problem_6588 {
	static int number;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] prime = new boolean[1000001];
		List<Integer> tmp = new ArrayList<>();
		for (int i = 2; i < prime.length; i++) {
			if (!prime[i]) {
				for (int j = i+i; j < prime.length; j += i) {
					prime[j] = true;
				}
			}
		}

		while (true) {
			number = Integer.parseInt(br.readLine());
			if (number == 0)
				break;
			combination(prime);
			bw.flush();
		}

	}

	private static void combination(boolean [] prime) throws IOException {
		for(int i = 3 ; i < number;  i++) {
			if(!prime[i] && !prime[number-i]) {
				String tmp = number + " = " +i + " + " + (number-i);
				bw.write(tmp);
				bw.newLine();
				return;
			}
		}
		
		bw.write("Goldbach's conjecture is wrong.");
		bw.newLine();
		
		return;
	}
}
