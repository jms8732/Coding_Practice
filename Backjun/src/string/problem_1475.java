package string;

//¹æ ¹øÈ£
import java.util.*;

public class problem_1475 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		int[] number = new int[10];

		int answer = 0;
		for (int i = 0; i < line.length(); i++) {
			char cur = line.charAt(i);

			if (number[cur - '0'] == 0) {
				if (cur == '9' || cur == '6') {
					if (cur == '9' && number['6' - '0'] != 0) {
						number['6' - '0']--;
						continue;
					} else if (cur == '6' && number['9' - '0'] != 0) {
						number['9' - '0']--;
						continue;
					}
				}
				fill(number);
				number[cur - '0']--;
				answer++;
			} else {
				--number[cur - '0'];
			}
		}

		System.out.println(answer);
	}

	private static void fill(int[] number) {
		for (int i = 0; i < number.length; i++) {
			number[i] += 1;
		}
	}
}
