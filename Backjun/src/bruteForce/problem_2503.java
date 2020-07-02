package bruteForce;

//숫자 야구

import java.util.*;
import java.io.*;

public class problem_2503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		List<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String n = st.nextToken();
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.add(new Node(n, s, b));
		}

		find_count(list);
	}

	private static void find_count(List<Node> list) {
		int answer =0 ;
		for (int i = 1; i <= 9; i++) {
			int num = i * 100;
			for (int j = 1; j <= 9; j++) {
				if (i != j) {
					num += j * 10;
					for (int k = 1; k <= 9; k++) {
						if(i != k && j != k) {
							num += k;
							if(check(num, list)) {
								answer++;
							}
							num -=k;
						}
					}
					num -= j * 10;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static boolean check(int num, List<Node> list) {
		String tar = String.valueOf(num);
		
		for(Node cur : list) {
			int strike = 0;
			for(int i =0 ; i < 3 ; i++) {
				if(cur.num.charAt(i) == tar.charAt(i))
					strike++;
			}
			
			if(strike != cur.strike)
				return false;
			
			int ball= 0;
			
			for(int i =0 ; i < 3;  i++) {
				for(int j =0 ; j  < 3; j++) {
					if(i != j && cur.num.charAt(i) == tar.charAt(j)) {
						ball++;
					}
				}
			}
			
			if(cur.ball != ball)
				return false;
		}
		
		return true;
	}

	private static class Node {
		String num;
		int strike, ball;

		public Node(String n, int s, int b) {
			this.num = n;
			this.strike = s;
			this.ball = b;
		}
	}
}
