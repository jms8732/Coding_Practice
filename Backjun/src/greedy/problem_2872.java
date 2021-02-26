package greedy;

/*
 * 우리집엔 도서관이 있어
 * 책을 맨 위로 올린다는 것에 초점을 맞춰 생각을 해야 한다.
 */
import java.util.*;
import java.io.*;

public class problem_2872 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int [] books = new int[n+1];

		int last = n;
		int last_idx = 0;
		for (int i = 1; i <= n; i++) {
			int temp = Integer.parseInt(br.readLine());

			if (temp == last)
				last_idx = i;

			books[temp] = i;
		}

		int ret = 0;
		int next_last = 0;
		while ((next_last = last - 1) > 0) {
			int next_idx = books[next_last];

			if (next_idx > last_idx) {
				// 번호가 작은 책이 밑에 있는 경우
				ret++;

				last_idx = 0;
				last = next_last;
			}else {
				last_idx = next_idx;
				last = next_last;
			}

		}

		System.out.println(ret);
	}

}
