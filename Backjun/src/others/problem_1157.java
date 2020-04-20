package others;

//단어 공부
import java.util.*;

public class problem_1157 {
	public static void main(String[] args0) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.nextLine();
		int [] alphabet = new int[26];
		
		int big = 0;
		for(int i= 0 ; i < line.length() ; i++) {
			char cur = Character.toLowerCase(line.charAt(i));
			
			alphabet[cur- 'a'] += 1;
			big = Math.max(big, alphabet[cur-'a']);
			
		}
		
		char answer = ' ';
		int count = 0;
		for(int i =0 ; i< alphabet.length ; i++) {
			if(big == alphabet[i]) {
				if(count >= 1) {
					System.out.println("?");
					System.exit(0);
				}
				answer = (char)('a' + i);
				count++;
			}
		}
		System.out.println(Character.toUpperCase(answer));
	}
}
