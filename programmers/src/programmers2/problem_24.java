package programmers2;

//짝지어 제거하기
import java.util.*;

public class problem_24 {
	public static void main(String args[]) {
		String s = "baabaa";

		int result = solution(s);
		System.out.println(result);
	}

	public static int solution(String s) {
		Stack<Character> stack = new Stack<>();
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (stack.isEmpty()) {
				stack.add(cur);
			} else {
				char pre = stack.peek();
				if (pre == cur) {
					stack.pop();
				} else
					stack.add(cur);
			}
		}

		if (stack.isEmpty())
			ans = 1;

		return ans;

	}
}
