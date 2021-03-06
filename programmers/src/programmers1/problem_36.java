package programmers1;
//숫자의 표현

public class problem_36 {
	public static void main(String[] args) {
		int result = solution(15);
		System.out.println(result);
	}

	public static int solution(int n) {
		int answer = 0;
		int idx = 1;
		while (idx <= n) {
			int sum = 0;
			int index = idx;
			while(true) {
				sum += index;
				if(sum == n) { //연속한 자연수들로 n이 표현이 가능한 경우
					answer++;
					break;
				}
				if(sum > n) //연속한 자연수들로 n을 초과하는 경우
					break;
				index++;
			}
			idx++;
		}

		return answer;
	}
}
