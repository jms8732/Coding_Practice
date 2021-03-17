package others;

/*
 * ÇÇÀÚ ±Á±â
 * O(DN) -> O(D+N) À¸·Î ¹Ù²Û´Ù.
 */

import java.util.*;
import java.io.*;

public class problem_1756 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int d = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] oven = new int[d];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < d; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
		}

		Queue<Integer> bread = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			bread.add(Integer.parseInt(st.nextToken()));
		}

		System.out.println(simulation(bread, oven));
	}

	private static int simulation(Queue<Integer> bread, int[] oven) {
		for (int i = 1; i < oven.length; i++) {
			oven[i] = Math.min(oven[i - 1], oven[i]);
		}

		int start = oven.length;

		while (!bread.isEmpty() && --start>= 0) {
			if (oven[start] >= bread.peek()) {
				bread.poll();
			}

		}

		if (bread.isEmpty())
			return start+1;

		return 0;
	}
}
