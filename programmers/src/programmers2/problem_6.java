package programmers2;

//최대공약수와 최소공배수
public class problem_6 {
	public static void main(String[] args) {
		for(int i : solution(6,10))
		{
			System.out.print(i + " " );
		}
	}
	
	public static int [] solution(int n ,int m) {
		int small = Math.min(n, m);
		int big = Math.max(m, n);
		int mod=0;
		
		//유클리드 호제법
		while(true) {
			mod = big % small;
			if(mod == 0) 
				break;
			big = small;
			small = mod;
		}
		
		
		int [] answer = new int[2];
		answer[0] = small;
		
		int value1 = n / small;
		int value2 = m / small;
		
		answer[1] = value1 * value2 * small;
		
		
		return answer;
	}
}
