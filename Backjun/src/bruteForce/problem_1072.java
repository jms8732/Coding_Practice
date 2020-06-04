package bruteForce;

//°ÔÀÓ
import java.util.*;
import java.io.*;

public class problem_1072 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int cur_win_percent = (int) (((double) Y*100 / (double) X));

		if (cur_win_percent >= 99)
			System.out.println(-1);
		else {
			int left = 0;
			int right = 1000000000;

			while (left <= right) {
				int mid = (left + right) / 2;

				int n_win_percent = (int) (((double) (Y + mid)*100 / (double) (X + mid)));
				if (cur_win_percent < n_win_percent)
					right = mid - 1;
				else
					left = mid + 1;
			}
			System.out.println(left);
		}
	}
}
