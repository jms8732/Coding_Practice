package others;

/*
 * �� ��
 * ���� ����
 * ���� ���̸� �������� ������ ���� ���� ����, ������ ���� ���� ���̸� ���� �� �������� �� ���� �� �ּ� ���̸� ���Ѵ�.
 * �� ��, ���� ���̿� �ּ� ���� ���� ���ϵ�, ���� ������ ��� ������ �ʴ´�.
 */
import java.io.*;
import java.util.*;

public class problem_14719 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] array = new int[m];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++)
			array[i] = Integer.parseInt(st.nextToken());

		int rain = 0;
		for (int i = 1; i < m-1; i++) {
			int left_h = 0;
			for (int left = i - 1; left >= 0; left--) {
				left_h = Math.max(left_h, array[left]);
			}

			int right_h = 0;
			for (int right = i + 1; right < m; right++) {
				right_h = Math.max(right_h, array[right]);
			}

			int min_h = Math.min(left_h, right_h);

			if (min_h - array[i] > 0)
				rain += min_h - array[i];
		}

		System.out.println(rain);
	}
}
