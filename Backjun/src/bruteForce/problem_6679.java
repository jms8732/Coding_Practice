package bruteForce;

//싱기한 네자리 숫자
import java.util.*;

public class problem_6679 {
	public static void main(String[] args) {
		for (int i = 1000; i < 10000; i++) {
			int ten = ten(i);
			int twelve = twelve(i);
			int hex = hex(i);
			
			if(ten == twelve && twelve == hex)
				System.out.println(i);
		}
	}
	
	private static int hex(int t) {
		String tar = Integer.toHexString(t);
		int ret =0 ;
		for(int i =0 ; i < tar.length() ; i++) {
			if(tar.charAt(i) >= 'a' && tar.charAt(i) <= 'f')
				ret += tar.charAt(i) - 'a' + 10;
			else
				ret += tar.charAt(i) - '0';
		}
		
		return ret;
	}

	private static int twelve(int t) {
		StringBuilder sb = new StringBuilder();
		int ret = 0;

		while (true) {
			int temp = t % 12;

			if(t == 0)
				break;

			if (temp == 10)
				sb.insert(0, 'A');
			else if (temp == 11)
				sb.insert(0, 'B');
			else
				sb.insert(0, temp);

			t = t / 12;
		}

		for(int i =0 ; i < sb.length();  i++) {
			if(sb.charAt(i) == 'A')
				ret += 10;
			else if (sb.charAt(i) == 'B')
				ret += 11;
			else
				ret += sb.charAt(i) - '0';
		}
		
		return ret;
	}

	private static int ten(int t) {
		String tar = String.valueOf(t);
		int ret = 0;
		for (int i = 0; i < tar.length(); i++) {
			ret += tar.charAt(i) - '0';
		}

		return ret;
	}
}
