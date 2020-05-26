package bruteForce;

//유레카 이론
import java.util.*;
import java.io.*;

public class problem_10448 {
	static int[] tri;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		tri = new int[46];

		// 삼각수 구하기
		for (int i = 1; i < tri.length; i++) {
			tri[i] = (i * (i + 1)) / 2;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < tc; i++) {
			int number = Integer.parseInt(br.readLine());
			int size = 0;
			for (int j = 1; j < tri.length; j++) {
				if (number <= tri[j]) {
					size = j;
					if (number < tri[j])
						size = j - 1;
					break;
				}
			}

			int[] array = new int[size];
			System.arraycopy(tri, 1, array, 0, size);
			int[] val = new int[3];
			if (reCombination(0, 0, array, val, number))
				bw.write(1 + "\n");
			else
				bw.write(0 + "\n");
		}
		bw.flush();
		
	}

	private static boolean reCombination(int depth, int next, int[] array, int[] val, int number) {
		if (depth == 3) {
			int sum = 0;
			for (int i : val)
				sum += i;

			if (sum == number)
				return true;

			return false;
		}
		
		if(next == array.length)
			return false;

		val[depth] = array[next];
		if (reCombination(depth + 1, next, array, val, number))
			return true;

		if (reCombination(depth, next + 1, array, val, number))
			return true;

		return false;
	}

}
