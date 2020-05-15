package bruteForce;

//리모컨
import java.io.*;
import java.util.*;

public class problem_1107 {
	static boolean[] button;
	static String target;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		target = br.readLine();
		int N = Integer.parseInt(br.readLine());
		button = new boolean[10];
		Arrays.fill(button, true);
		if (N != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				button[Integer.parseInt(st.nextToken())] = false;
			}
		}

		if (target.equals("100"))
			System.out.println(0);
		else {

			int tar = Integer.parseInt(target);
			answer = Math.min(answer, Math.abs(tar - 100));

			if (N != 10) {
				StringBuilder sb = new StringBuilder();

				// 100에서 목표 도달하는 데까지 의 숫자 파악

				for (int i = 1; i <= target.length()+1; i++) {
					goTochannel(0, i, button, sb);
				}
			}

			System.out.println(answer);
		}
	}

	private static void goTochannel(int depth, int N, boolean[] button, StringBuilder sb) {
		if (depth == N) {
			int tar = Integer.parseInt(target);
			int number = Integer.parseInt(sb.toString());

			answer = Math.min(answer, depth + Math.abs(tar - number));
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (button[i]) {
				sb.append(i);
				goTochannel(depth + 1, N, button, sb);
				sb.delete(sb.length() - 1, sb.length());
			}
		}
	}
}
