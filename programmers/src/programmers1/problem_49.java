package programmers1;

//�ڸ��� ���ϱ�
public class problem_49 {
	public int solution(int n) {
		String tmp = String.valueOf(n);
		
		char[] array = tmp.toCharArray();
		int answer =0 ;
		for(int i =0 ; i< array.length ; i++) {
			answer += Character.digit(array[i], 10);
		}
		
		return answer;
	}
}
