package backTracking;

//행운의 문자열
import java.util.*;
import java.io.*;

public class problem_1342 {
	static int answer = 0;
	static int alpabet[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] array = br.readLine().toCharArray();
		alpabet = new int[26];
		
		for (int i = 0; i < array.length; i++) {
			alpabet[array[i] - 'a'] += 1;
		}

		backtracking(array,0,' ');
		System.out.println(answer);
	}

	private static void backtracking(char[] array, int depth, char prev) {
		if (depth == array.length) {
			answer++;
			return;
		}

		char tmp_prev = prev;
		for (int i = 0; i < alpabet.length; i++) {
			if (alpabet[i] != 0 && tmp_prev != (char) ('a' + i)) {
				alpabet[i] -= 1;
				prev = (char) ('a' + i);
				backtracking(array, depth+1, prev);
				alpabet[i] += 1;
			}
		}
	}
}
