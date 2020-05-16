package others;

//°ýÈ£
import java.util.*;
import java.io.*;

public class problem_9012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			String vps = br.readLine();
			Stack<Character> stack = new Stack<>();

			if (checkVPS(vps, stack)) {
				System.out.println("YES");
			} else
				System.out.println("NO");
		}
	}

	private static boolean checkVPS(String vps, Stack<Character> s) {
		for (int i = 0; i < vps.length(); i++) {
			if (vps.charAt(i) == '(')
				s.add(vps.charAt(i));
			else {
				if (!s.isEmpty() && s.peek() == '(')
					s.pop();
				else
					return false;
			}
		}

		if (s.isEmpty())
			return true;
		else
			return false;
	}
}
