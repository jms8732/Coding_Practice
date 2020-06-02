package others;

//°ø
import java.util.*;
import java.io.*;

public class problem_1547 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] cup = new int[3];
		cup[0] = 0;
		cup[1] = 1;
		cup[2] = 2;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			swap(a, b, cup);
		}

		System.out.println(cup[0]+1);
	}

	private static void swap(int a, int b, int[] cup) {
		int cupA = 0, cupB = 0;

		for (int i = 0; i < cup.length; i++) {
			if (cup[i] == a)
				cupA = i;
			else if (cup[i] == b)
				cupB = i;
		}

		int tmp = cup[cupA];
		cup[cupA] = cup[cupB];
		cup[cupB] = tmp;
	}
}
