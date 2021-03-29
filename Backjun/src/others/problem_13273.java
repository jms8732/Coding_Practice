package others;

/*
 * 로마숫자
 * 문제에서 주어진 조건대로 구현을 진행하면 된다.
 */
import java.util.*;
import java.io.*;

public class problem_13273 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			String temp = br.readLine();

			try {
				int digit = Integer.parseInt(temp);
				convertDigitToRoma(digit, temp.length());
			} catch (Exception e) {
				convertRomaToDigit(temp);
			}
		}

	}

	private static void convertRomaToDigit(String r) {
		int ans = 0;

		for (int i = 0; i < r.length(); i++) {
			char cur = r.charAt(i);

			if (cur == 'I') {
				char next = i + 1 < r.length() ? r.charAt(i + 1) : ' ';
				if (next == 'X' || next == 'V') {
					if (next == 'X')
						ans += 9;
					else
						ans += 4;
					i++;
				} else
					ans += 1;
			} else if (cur == 'V')
				ans += 5;
			else if (cur == 'X') {
				char next = i + 1 < r.length() ? r.charAt(i + 1) : ' ';

				if (next == 'L' || next == 'C') {
					if (next == 'L')
						ans += 40;
					else
						ans += 90;
					i++;
				} else
					ans += 10;
			} else if (cur == 'L')
				ans += 50;
			else if (cur == 'C') {
				char next = i + 1 < r.length() ? r.charAt(i + 1) : ' ';

				if (next == 'D' || next == 'M') {
					if (next == 'D')
						ans += 400;
					else
						ans += 900;
					i++;
				} else
					ans += 100;
			} else if (cur == 'D')
				ans += 500;
			else if (cur == 'M')
				ans += 1000;
		}

		System.out.println(ans);
	}

	private static void convertDigitToRoma(int digit, int p) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= p; i++) {
			int mod = (int) Math.pow(10, p - i);
			int div = (digit / mod);
			div *= mod;
			if (div == 900 || div == 90 || div == 9) {
				if (div == 900)
					sb.append("CM");
				else if (div == 90)
					sb.append("XC");
				else
					sb.append("IX");
			} else if (div == 400 || div == 40 || div == 4) {
				if (div == 400)
					sb.append("CD");
				else if (div == 40)
					sb.append("XL");
				else
					sb.append("IV");
			} else {
				StringBuilder temp = new StringBuilder();
				char c = ' ';
				if (mod == 1000)
					c = 'M';
				else if (mod == 100)
					c = 'C';
				else if (mod == 10)
					c = 'X';
				else
					c = 'I';

				int count = digit / mod;
				
				if(count >= 5) {
					if(count * mod >= 500)
						temp.append("D");
					else if(count * mod >= 50)
						temp.append("L");
					else if(count * mod >= 5)
						temp.append("V");
					

					count -= 5;
				}
				
				for(int j =0 ; j < count ; j++) {
					temp.append(c);
				}
				
				sb.append(temp);
			}
			
			digit -= div;
		}
		
		System.out.println(sb.toString());
	}

}
