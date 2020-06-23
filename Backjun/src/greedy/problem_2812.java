package greedy;

//크게 만들기
import java.util.*;
import java.io.*;

public class problem_2812 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		String line = br.readLine();

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < line.length(); i++) {
			int cur = line.charAt(i) - '0';

			while(K > 0 && !stack.isEmpty() && stack.peek() < cur) {
				K--;
				stack.pop();
			}
			stack.add(cur);
		}

		for(int i =0 ; i < stack.size()-K; i++) {
			System.out.print(stack.get(i));
		}
	}
}
