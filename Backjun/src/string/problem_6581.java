package string;

//HTMl
import java.util.*;
import java.io.*;

public class problem_6581 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = null;

		int word_count = 0;
		while ((tmp = br.readLine()) != null) {
			String[] split = tmp.split(" |\t");

			for (int i = 0; i < split.length; i++) {
				String word = split[i];

				// 개행 문자인 경우
				if (word.equals("<br>")) {
					word_count = 0;
					System.out.println();
					continue;
				}

				// <hr> 인 경우

				if (word.equals("<hr>")) {
					if (word_count != 0)
						System.out.println();

					for (int j = 0; j < 80; j++) {
						System.out.print("-");
					}

					System.out.println();
					word_count = 0;
					continue;
				}

				if (word.isEmpty())
					continue;

				if (word_count + word.length() <= 80) {
					System.out.print(word);
					word_count += word.length();

				} else {
					// 출력된 글자가 80개가 넘은 경우, 개행한 후 단어 출력
					System.out.println();
					System.out.print(word);
					word_count = word.length();
				}

				if (word_count < 80) {
					System.out.print(" ");
					word_count++;
				}
			}
		}
	}
}
