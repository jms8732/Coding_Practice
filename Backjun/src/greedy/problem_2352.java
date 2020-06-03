package greedy;

//반도체 설계
import java.util.*;
import java.io.*;

public class problem_2352 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			lower_bound(list, Integer.parseInt(st.nextToken()));
		}

		System.out.println(list.size());
	}

	private static void lower_bound(List<Integer> list, int target) {
		if (list.isEmpty()) {
			list.add(target);
			return;
		}

		int left = 0;
		int right = list.size();

		while (left < right) {
			int mid = (left + right) / 2;

			if (list.get(mid) < target) {
				left = mid + 1;
			} else
				right = mid;
		}

		if (list.size() == left) {
			list.add(target);
		} else
			list.set(left, target);

	}
}
