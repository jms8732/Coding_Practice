package dp;

//문자열 판별
import java.util.*;
import java.io.*;

public class problem_16500 {
	static String[] array;
	static String s;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		s = br.readLine();
		N = Integer.parseInt(br.readLine());

		array = new String[N];

		for (int i = 0; i < N; i++)
			array[i] = br.readLine();

		int start = 0;

		if (dp(start))
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static boolean dp(int start) {
		if (start == s.length())
			return true;


		for (int j = 0; j < N; j++) {
			boolean check = false;
			String word = array[j];

			if (word.length() + start > s.length())
				continue;

			for (int k = 0; k < word.length(); k++) {
				if (s.charAt(start + k) != word.charAt(k)) {
					check = true;
					break;
				}
			}

			if (!check) {
				if (dp(start + word.length()))
					return true;
			}
		}

		return false;
	}
}
