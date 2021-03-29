package others;

/*
 * A와 B
 * 반대로 생각한다. S를 2개의 규칙을 이용해서 만드는 것이 아닌 T를 2개의 규칙을 이용해서 S로 되는지를 판단한다.
 */
import java.util.*;
import java.io.*;

public class problem_12094 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		br.close();
		
		simulation(S,T);

	}

	private static void simulation(String S , String T) {
		StringBuilder sb = new StringBuilder(T);
		while(S.length() != sb.length()) {
			char temp = sb.charAt(sb.length()-1);
			
			sb = sb.deleteCharAt(sb.length()-1);
			if(temp == 'B') {
				//마지막 문자가 B인 경우
				sb = sb.reverse(); //뒤집는다.
			}
		}
		
		if(S.equals(sb.toString()))
			System.out.println(1);
		else
			System.out.println(0);
	}
}
