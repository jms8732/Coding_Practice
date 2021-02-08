package graph;

import java.util.*;
import java.io.*;

/*
 * Byte Coin
 * 상승장일 경우, 구매한 코인을 판매
 * 하락장일 경우, 코인을 구매
 * 
 */
public class problem_17521 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long money = Integer.parseInt(st.nextToken());
		long coins = 0;

		Queue<Long> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			q.add(Long.parseLong(br.readLine()));
		}

		long cur = q.poll();
		while (!q.isEmpty()) {
			long next = q.poll();

			if (cur < next) {
				// 상승장인 경우
				while (!q.isEmpty() && next < q.peek()) {
					next = q.poll();
				}

				coins = money / cur;
				money = (money % cur) + coins * next;

			} else {
				while (!q.isEmpty() && next > q.peek()) {
					next = q.poll();
				}
			}
			cur = next;
		}

		System.out.println(money);
	}
}
