package greedy;

//뒤집기
import java.util.*;

public class problem_1439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();

		int convert_zero = 0;
		// 0인 경우
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != '0') {
				convert_zero++;
				while(i+1 < line.length() && line.charAt(i+1) == '1')
					i++;
			}
		}

		int convert_one = 0;
		// 1인 경우
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != '1') {
				convert_one++;
				while(i+1 < line.length() && line.charAt(i+1) == '0')
					i++;
			}
		}
		
		System.out.println(Math.min(convert_zero, convert_one));
	}
}
