package samsung_Atype;

//괄호 넣기
import java.util.*;
import java.io.*;

public class problem_16637_1 {
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();
		StringBuilder sb = new StringBuilder(line);

		if (line.length() >= 5) {
			simulation(N, 1, sb);
			System.out.println(answer);
		} else {
			if (line.length() == 1)
				System.out.println(line);
			else
				System.out.println(calculate(line));
		}

	}

	private static void simulation(int N, int op_cur, StringBuilder sb) {
		if (op_cur >= sb.length()) {
			int cal = calculate(sb.toString());
			answer = Math.max(cal, answer);
			return;
		}
		// 현재 연산자에서 괄호를 넣는 경우
		int left = op_cur - 1;
		int right = op_cur + 2;

		sb.insert(right, ")");
		sb.insert(left, "(");

		simulation(N, op_cur + 6, sb);

		sb.deleteCharAt(left);
		sb.deleteCharAt(right);

		// 안붙이는 경우
		simulation(N, op_cur + 2, sb);
	}

	private static int calculate(String l) {
		StringBuilder line = new StringBuilder(l);
		int idx = 0;
		while ((idx = line.indexOf("(")) >= 0) {
			int opr1 = line.charAt(idx + 1) - '0';
			char op = line.charAt(idx + 2);
			int opr2 = line.charAt(idx + 3) - '0';

			int result = cal(opr1, op, opr2);

			line.delete(idx, idx + 5);
			line.insert(idx, result);
		}
		boolean check = true;
		while (check) {
			StringBuilder opr1 = new StringBuilder();
			int anchor = 0;
			for (int i = 0; i < line.length(); i++) {
				char cur = line.charAt(i);
				anchor = i;
				if (cur >= '0' && cur <= '9')
					opr1.append(cur);
				else if (i == 0 && cur == '-')
					opr1.append(cur);
				else {
					break;
				}
			}

			char op = line.charAt(anchor);

			StringBuilder opr2 = new StringBuilder();
			for (int i = anchor + 1; i < line.length(); i++) {
				char cur = line.charAt(i);
				anchor = i;
				if (cur >= '0' && cur <= '9')
					opr2.append(cur);
				else if (i - 1 >= 0 && (line.charAt(i - 1) < '0' || line.charAt(i - 1) > '9'))
					opr2.append(cur);
				else {
					break;
				}
			}

			int v1 = Integer.parseInt(opr1.toString());
			int v2 = Integer.parseInt(opr2.toString());

			if (anchor + 1 == line.length()) {
				anchor += 1;
				check = false;
			}
			int result = cal(v1, op, v2);

			line.delete(0, anchor);
			line.insert(0, result);
		}

		return Integer.parseInt(line.toString());
	}

	private static int cal(int opr1, char op, int opr2) {
		switch (op) {
		case '-':
			return opr1 - opr2;
		case '+':
			return opr1 + opr2;
		case '*':
			return opr1 * opr2;
		}

		return -1;
	}
}
