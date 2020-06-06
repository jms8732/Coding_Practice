package samsung_Atype;

//괄호 추가하기2
import java.util.*;
import java.io.*;

public class problem_16638 {
	static int answer = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String line = br.readLine();

		StringBuilder sb = new StringBuilder(line);
		simulation(1, N, sb);
		System.out.println(answer);
	}

	private static void simulation(int depth, int N, StringBuilder line) {
		if (depth >= line.length()) {
			int val = calculate(line.toString());
			answer = Math.max(val, answer);
			return;
		}

		line.insert(depth - 1, "(");
		line.insert(depth + 3, ")");

		simulation(depth + 6, N, line);

		line.deleteCharAt(depth - 1);
		line.deleteCharAt(depth + 2);

		simulation(depth + 2, N, line);
	}

	private static int calculate(String s) {
		StringBuilder sb = new StringBuilder();

		// 식에 존재하는 괄호 먼저 계산
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				int left = Character.digit(s.charAt(i + 1), 10);
				char op = s.charAt(i + 2);
				int right = Character.digit(s.charAt(i + 3), 10);
				sb.append(cal(left, op,right) +" ");
				i += 4;
			} else {
				sb.append(s.charAt(i) + " ");
			}
		}


		Deque<String> dq=  new LinkedList<>();
		String tmp = sb.toString().trim();
		String [] split = tmp.split(" ");
		
		for(int i= 0; i < split.length ; i++) {
			if(i % 2 == 0)
				dq.add(split[i]);
			else {
				if(split[i].equals("*")) {
					int v1 = Integer.parseInt(dq.pollLast());
					int v2 = Integer.parseInt(split[i+1]);
					int result = cal(v1,'*',v2);
					
					dq.add(String.valueOf(result));
					i += 1;
				}else
					dq.add(split[i]);
			}
		}
	
		while(dq.size() != 1) {
			int v1 = Integer.parseInt(dq.pollFirst());
			char op = dq.pop().charAt(0);
			int v2 = Integer.parseInt(dq.pollFirst());
			
			int result = cal(v1,op,v2);
			dq.addFirst(String.valueOf(result));
		}
		
	
		return Integer.parseInt(dq.poll());

	}

	private static int cal(int v1, char op, int v2) {
		switch (op) {
		case '-':
			return v1 - v2;
		case '+':
			return v1 + v2;
		case '*':
			return v1 * v2;
		}

		return -1;
	}
}
