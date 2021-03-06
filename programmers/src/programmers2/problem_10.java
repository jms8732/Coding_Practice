package programmers2;


//피보나치 수
public class problem_10 {
	public static void main(String [] args) {
		System.out.println(solution(3));
	}
	public static int solution(int n) {
		int answer =0 ;
		int MOD = 1234567;
		if(n == 0)
			return 0;
		if(n == 2 || n == 1)
			return 1;
		
		int [] arr = new int[n];
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i = 2; i < arr.length ; i++)
			arr[i] = arr[i-1]% MOD  + arr[i-2] %MOD;
		
		return arr[n-1] % MOD;
	}
}
