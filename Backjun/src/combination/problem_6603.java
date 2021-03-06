package combination;

//6603. �ζ�
import java.util.*;
import java.io.*;

public class problem_6603 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			if(N == 0)
				break;
			
			int[] array = new int[N];
			int[] answer = new int[6];

			for (int i = 0; i < N; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
			int depth = 0, next = 0;

			combination(depth, next, array, answer);
			System.out.println();
		}
	}

	private static void combination(int depth, int next, int[] array, int[] answer) {
		if (depth == 6) {
			for (int i = 0; i < answer.length; i++)
				System.out.print(answer[i] + " ");
			System.out.println();
			return;
		}

		for (int i = next; i < array.length; i++) {
			answer[depth] = array[i];
			combination(depth + 1, i + 1, array, answer);
		}
	}
}
