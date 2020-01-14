package programmers1;

//다음 큰 숫자
import java.util.*;

public class problem_39 {
	public static void main(String[] args) {
		int result = solution(15);
		System.out.println(result);
	}

	public static int solution(int n) {
		int bitCount = Integer.bitCount(n); //비트내에 1의 개수를 센다
		int tmpCount = 0;
		int answer =0 ;
		while(true) {
			n++;
			tmpCount = Integer.bitCount(n);
			if(bitCount == tmpCount)
			{
				answer = n;
				break;
			}
		}
		
		return answer;
	}
}
