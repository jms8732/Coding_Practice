package bruteForce;

//�Ѽ�
import java.util.*;
import java.io.*;

public class problem_1065 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int gap = Integer.parseInt(br.readLine());

		// ���̰� 2�� ���
		int count = 99;
		if (gap <= 99)
			count = gap;
		else {
			// ���̰� 3�̻��� ���
			count += checkProgressingNumber(gap);
		}
		System.out.println(count);
	}

	private static int checkProgressingNumber(int gap) {
		int count = 0;
		outter : for (int i = 100; i <= gap; i++) {
			String tmp = String.valueOf(i);

			for (int j = 2; j < tmp.length(); j++) {
				if (tmp.charAt(j -2) - tmp.charAt(j-1) != tmp.charAt(j-1) - tmp.charAt(j))
					continue outter;
			}
			count++;
		}

		return count;
	}

}
