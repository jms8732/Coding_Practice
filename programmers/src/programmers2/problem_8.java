package programmers2;

//Äİ¶óÃ÷ ÃßÃø

public class problem_8 {
	public static void main(String[] args) {
		int n = 626331;
		System.out.println(solution(n));
	}
	public static int solution(int num) {
		int round = 0;
		long i= num;
		while(true) {
			if(i == 1)
			{
				break;
			}
			
			if(round == 500)
			{
				round = -1;
				break;
			}
			
			if(i % 2 == 0) {
				//Â¦¼öÀÌ¸é
				i /= 2;
			}else
				i = 3*i + 1;
			round++;
		}
		
		
		return round;
	}
}
