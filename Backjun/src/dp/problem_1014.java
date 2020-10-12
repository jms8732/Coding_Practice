package dp;

/*
 * 컨닝
 * 비트 + 다이나믹 프로그래밍
 */
import java.util.*;
import java.io.*;

public class problem_1014 {
	static int[][] cache;
	static char[][] class_room;
	static List<Node> bit; // 비트와 그 개수를 저장하는 Node 클래스로 구성된 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		bit = new ArrayList<>();
		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			cache = new int[N][1 << M];
			class_room = new char[N][M];

			init(M);

			// 맵 초기화
			for (int j = 0; j < N; j++) {
				String temp = br.readLine();
				for (int k = 0; k < M; k++) {
					class_room[j][k] = temp.charAt(k);
				}
			}

			bw.write(dp(N, M) + "\n");
			bit.clear(); //M의 크기의 1이 인접하지 않은 비트들을 제거한다.
		}

		bw.flush();
	}

	//실질적인 계산을 진행하는 메소드
	private static int dp(int N, int M) {
		int ret = 0;

		// 1이 서로 인접하지 않은 비트들을 대상으로 현재 비트에 맞는 개수 저장
		for (Node node : bit) {
			if (!seat_possible(node.bit, 0, M))
				continue;
			
			cache[0][node.bit] = node.count;
			ret = Math.max(ret, cache[0][node.bit]); //N이 1인 경우도 존재할 수 있기 때문에 반환값에 큰 값을 할당한다.
		}
		
		
		for (int i = 1; i < N; i++) {
			for (Node nex : bit) {
				if (!seat_possible(nex.bit, i, M))
					continue;

				for (Node pre : bit) {
					if (below_side(M, pre.bit, nex.bit)) {
						cache[i][nex.bit] = Math.max(cache[i][nex.bit], cache[i - 1][pre.bit] + nex.count);
						ret = Math.max(ret, cache[i][nex.bit]);
					}
				}
			}
		}

		return ret;
	}

	// 자리가 가능한지 판단하는 메소드
	private static boolean seat_possible(int bit, int idx, int M) {
		for (int i = 0; i < M; i++) {
			if (class_room[idx][i] == 'x' && (bit & 1 << i) == 1 << i) { // 현재 행에 만족하는 열의 값이 x이지만 비트가 1인 경우
				return false;
			}
		}

		return true;
	}

	// 대각선을 판단하는 메소드
	private static boolean below_side(int M, int pre_bit, int cur_bit) {
		for (int i = 0; i < M; i++) {
			if ((pre_bit & 1 << i) == 1 << i) { // 이전 비트에 1비트가 존재하는 위치
				int left = i - 1;
				int right = i + 1;

				if (left >= 0) { // 왼쪽이 범위내 존재하면서 현재 비트의 값이 1인 경우
					if ((cur_bit & 1 << left) == 1 << left)
						return false;
				}

				if (right < M) { // 오른쪽이 범위내 존재하면서 현재 비트의 값이 1인 경우
					if ((cur_bit & 1 << right) == 1 << right) {
						return false;
					}
				}
			}
		}

		return true;
	}

	// 인접하지 않는 비트들로 구성된 리스트를 만드는 전처리 메소드
	private static void init(int M) {
		for (int i = 0; i < 1 << M; i++) {
			if (adj(M, i))
				bit.add(new Node(i, Integer.bitCount(i)));
		}
	}

	// 1비트가 서로 인접한지 안한지를 확인하는 메소드
	private static boolean adj(int M, int bit) {
		for (int i = 0; i < M; i++) {
			if ((bit & 1 << i) == 1 << i) { // 현재 위치가 1비트인 경우
				int left = i - 1;
				int right = i + 1;

				// 왼쪽 범위내에 존재하고
				if (left >= 0) {
					if ((bit & 1 << left) == 1 << left) // 왼쪽에 1비트가 존재한다면
						return false;
				}

				// 오른쪽 범위내에 존재하고
				if (right < M) {
					if ((bit & 1 << right) == 1 << right) // 오른쪽에 1비트가 존재한다면
						return false;
				}
			}
		}

		return true;
	}

	// 비트와 개수를 저장하는 Node 클래스
	private static class Node {
		int bit;
		int count;

		public Node(int b, int c) {
			this.bit = b;
			this.count = c;
		}
	}
}
