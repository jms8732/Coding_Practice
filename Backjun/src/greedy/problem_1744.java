package greedy;

//¼ö ¹­±â
import java.util.*;
import java.io.*;

public class problem_1744 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minus = new PriorityQueue<Integer>();

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());

			if (temp <= 0)
				minus.add(temp);
			else
				plus.add(temp);
		}

		int answer = 0;

		while (!plus.isEmpty()) {
			if (plus.size() == 1) {
				answer += plus.poll();
			} else {
				int cur = plus.poll();
				int next = plus.poll();

				if (cur * next < cur + next) {
					answer += cur + next;
				} else
					answer += cur * next;
			}
		}

		while (!minus.isEmpty()) {
			if (minus.size() == 1) {
				answer += minus.poll();
			} else {
				answer += minus.poll() * minus.poll();
			}
		}

		System.out.println(answer);
	}
}
