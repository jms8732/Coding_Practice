package sorting;

import java.util.*;
import java.io.*;

public class problem_1590 {
	static List<Long> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();

		int bus = Integer.parseInt(st.nextToken());
		long timer = Integer.parseInt(st.nextToken());
		long answer = Long.MAX_VALUE;

		for (int i = 0; i < bus; i++) {
			if (answer == 0)
				break;

			st = new StringTokenizer(br.readLine());

			long start = Integer.parseInt(st.nextToken());
			long interval = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());

			long maxium = start + (interval * (count-1));
			if(maxium <= timer) {
				if(maxium == timer)
					answer =0 ;
				continue;
			}
			
			for (int j = 0; j < count; j++) {
				list.add(start + (interval * j));
			}
			answer = Math.min(answer, search(timer));
			list.clear();

		}

		if (answer == Long.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(answer);

	}

	private static long search(long timer) {
		long ld = lower_bound(timer);
		long ud = upper_bound(timer);

		long diff_ld = Math.abs(ld - timer);
		long diff_ud = Math.abs(ud - timer);

		return Math.min(diff_ld, diff_ud);
	}

	private static long upper_bound(long timer) {
		int left = 0;
		int right = list.size() - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (list.get(mid) < timer)
				left = mid + 1;
			else
				right = mid;
		}

		return list.get(left);
	}

	private static long lower_bound(long timer) {
		int left = 0;
		int right = list.size() - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (list.get(mid) <= timer)
				left = mid + 1;
			else
				right = mid;

		}

		return list.get(left);
	}
}
