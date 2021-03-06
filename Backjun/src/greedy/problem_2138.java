package greedy;

//전구와 스위치
import java.util.*;
import java.io.*;

public class problem_2138 {
	static char[] A, B;
	static int IMPOSSIBLE = 10000001;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();

		char[] C = A.clone();
		int idx = 1, count = 0;
		answer = IMPOSSIBLE;

		// 첫번째 스위치를 안 누른 경우

		simulation(idx, count);

		// 누른 경우
		A = C;
		for (int i = 0; i < 2; i++) {
			if (A[i] == '0')
				A[i] = '1';
			else
				A[i] = '0';
		}

		simulation(idx, count + 1);

		if (answer == IMPOSSIBLE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	private static void simulation(int idx, int count) {

		if (idx == A.length - 1) {
			if (A[idx - 1] == B[idx - 1] && A[idx] == B[idx])
				answer = Math.min(answer, count);

			for (int i = -1; i < 1; i++) {
				if (A[idx + i] == '0')
					A[idx + i] = '1';
				else
					A[idx + i] = '0';
			}
			if (A[idx - 1] == B[idx - 1] && A[idx] == B[idx])
				answer = Math.min(answer, count+1);

			return;
		}

		// 스위치를 누르지 않은 경우
		if (A[idx - 1] == B[idx - 1])
			simulation(idx + 1, count);

		for (int i = -1; i < 2; i++) {
			if (A[idx + i] == '0')
				A[idx + i] = '1';
			else
				A[idx + i] = '0';
		}

		// 스위치를 누른 경우
		if (A[idx - 1] == B[idx - 1])
			simulation(idx + 1, count + 1);

	}

}
