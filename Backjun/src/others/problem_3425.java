package others;

//∞ÌΩ∫≈√
import java.util.*;
import java.io.*;
import java.math.*;

public class problem_3425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String temp = br.readLine();

			if (temp.equals("QUIT"))
				break;

			if (temp.equals("")) {
				System.out.println();
				continue;
			}

			List<String> op = new ArrayList<>();
			op.add(temp);
			String line = null;

			if (!op.contains("END")) {
				while (!(line = br.readLine()).equals("END")) {
					op.add(line);
				}
			}

			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				int tar = Integer.parseInt(br.readLine());
				go_stack(op, tar);
			}

		}
	}

	private static void go_stack(List<String> op, int target) {
		Stack<Integer> stack = new Stack<>();
		stack.add(target);
		boolean check = false;

		for (int i = 0; i < op.size(); i++) {
			String cur_op = op.get(i);

			if (!operation(cur_op, stack)) {
				System.out.println("ERROR");
				check = true;
				break;
			}
		}

		if (!check) {
			if (stack.size() != 1)
				System.out.println("ERROR");
			else
				System.out.println(stack.pop());
		}
	}

	private static boolean operation(String op, Stack<Integer> stack) {
		int RANGE = 1000000000;
		int first = 0, second = 0;
		if (op.equals("POP")) {
			if (stack.isEmpty())
				return false;
			stack.pop();
		} else if (op.equals("INV")) {
			if (stack.isEmpty())
				return false;
			first = stack.pop();
			first *= -1;
			stack.add(first);
		} else if (op.equals("DUP")) {
			if (stack.isEmpty())
				return false;

			first = stack.peek();
			stack.add(first);
		} else if (op.equals("SWP")) {
			if (stack.size() <= 1)
				return false;

			first = stack.pop();
			second = stack.pop();

			stack.add(first);
			stack.add(second);
		} else if (op.equals("ADD")) {
			if (stack.size() <= 1)
				return false;

			first = stack.pop();
			second = stack.pop();

			first += second;
			if (Math.abs(first) > RANGE)
				return false;

			stack.add(first);
		} else if (op.equals("SUB")) {
			if (stack.size() <= 1)
				return false;

			first = stack.pop();
			second = stack.pop();

			second -= first;

			if (Math.abs(second) > RANGE)
				return false;

			stack.add(second);
		} else if (op.equals("MUL")) {
			if (stack.size() <= 1)
				return false;

			BigInteger f = new BigInteger(String.valueOf(stack.pop()));
			BigInteger s = new BigInteger(String.valueOf(stack.pop()));

			f =f.multiply(s);
			if (f.compareTo(new BigInteger("1000000000")) > 0)
				return false;

			stack.add(f.intValue());
		} else if (op.equals("DIV")) {
			if (stack.size() <= 1)
				return false;

			int count = 0;
			first = stack.pop();
			second = stack.pop();

			if (first < 0)
				count++;
			if (second < 0)
				count++;

			first = Math.abs(first);
			second = Math.abs(second);

			if (first == 0)
				return false;

			second /= first;

			if (count == 1) {
				second *= -1;
			}
			if (Math.abs(second) > RANGE)
				return false;

			stack.add(second);
		} else if (op.equals("MOD")) {
			if (stack.size() <= 1)
				return false;

			first = stack.pop();
			second = stack.pop();
			boolean check = false;

			if (second < 0) {
				check = true;
			}

			first = Math.abs(first);
			second = Math.abs(second);

			if (first == 0)
				return false;

			second %= first;

			if (Math.abs(first) > RANGE)
				return false;

			if (check) {
				second *= -1;
			}
			stack.add(second);
		} else if (op.indexOf("NUM") > -1) {
			String[] split = op.split(" ");
			stack.add(Integer.parseInt(split[1]));
		}

		return true;
	}

}
