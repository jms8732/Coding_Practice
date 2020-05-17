package others;

//문자열 폭발
import java.util.*;
import java.io.*;

public class problem_9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		String explode = br.readLine();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < line.length(); i++) {
			char cur = line.charAt(i);
			stack.add(cur);
			// 맨 마지막 문자와 같다면
			if (stack.size() >= explode.length()) {
				boolean isBoom = true;
				for(int j = 0 ; j < explode.length()  ; j++) {
					if(stack.get(stack.size() - explode.length() + j) != explode.charAt(j)) {
						isBoom = false;
						break;
					}
				}
				
				if(isBoom) {
					for(int j =0 ; j < explode.length() ; j++) {
						stack.pop();
					}
				}
			}
		}

		if (!stack.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			for(Character c : stack)
				sb.append(c);
			
			System.out.println(sb.toString());
		} else
			System.out.println("FRULA");
	}
}
