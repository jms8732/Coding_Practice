package search_algorithm;

import java.util.*;
import java.io.*;

public class problem_5014 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken()) * -1;

		bfs(F, S, G, U, D);
	}

	private static void bfs(int F, int S, int G, int U, int D) {
		Queue<Integer> steps = new LinkedList<>();

		int[] move = { U, D };
		boolean[] visited = new boolean[F + 1];
		int[] floor = new int[F + 1];

		steps.add(S);

		String answer = "use the stairs";

		while (!steps.isEmpty()) {
			int current = steps.poll();

			if (!visited[current]) {
				visited[current] = true;

				if (current == G) {
					answer = Integer.toString(floor[current]);
					break;
				}

				for (int i = 0; i < 2; i++) {
					int nextStep = current + move[i];

					if (nextStep <= 0 || nextStep > F || visited[nextStep])
						continue;

					floor[nextStep] = floor[current] + 1;
					steps.add(nextStep);
				}
			}
		}

		System.out.println(answer);

	}

}
