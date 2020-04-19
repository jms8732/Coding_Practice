package programmers2;

//ÇÏ»þµå ¼ö
public class problem_26 {
	public static boolean solution(int x) {
		String val = Integer.toString(x);
		
		int tmp = 0;
		for(int i =0 ; i < val.length() ; i++)
			tmp += val.charAt(i) - '0';
		
		if(x % tmp == 0)
			return true;
		else
			return false;
	}
}
