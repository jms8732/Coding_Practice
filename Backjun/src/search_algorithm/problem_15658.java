package search_algorithm;

//연산자 끼워 넣기(2)
import java.util.*;
import java.io.*;

public class problem_15658 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> number = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			number.add(Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		int[] op = new int[4];
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		operation(number, op);
	}

	private static void operation(Deque<Integer> number, int[] op) {
		Queue<Node> queue = new LinkedList<>();
		int big = Integer.MIN_VALUE, small = Integer.MAX_VALUE;

		int f = number.poll();
		int s = number.poll();
		for (int i = 0; i < 4; i++) {
			if (op[i] != 0) {
				op[i] -= 1;
				int result = op(f, s, i);
				number.addFirst(result);

				queue.add(new Node(number, op));
				op[i] += 1;
				number.pollFirst();
			}
		}

		while (!queue.isEmpty()) {
			Node cur = queue.poll();

			if (cur.number.size() == 1) {
				int result = cur.number.poll();
				big = Math.max(big, result);
				small = Math.min(small, result);

			} else {

				f = cur.number.poll();
				s = cur.number.poll();

				for (int i = 0; i < 4; i++) {
					if (cur.op[i] != 0) {
						cur.op[i] -= 1;
						int result = op(f, s, i);
						cur.number.addFirst(result);

						queue.add(new Node(cur.number, cur.op));
						cur.op[i] += 1;
						cur.number.pollFirst();
					}
				}
			}
		}

		System.out.println(big);
		System.out.println(small);
	}

	private static int op(int f, int s, int op) {
		int result = 0;
		switch (op) {
		case 0:
			result = f + s;
			break;
		case 1:
			result = f - s;
			break;
		case 2:
			result = f * s;
			break;
		case 3:
			if (f > 0)
				result = f / s;
			else {
				f *= -1;
				result = f / s;
				result *= -1;
			}
			break;
		}

		return result;
	}

	private static class Node {
		Deque<Integer> number;
		int[] op = new int[4];

		public Node(Deque<Integer> n, int[] o) {
			number = new LinkedList<Integer>(n);
			System.arraycopy(o, 0, op, 0, o.length);

		}
	}
}
