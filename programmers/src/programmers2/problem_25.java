package programmers2;

//예상 대진표

public class problem_25 {
	public static void main(String[] args) {
		int N = 8;
		int A = 4;
		int B = 7;
		
		int result = solution(N,A,B);
		System.out.println(result);
	}
	
	public static int solution(int n, int a, int b) {

		int step = 1;
		while (true) {
			int a_rival = rival_number(a);
			int b_rival = rival_number(b);
			
			if(a_rival == b && b_rival == a)
				break;
			
			a = next_number(a);
			b = next_number(b);
			step++;
			
		}
		
		return step;
	}
	private static int next_number(int target) {
		if(target % 2 != 0)
			target += 1;
		
		target /= 2;
		
		return target;
	}

	private static int rival_number(int target) {
		// 현재 숫자가 홀수인 경우
		int rival = 0;
		if (target % 2 != 0) {
			rival = target + 1;
		} else {
			rival = target - 1;
		}
		
		return rival;
	}
}
