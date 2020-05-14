package string;

//´ÙÀÌ¾ó
import java.util.*;
import java.io.*;

public class problem_5622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();

		int timer = 0;
		for (int i = 0; i < tmp.length(); i++) {
			char cur = tmp.charAt(i);
			timer += time(cur);
		}
		System.out.println(timer);
	}

	private static int time(char c) {
		int start = 2;
		if (c == 'A' || c == 'B' || c == 'C')
			return 3;
		else if (c == 'D' || c == 'E' || c == 'F')
			return 4;
		else if (c == 'G' || c == 'H' || c == 'I')
			return 5;
		else if (c == 'J' || c == 'K' || c == 'L')
			return 6;
		else if (c == 'M' || c == 'N' || c == 'O')
			return 7;
		else if (c == 'P' || c == 'Q' || c == 'R' || c == 'S')
			return 8;
		else if (c == 'T' || c == 'U' || c == 'V')
			return 9;
		else if (c == 'W' || c == 'X' || c == 'Y' || c == 'Z')
			return 10;

		return start;
	}
}
