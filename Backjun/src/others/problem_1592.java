package others;

//영식이와 친구들
import java.util.*;
import java.io.*;

public class problem_1592 {
	static int ball_idx = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int L = Integer.parseInt(st.nextToken());

		int[] ball_count = new int[N];

		int throw_count = -1;
		while (true) {
			if (is_finish(ball_count, M)) {
				System.out.println(throw_count);
				System.exit(0);
			}

			throw_ball(ball_count,L,N);
			//print(ball_count,N);
			throw_count++;
		}
	}
	
	private static void print(int [] ball_count , int N) {
		for(int i : ball_count)
			System.out.print(i + " ");
		System.out.println();
	}
	
	private static void throw_ball(int [] ball_count ,int L, int N) {
		if(ball_count[ball_idx] % 2 == 0) {
			ball_count[ball_idx] += 1;
			ball_idx = Math.floorMod(ball_idx-L, N);
		}else {
			ball_count[ball_idx] += 1;
			ball_idx = Math.floorMod(ball_idx+L, N);
		}
	}

	private static boolean is_finish(int[] ball_count, int M) {
		for (int i = 0; i < ball_count.length; i++) {
			if (ball_count[i] == M)
				return true;
		}
		return false;
	}
}
