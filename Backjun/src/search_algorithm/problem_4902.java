package search_algorithm;

//�ﰢ���� ��
import java.util.*;
import java.io.*;

public class problem_4902 {
	static int[][] triangle;
	static int big = Integer.MIN_VALUE;
	static int[][] cache;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = null;
		StringTokenizer st = null;
		int step = 1;
		while (true) {
			tmp = br.readLine();

			if (tmp.equals("0"))
				break;

			st = new StringTokenizer(tmp);

			int N = Integer.parseInt(st.nextToken());
			triangle = new int[N][];
			cache = new int[N][];
			int idx = 1;
			for (int i = 0; i < N; i++) {
				int[] array = new int[idx];

				for (int j = 0; j < array.length; j++) {
					array[j] = Integer.parseInt(st.nextToken());
					big = Math.max(array[j], big);
				}
				triangle[i] = array;
				cache[i] = array.clone();

				idx += 2;
			}

			boolean check = false;
			for (int s = 1; s < N; s++) {
				for (int i = 0; i < triangle.length; i++) {
					for (int j = 0; j < triangle[i].length; j++) {
						if (j % 2 == 0 && i + s < triangle.length) {
							cache[i][j] = calculate(check, s, s + i, i, j);
						}
					}
				}

				check = !check;
				
				for (int i = triangle.length - 1; i > 0; i--) {
					for (int j = 0; j < triangle[i].length; j++) {
						if (j % 2 != 0 && i - s > 0) {
							cache[i][j] = calculate(check,s, i - s, i, j);
						}
					}
				}
				
				check = !check;
			}

			System.out.println(step + ". " + big);
			step++;
			big = Integer.MIN_VALUE;
		}
	}

	private static int calculate(boolean c, int step, int next, int x, int y) {
		int value = cache[x][y];
		if (!c) {
			int left = y;
			int right = left + 2 * step;

			for (int i = left; i <= right; i++) {
				value += triangle[next][i];
			}
		}else {
			int right = y;
			int left = right - 2 * step;
			
			if(left >= 0 && right < triangle[next].length) {
				for(int i = left ; i <= right ; i++) {
					value += triangle[next][i];
				}
			}
		}

		big = Math.max(big, value);
		return value;
	}

}
