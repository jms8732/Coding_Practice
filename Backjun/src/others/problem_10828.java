package others;

//Ω∫≈√
import java.util.*;
import java.io.*;

public class problem_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			String[] split = line.split(" ");

			String op = split[0];
			if (op.equals("push")) {
				stack.add(split[1]);
				continue;
			}

			if (op.equals("pop")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else
					System.out.println(stack.pop());

				continue;
			}

			if (op.equals("size")) {
				System.out.println(stack.size());
				continue;
			}

			if (op.equals("empty")) {
				if (stack.isEmpty())
					System.out.println(1);
				else
					System.out.println(0);

				continue;
			}

			if (op.equals("top")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else
					System.out.println(stack.peek());

				continue;
			}
		}
	}
}
