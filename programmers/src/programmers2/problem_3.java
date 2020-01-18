package programmers2;

//정수 제곱근 판별
public class problem_3 {
	public static void main(String[] args) {
		long result = solution(100);
		System.out.println(result);
	}
	public static long solution(long n) {
		double value = (double)Math.sqrt(n); //제곱근
		int in = (int)Math.sqrt(n);
		
		
		
		if((value - in) == 0) {
			//제곱수 인 경우
			return (long)Math.pow(value+1, 2);
		}else
			return -1;
	}
}
