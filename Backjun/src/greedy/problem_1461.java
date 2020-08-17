package greedy;

//도서관
import java.util.*;
import java.io.*;

public class problem_1461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer> minus = new ArrayList<>();
		List<Integer> plus = new ArrayList<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());

			if (temp < 0)
				minus.add(temp);
			else
				plus.add(temp);
		}
		Collections.sort(minus);
		Collections.sort(plus);

		// 맨 처음 긴 위치부터 책을 둔다.
		int walk = 0;
		int left = 0;
		int right = plus.size() - 1;
		int l = -1;
		int r = -1;
		if (!minus.isEmpty())
			l = Math.abs(minus.get(left));
		
		if (!plus.isEmpty())
			r = Math.abs(plus.get(right));

		if (l < r) {
			right -= M;
			walk += r;
		} else {
			left += M;
			walk += l;
		}

		while (!minus.isEmpty() && left < minus.size()) {
			l = Math.abs(minus.get(left) * 2);
			walk += l;

			left += M;
		}

		while (!plus.isEmpty() && right >= 0) {
			r = Math.abs(plus.get(right) * 2);
			walk += r;

			right -= M;
		}

		System.out.println(walk);
	}

}
