package programmers1;

//���ڼ��ڼ��ڼ��ڼ��ڼ�?
public class problem_44 {
	public static String solution(int n) {
		char[] array = {'��','��'};
		StringBuilder sb= new StringBuilder();
		for(int i =0 ; i< n ; i++) {
			sb.append(array[i%array.length]);
		}
		
		return sb.toString();
	}
}
