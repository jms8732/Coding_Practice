package programmers;

//124 ����
public class problem_9 {
	public static void main(String[] args) {
		String result = solution(10);
		System.out.println(result);
	}

	public static String solution(int n) {
		String answer = "";
		while (n > 0) {
			int rest = n % 3;
			n = n / 3;

			if (rest == 0) {
				rest = 4;
				n -= 1;
			}
			answer = rest + answer;
		}
		
		return answer;
	}
}
