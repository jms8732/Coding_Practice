package string;

//��� ������ �߸��Ǿ����ϴ�.
import java.util.*;
import java.io.*;

public class problem_5177 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			String line1 = preProcessing(br.readLine());
			String line2 = preProcessing(br.readLine());

			if (line1.equals(line2)) {
				System.out.println("Data Set " + (i + 1) + ": " + "equal");
			} else
				System.out.println("Data Set " + (i + 1) + ": " + "not equal");
			System.out.println();
		}
	}

	private static String preProcessing(String line) {
		line = line.trim();
		line = line.toLowerCase();

		line = line.replaceAll("\\{", "(");
		line = line.replaceAll("\\}", ")");

		line = line.replaceAll("\\[", "(");
		line = line.replaceAll("\\]", ")");

		line = line.replaceAll(";", ",");

		char [] tmp = line.toCharArray();
		
		for (int i = 0; i < tmp.length; i++) {
			char cur = tmp[i];

			// ���� ���ڰ� Ư������ �� ���
			if ((cur != '*' && cur != ' ') && (cur < '0' || cur > '9') && (cur < 'a' || cur > 'z')) {
				int left = i - 1;
				int right = i + 1;

				// ������ ���� ���� ���� �ϸ� ������ ���
				while(left >= 0 && tmp[left] == ' ') {
					tmp[left--] = '*';
				}
				// �������� ���� ���� �����ϸ� ������ ���
				while(right < tmp.length && tmp[right] == ' ') {
					tmp[right++] = '*';
				}
			}
		}
		
		line = String.copyValueOf(tmp).replaceAll("\\*", "");

		StringBuilder sb = new StringBuilder();
		String[] split = line.split(" ");

		for (int i = 0; i < split.length; i++) {
			String target = split[i].trim();

			// ������ ���
			if (target.isEmpty())
				continue;

			sb.append(target);
			sb.append(" ");
		}

		return sb.toString().trim();
	}
}
