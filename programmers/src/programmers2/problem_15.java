package programmers2;

//[2020 카카오공채] 외벽 점검
import java.util.*;

public class problem_15 {
	static int answer = -1;

	public static void main(String[] args) {
		int n = 12;
		int[] weak = { 1, 3, 4, 9, 10 };
		int[] dist = { 3, 5, 7 };

		int result = solution(n, weak, dist);
		System.out.println(result);
	}

	public static int solution(int n, int[] weak, int[] dist) {
		List<Integer> list = new ArrayList<>();

		simulation(0, n, list, dist, weak);
		return answer;
	}

	private static void simulation(int depth, int n, List<Integer> list, int[] dist, int[] weak) {
		if (depth == dist.length) {
			Queue<Integer> w = new LinkedList<>();

			for (int i = 0; i < weak.length; i++) {
				makeWeak(weak,n,i,w);
				Queue<Integer> tmp = new LinkedList<>(list);
				
				while (!tmp.isEmpty() && !w.isEmpty()) {
					int cur = tmp.poll();
					int start = w.poll();
					inspect(start, cur, n, w);
				}

				if (w.isEmpty()) {
					if (answer == -1)
						answer = list.size() - tmp.size();
					else
						answer = Math.min(answer, (list.size() - tmp.size()));
				}
				
				w.clear();
			}
			return;
		}

		for (int i = depth; i < dist.length; i++) {
			list.add(depth, dist[i]);
			swap(depth, i, dist);
			simulation(depth + 1, n, list, dist, weak);
			swap(i, depth, dist);
			list.remove(depth);
		}
	}

	private static void makeWeak(int[] weak, int n, int start, Queue<Integer> w) {
		while (w.size() != weak.length) {
			int div = start / weak.length;

			w.add(div * n + weak[start % weak.length]);
			start++;

		}
	}

	private static void inspect(int start, int dist, int n, Queue<Integer> weak) {
		while (!weak.isEmpty()) {
			int target = Math.floorMod(weak.peek() - start, n);

			if (0 <= target && target <= dist)
				weak.poll();
			else
				break;
		}
	}

	private static void swap(int depth, int i, int[] dist) {
		int tmp = dist[depth];
		dist[depth] = dist[i];
		dist[i] = tmp;
	}
}