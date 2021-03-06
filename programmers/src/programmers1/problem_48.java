package programmers1;

import java.util.*;

//�̻��� ���� �����

public class problem_48 {
	public static void main(String[] args) {
		String s = "try";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) == ' ')
				queue.add(i); // ��ĭ ��ǥ

		String[] tmp = s.split(" "); // ��ĭ���� ������

		for (int j = 0; j < tmp.length; j++) {
			String tmpp = tmp[j];
			for (int i = 0; i < tmpp.length(); i++) {
				if (i % 2 == 0)// ¦���� ���
					sb.append(Character.toUpperCase(tmpp.charAt(i)));
				else // Ȧ�� �� ���
					sb.append(Character.toLowerCase(tmpp.charAt(i)));
			}
		}
		if(queue.isEmpty())
			return sb.toString();
		
		StringBuilder answer = new StringBuilder();
		int idx = 0, eidx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!queue.isEmpty())
				eidx = queue.peek();
			if (i != eidx)
				answer.append(sb.charAt(idx++));
			else if (i == eidx) {
				answer.append(' ');
				queue.poll();
			}
		}

		return answer.toString();
	}
}
