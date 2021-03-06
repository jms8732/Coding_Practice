package samsung_Atype;

//괄호 추가하기

import java.util.*;
import java.io.*;

public class problem_16637 {
	static int value = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String line = br.readLine(); // 수식
		br.close();
		StringBuilder sb = new StringBuilder(line);
		int depth = 1;
		dfs(depth, line, sb);
		System.out.println(value);
	}

	private static void dfs(int depth, String line, StringBuilder sb) {
		if (depth >= sb.length()) {
			// 현재 좌표가 주어진 식보다 길이가 길 경우
			calculate(sb.toString());
			return;
		}

		/*
		 * 괄호가 있는 경우와 괄호가 없는 경우를 생각한다. 먼저 괄호가 있는 경우
		 */
		StringBuilder tmpSb = new StringBuilder(sb.toString());
		sb.insert(depth - 1, '(');
		sb.insert(depth + 3, ')');
		dfs(depth + 6, line, sb);

		// 괄호의 경우가 끝난 경우
		sb = tmpSb;
		dfs(depth + 2, line, sb);

	}

	private static void calculate(String s) {
		// 계산은 괄호 우선순위만 유지하고 왼쪽부터 오른쪽으로 계산한다.
		StringBuilder sb = new StringBuilder();

		// 식에 존재하는 괄호 먼저 계산
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				int left = Character.digit(s.charAt(i + 1), 10);
				char op = s.charAt(i + 2);
				int right = Character.digit(s.charAt(i + 3), 10);
				sb.append(calculate(left, right, op) +" ");
				i += 4;
			} else {
				sb.append(s.charAt(i) + " ");
			}
		}

		StringTokenizer st = new StringTokenizer(sb.toString().trim());
		Deque<String> dq = new LinkedList<>();
		while(st.hasMoreTokens()) {
			dq.add(st.nextToken());
		}
	
		while(!dq.isEmpty()) {
			if(dq.size() == 1)
				break;
			int left = Integer.parseInt(dq.pollFirst());
			char op = dq.poll().charAt(0);
			int right = Integer.parseInt(dq.poll());
			
			dq.addFirst(Integer.toString(calculate(left,right,op)));
		}
		String result = dq.poll();
		
		value = Math.max(value, Integer.parseInt(result));
	}

	private static int calculate(int v1, int v2, char op) {
		int sum = 0;
		switch (op) {
		case '+':
			sum = v1 + v2;
			break;
		case '-':
			sum = v1 - v2;
			break;
		case '*':
			sum = v1 * v2;
			break;
		case '/':
			sum = v1 / v2;
			break;
		}

		return sum;
	}
}
