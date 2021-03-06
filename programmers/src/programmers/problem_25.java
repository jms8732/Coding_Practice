package programmers;

//���� ū��
import java.util.*;

public class problem_25 {
	public static void main(String[] args) {
		int tmp[] = { 0, 0, 0 };
		String result = solution(tmp);
		System.out.println(result);
	}

	public static String solution(int[] numbers) {
		PriorityQueue<Value> queue = new PriorityQueue<>();
		for (int i = 0; i < numbers.length; i++) {
			Value vTmp = new Value(Integer.toString(numbers[i]));
			queue.add(vTmp);
		}

		StringBuilder sb = new StringBuilder();
		// String last = queue.poll().v1;
		String[] tmp = new String[queue.size()];
		for (int i = queue.size() - 1; i >= 0; i--) {
			tmp[i] = queue.poll().v1;
		}
		boolean check = false;
		for (int i = 0; i < tmp.length; i++) {
			if (!tmp[i].equals("0")) {
				check = true;
				break;
			}
		}
		if (!check) {
			sb.append("0");
		} else {
			for (int i = 0; i < tmp.length; i++) {
				sb.append(tmp[i]);
			}
		}
		return sb.toString();

	}

}

class Value implements Comparable<Value> {
	String v1;

	public Value(String value) {
		this.v1 = value;
	}

	@Override
	public int compareTo(Value v2) {
		// TODO Auto-generated method stub

		int i1 = 0;
		int i2 = 0;
		while (true) {
			int value1 = this.v1.charAt(i1) - '0';
			int value2 = v2.v1.charAt(i2) - '0';
			if (value1 > value2)
				return 1;
			else if (value1 < value2)
				return -1;

			if (i1 == this.v1.length() - 1 && i2 == v2.v1.length() - 1)
				return 0;
			else {
				i1 = (i1 + 1) % this.v1.length();
				i2 = (i2 + 1) % v2.v1.length();
			}

		}
	}
}
