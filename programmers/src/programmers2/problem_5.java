package programmers2;

//ÃÖ´ñ°ª°ú ÃÖ¼Ú°ª
public class problem_5 {
	public static void main(String[] args) {
		System.out.println(solution("-1 -2 -3 -4"));
	}
	public static String solution(String s) {
		String[] tmp = s.split(" " );
		int big = Integer.MIN_VALUE , small = Integer.MAX_VALUE;
		
		for(int i =0 ; i< tmp.length ; i++) {
			int value = Integer.parseInt(tmp[i]);
			
			big= Math.max(big, value);
			small = Math.min(small, value);
		}
		
		
		String answer = small + " " + big;
		
		return answer;
	}
}
