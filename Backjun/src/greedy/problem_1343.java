package greedy;

//폴리오미노
import java.io.*;
import java.util.*;

public class problem_1343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String size = br.readLine();
		StringBuilder sb = new StringBuilder();
		boolean check = false;
		for (int i = 0; i < size.length(); i++) {
			if (size.charAt(i) == '.') {
				sb.append(".");
				continue;
			}
			int len = 0;
			for (int j = i + 1; j < size.length(); j++) {
				len = j;
				if (size.charAt(j) == '.') {
					len -= 1;
					break;
				}
			}
			len -= i;
			len += 1;

			int end = i + len - 1;

			if (len / 4 > 0) {
				for (int j = 0; j < len / 4; j++)
					sb.append("AAAA");

				len %= 4;
			}

			if (len / 2 > 0) {
				for (int j = 0; j < len / 2; j++) {
					sb.append("BB");
				}

				len %= 2;
			}

			if (len != 0) {
				check = true;
				break;
			}

			i = end;
		}

		if (check)
			System.out.println("-1");
		else
			System.out.println(sb.toString());
	}
}
