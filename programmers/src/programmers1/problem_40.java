package programmers1;

//두 정수사이의 합
public class problem_40 {
	public static void main(String[] args) {
		
	}
	public static long solution(int a, int b) {
		int big = 0 , small =0;
		if(a < b) {
			big = b;
			small =a;
		}else if(a > b)
		{
			big = a;
			small = b;
		}else {
			big = b;
			small = a;
		}
		
		long answer =0;
		
		for(int i = small ; i <= big ; i++) {
			answer += i ;
		}
		
		
		return answer;
	}
}
