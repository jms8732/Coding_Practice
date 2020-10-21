package dp;

/*
 * ������
 * DP�� �̿��ؼ� ������ �ذ��ϸ� �ȴ�.
 * ��, DP�� �Ű������� ��ǥ�� �����ϸ� ������ �ذ��� �� ����. �Ű������� ������ 1�� ������ 2�� ��� ��ȣ�� �����ؾ��Ѵ�.
 * 
 */
import java.util.*;
import java.io.*;

public class problem_2618 {
	static Point[] pathA, pathB;
	static int S;
	static int[][] cache; // ������ 1�� ������ 2�� �Ÿ��� �����ϴ� ������ �迭

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		S = Integer.parseInt(br.readLine()) + 1;
		pathA = new Point[S];
		pathB = new Point[S];
		cache = new int[S][S];

		for (int c[] : cache)
			Arrays.fill(c, -1);

		// �ʱ�ȭ �� ����
		for (int i = 0; i < pathA.length; i++) {
			pathA[i] = new Point(1, 1);
			pathB[i] = new Point(N,N);
		}
		// ��ǥ ����
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
		// ����� ��� ����ģ ���
		if (A == S - 1 || B == S - 1)
			return;

		int ret1 = Integer.MAX_VALUE, ret2 = Integer.MAX_VALUE;
		int next = Math.max(A, B) + 1; // ���� ���

		int distA = Math.abs(pathA[A].x - pathA[next].x) + Math.abs(pathA[A].y - pathA[next].y);
		int distB = Math.abs(pathB[B].x - pathB[next].x) + Math.abs(pathB[B].y - pathB[next].y);

		// ������ 1�� ����� ������ ���
		ret1 = getMinDistance(next, B) + distA;

		// ������ 2�� ����� ������ ���
		ret2 = getMinDistance(A, next) + distB;

		// ������ 1�� �Ÿ��� ������ 2�� �Ÿ����� ū ���
		if (ret1 > ret2) {
			System.out.println(2);
			reconstruct(A, next);
		} else {
			System.out.println(1);
			reconstruct(next, B);
		}

	}

	// ����� �ּ� �Ÿ��� ���ϴ� �޼ҵ�
	private static int getMinDistance(int A, int B) {
		// ����� ��� ����ģ ���
		if (A == S - 1 || B == S - 1)
			return 0;

		if (cache[A][B] != -1)
			return cache[A][B];

		int ret1 = Integer.MAX_VALUE, ret2 = Integer.MAX_VALUE;
		int next = Math.max(A, B) + 1; // ���� ���

		int distA = Math.abs(pathA[A].x - pathA[next].x) + Math.abs(pathA[A].y - pathA[next].y);
		int distB = Math.abs(pathB[B].x - pathB[next].x) + Math.abs(pathB[B].y - pathB[next].y);

		// ������ 1�� ����� ������ ���
		ret1 = Math.min(ret1, getMinDistance(next, B) + distA);

		// ������ 2�� ����� ������ ���
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
