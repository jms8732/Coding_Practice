package programmers1;

//자연수 뒤집어 배열로 만들기
public class problem_50 {
	public static void main(String[] args) {
		int n = 12345;
		int[] result = solution(n);
		for(int i : result)
			System.out.print(i + " ");
	}
	public static int[] solution(long n ) {
		String tmp = Long.toString(n);
		int [] answer = new int[tmp.length()];
		for(int i = 0; i < tmp.length() ; i++)
			answer[i] = Character.digit(tmp.charAt(tmp.length()-1-i), 10);
		
		
		return answer;
	}
}
