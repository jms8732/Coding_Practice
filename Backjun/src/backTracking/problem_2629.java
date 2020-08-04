package backTracking;

import java.io.BufferedReader;
import java.util.*;
import java.io.*;

//양팔 저울
public class problem_2629 {
	static boolean[][] cache;
	static int[] sinker;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		sinker = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sinker[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());

		int[] bead = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			bead[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < bead.length; i++) {
			int target = bead[i];

			cache = new boolean[31][15001];

			if (target > 15000)
				bw.write("N ");
			else if (dp(sinker.length - 1, target))
				bw.write("Y ");
			else
				bw.write("N ");
		}

		bw.flush();
	}

	private static boolean dp(int remain, int target) {
		if (remain == -1 || target == 0) {
			if (target == 0)
				return true;
			return false;
		}

		if (cache[remain][target])
			return false;

		cache[remain][target] = true;

		// 오른편에 추를 둘 경우
		if (dp(remain - 1, Math.abs(target - sinker[remain])))
			return true;

		// 추를 두지 않는 경우
		if (dp(remain - 1, target))
			return true;

		// 왼편에 추를 둘 경우
		if (dp(remain - 1, target + sinker[remain]))
			return true;

		return false;
	}
}
