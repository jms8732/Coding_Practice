package string;

//되돌리기
import java.util.*;
import java.io.*;

public class problem_1360 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Stack<Node> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			String split[] = br.readLine().split(" ");

			String time = split[2];
			String target = split[1];
			String op = split[0];

			stack.add(new Node(op,time,target));
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			Node cur = stack.pop();
			
			if (cur.op.equals("type")) {
				sb.insert(0, cur.target);
			} else {
				int time_gap = Integer.parseInt(cur.time) - Integer.parseInt(cur.target);
				
				while (!stack.isEmpty() &&  time_gap <= Integer.parseInt(stack.peek().time))
					stack.pop();
			}
		}

		System.out.println(sb.toString());
	}

	private static class Node {
		String time;
		String target;
		String op;

		public Node(String op, String time, String target) {
			this.target = target;
			this.time = time;
			this.op = op;
		}
	}
}
