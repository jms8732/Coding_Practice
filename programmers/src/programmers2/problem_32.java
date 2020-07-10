package programmers2;

//수식 최대화
import java.util.*;

public class problem_32 {
	static long answer = 0;
	public static void main(String[] args) {
		String exp = "100-200*300-500+20";
		System.out.println(solution(exp));
	}

	public static long solution(String expression) {
		String op[] = { "+", "-", "*" };
		permutation(0, op, expression);
		return answer;
	}

	private static void permutation(int depth, String[] op, String exp) {
		if (depth == 3) {
			long result = parsing(2, op, exp);
			answer = Math.max(answer, Math.abs(result));
			
			return;
		}
		for (int i = depth; i < op.length; i++) {
			swap(i, depth, op);
			permutation(depth + 1, op, exp);
			swap(depth, i, op);
		}
	}

	private static void swap(int depth, int i, String[] op) {
		String tmp = op[depth];
		op[depth] = op[i];
		op[i] = tmp;
	}

	private static long parsing(int idx, String[] op, String exp) {
		String[] split = exp.split("\\" + op[idx]);
		Deque<Long> dq = new LinkedList<>();
		for (int i = 0; i < split.length; i++) {
			if (split[i].contains("+") || split[i].contains("-") || split[i].contains("*")) {
				long tmp = parsing(idx - 1, op, split[i]);
				if(dq.isEmpty())
					dq.add(tmp);
				else {
					dq.add(calculate(dq.poll(),tmp,op[idx]));
				}
				
			} else {
				if (dq.isEmpty()) {
					dq.add(Long.parseLong(split[i]));
				} else {
					long tmp = dq.poll();
					dq.add(calculate(tmp, Long.parseLong(split[i]), op[idx]));
				}
			}
		}

		long result = dq.poll();

		return result;
	}

	private static long calculate(long opr1, long opr2, String op) {
		if (op.equals("+"))
			return opr1 + opr2;
		else if (op.equals("-"))
			return opr1 - opr2;
		else
			return opr1 * opr2;
	}
}
