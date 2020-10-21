package dp;

/*
 * 경찰차
 * DP를 이용해서 문제를 해결하면 된다.
 * 단, DP의 매개변수를 좌표로 생각하면 문제를 해결할 수 없다. 매개변수를 경찰차 1고 경찰차 2의 사건 번호로 생각해야한다.
 * 
 */
import java.util.*;
import java.io.*;

public class problem_2618 {
	static Point[] pathA, pathB;
	static int S;
	static int[][] cache; // 경찰차 1과 경찰차 2의 거리를 저장하는 이차원 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		S = Integer.parseInt(br.readLine()) + 1;
		pathA = new Point[S];
		pathB = new Point[S];
		cache = new int[S][S];

		for (int c[] : cache)
			Arrays.fill(c, -1);

		// 초기화 및 생성
		for (int i = 0; i < pathA.length; i++) {
			pathA[i] = new Point(1, 1);
			pathB[i] = new Point(N,N);
		}
		// 좌표 설정
		for (int i = 1; i < pathA.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			pathA[i].x = x;
			pathA[i].y = y;
			pathB[i].x = x;
			pathB[i].y = y;
		}

		System.out.println(getMinDistance(0, 0));
		reconstruct(0, 0);
	}

	private static void reconstruct(int A, int B) {
		// 사건을 모두 끝마친 경우
		if (A == S - 1 || B == S - 1)
			return;

		int ret1 = Integer.MAX_VALUE, ret2 = Integer.MAX_VALUE;
		int next = Math.max(A, B) + 1; // 다음 사건

		int distA = Math.abs(pathA[A].x - pathA[next].x) + Math.abs(pathA[A].y - pathA[next].y);
		int distB = Math.abs(pathB[B].x - pathB[next].x) + Math.abs(pathB[B].y - pathB[next].y);

		// 경찰차 1로 사건을 선택한 경우
		ret1 = getMinDistance(next, B) + distA;

		// 경찰차 2로 사건을 선택한 경우
		ret2 = getMinDistance(A, next) + distB;

		// 경찰차 1의 거리가 경찰차 2의 거리보다 큰 경우
		if (ret1 > ret2) {
			System.out.println(2);
			reconstruct(A, next);
		} else {
			System.out.println(1);
			reconstruct(next, B);
		}

	}

	// 사건의 최소 거리를 구하는 메소드
	private static int getMinDistance(int A, int B) {
		// 사건을 모두 끝마친 경우
		if (A == S - 1 || B == S - 1)
			return 0;

		if (cache[A][B] != -1)
			return cache[A][B];

		int ret1 = Integer.MAX_VALUE, ret2 = Integer.MAX_VALUE;
		int next = Math.max(A, B) + 1; // 다음 사건

		int distA = Math.abs(pathA[A].x - pathA[next].x) + Math.abs(pathA[A].y - pathA[next].y);
		int distB = Math.abs(pathB[B].x - pathB[next].x) + Math.abs(pathB[B].y - pathB[next].y);

		// 경찰차 1로 사건을 선택한 경우
		ret1 = Math.min(ret1, getMinDistance(next, B) + distA);

		// 경찰차 2로 사건을 선택한 경우
		ret2 = Math.min(ret2, getMinDistance(A, next) + distB);

		return cache[A][B] = Math.min(ret1,ret2);
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
