package greedy;

//수리공 항승
import java.util.*;
import java.io.*;

public class problem_1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> leak = new PriorityQueue<Integer>();
		st = new StringTokenizer(br.readLine());

		// 누수된 곳
		for (int i = 0; i < N; i++) {
			leak.add(Integer.parseInt(st.nextToken()));
		}

		int tapeCount = 0;
		while (!leak.isEmpty()) {
			int cur = leak.poll();

			while (!leak.isEmpty() && cur + L > leak.peek()) {
				leak.poll();
			}

			tapeCount++;
		}

		System.out.println(tapeCount);
	}
}
