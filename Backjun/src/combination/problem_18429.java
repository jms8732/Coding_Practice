package combination;

//�ټս�
import java.util.*;
import java.io.*;

public class problem_18429 {
	static int N = 0, K = 0;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			array[i] = Integer.parseInt(st.nextToken());

		int[] answer = new int[N];

		permutation(0, array, answer);
		System.out.println(count);
	}

	private static boolean exercise(int[] routine) {
		int weight = 500;
		for (int i = 0; i < N; i++) {
			weight += routine[i];
			if (weight - K < 500)
				return false;
			weight -= K;
		}

		return true;
	}

	private static void permutation(int depth, int[] array, int[] answer) {
		if (N == depth) {
			if (exercise(answer)) {
				count++;
			}
			return;

		}

		for (int i = depth; i < N; i++) {
			answer[depth] = array[i];
			swap(depth, i, array);
			permutation(depth + 1, array, answer);
			swap(i, depth, array);
		}
	}

	private static void swap(int depth, int i, int[] array) {
		int tmp = array[depth];
		array[depth] = array[i];
		array[i] = tmp;
	}
}
