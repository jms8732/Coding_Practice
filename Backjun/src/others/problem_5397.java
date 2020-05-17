package others;

//키로거
import java.util.*;
import java.io.*;

public class problem_5397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			String line = br.readLine();

			Stack<Character> stack = new Stack<>();

			bw.write(findPassword(stack, line));
			bw.newLine();
		}
		bw.flush();
	}

	private static String findPassword(Stack<Character> s, String line) {
		Stack<Character> tmp = new Stack<>();
		
		//list iterator를 이용한다.
		for (int i = 0; i < line.length(); i++) {
			char cur = line.charAt(i);

			if (cur == '<') {
				if(!s.isEmpty())
					tmp.add(s.pop());
				continue;
			}

			if (cur == '>') {
				if(!tmp.isEmpty())
					s.add(tmp.pop());
				continue;
			}

			if (cur == '-') {
				if (!s.isEmpty()) {
					s.pop();
				}
				continue;
			}

			s.push(cur);
		}

		StringBuilder sb =new StringBuilder();
		while(!tmp.isEmpty())
			s.push(tmp.pop());
		
		for(Character c : s)
			sb.append(c);
		
		return sb.toString();
		
	}
}
