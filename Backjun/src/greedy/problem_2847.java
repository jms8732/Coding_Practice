package greedy;

//������ ����� ������
import java.util.*;
import java.io.*;

public class problem_2847 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] array = new int[N];

		for (int i = 0; i < array.length; i++)
			array[i] = Integer.parseInt(br.readLine());

		int ans = 0;

		int prev = array[array.length - 1];
		for (int i = array.length - 2; i >= 0; i--) {
			if (prev < array[i]) {
				// ���� �������� ���� ������ ������ �� ���� ���
				int diff = Math.abs(prev - array[i]) + 1;
				array[i] -= diff;
				ans += diff;
			}
			prev = array[i];
		}
		System.out.println(ans);
	}
}
