package programmers1;

//수박수박수박수박수박수?
public class problem_44 {
	public static String solution(int n) {
		char[] array = {'수','박'};
		StringBuilder sb= new StringBuilder();
		for(int i =0 ; i< n ; i++) {
			sb.append(array[i%array.length]);
		}
		
		return sb.toString();
	}
}
