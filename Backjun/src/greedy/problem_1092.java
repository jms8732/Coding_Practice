package greedy;

//병든 나이트
import java.util.*;
import java.io.*;

public class problem_1092 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] crain = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crain[i] = Integer.parseInt(st.nextToken());
		}

		int K = Integer.parseInt(br.readLine());

		List<Integer> boxes = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(boxes);

		int time = 0;
		int box_count = boxes.size();
		while (!boxes.isEmpty()) {
			for (int i = 0; i < crain.length; i++) {
				if (!boxes.isEmpty()) {
					upper_bound(crain[i], boxes);
				} else
					break;
			}
			
			if (box_count == boxes.size()) {
				time = -1;
				break;
			}
			
			box_count = boxes.size();
			time++;
		}
		System.out.println(time);
	}

	private static void upper_bound(int tar, List<Integer> boxes) {
		int left = 0;
		int right = boxes.size();

		while (left < right) {
			int mid = (left + right) / 2;

			if (boxes.get(mid) <= tar) {
				left = mid + 1;
			} else
				right = mid;
		}

		if (left - 1 >= 0)
			boxes.remove(left - 1);
	}
}
