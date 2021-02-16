package greedy;

//게임을 만드는 동준이
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
				// 높은 레벨보다 낮은 레벨의 점수가 더 높은 경우
				int diff = Math.abs(prev - array[i]) + 1;
				array[i] -= diff;
				ans += diff;
			}
			prev = array[i];
		}
		System.out.println(ans);
	}
}
