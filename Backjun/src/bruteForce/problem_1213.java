package bruteForce;

//팰린드롬 만들기
import java.util.*;
import java.io.*;

public class problem_1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int[] alphabet = new int[26];
		for (int i = 0; i < line.length(); i++)
			alphabet[line.charAt(i) - 'A'] += 1;

		StringBuilder sb = new StringBuilder();
		pailndrum(line.length(),0,sb,alphabet);
		System.out.println("I'm Sorry Hansoo");
	}

	private static void pailndrum(int total, int idx, StringBuilder sb, int[] alphabet) {
		if (total == 0 || total == 1) {
			if(total == 1) {
				for(int i =0 ; i < alphabet.length;  i++)
					if(alphabet[i] == 1)
					sb.insert(idx, (char)(i+'A'));
			}
			System.out.println(sb.toString());
			System.exit(0);
		}

		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] >= 2) {
				alphabet[i] -= 2;
				sb.insert(idx,  (char)(i+'A'));
				sb.insert(sb.length() - idx, (char)(i+'A'));
				
				pailndrum(total-2, idx+1,sb,alphabet);
			}
		}
	}
}
