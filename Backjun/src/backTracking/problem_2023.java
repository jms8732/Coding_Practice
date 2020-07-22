package backTracking;

//신기한 소수
import java.io.*;
import java.util.*;

public class problem_2023 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		backtracking(N, sb);
	}

	private static void backtracking(int N, StringBuilder sb) {
		if (N == sb.length()) {
			System.out.println(sb.toString());
			return;
		}

		for (int i = 1; i <= 9; i++) {
			sb.append(i);
			if (is_prime(sb.toString())) {
				backtracking(N, sb);
			}
			sb.delete(sb.length() - 1, sb.length());
		}
	}

	private static boolean is_prime(String target) {
		int tar = Integer.parseInt(target);

		if(tar == 1)
			return false;
		
		int sqrt = (int)Math.sqrt(tar);
		
		for(int i = 2; i <= sqrt; i ++) {
			if(tar % i == 0)
				return false;
		}

		return true;
	}
}
