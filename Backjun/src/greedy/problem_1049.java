package greedy;

//±‚≈∏¡Ÿ

import java.util.*;
import java.io.*;

public class problem_1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int set_price = Integer.MAX_VALUE;
		int one_price = Integer.MAX_VALUE;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int set = Integer.parseInt(st.nextToken());
			int one = Integer.parseInt(st.nextToken());

			if (set_price > set) {
				set_price = set;
			}

			if (one_price > one) {
				one_price = one;
			}
		}

		int result = 0;
		while (N > 0) {
			if (N > 6) {
				if (set_price > one_price * 6) {
					result += one_price * 6;
				} else
					result += set_price;
				N -= 6;
			}else {
				if(set_price > one_price * N) {
					result += one_price * N;
					N-= N;
				}else {
					result += set_price;
					N-=6;
				}

			}
		}

		System.out.println(result);
	}
}
