package samsung_Atype;

//배열 돌리기
import java.util.*;
import java.io.*;

public class problem_17406 {
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		Queue<Node> totalQ = new LinkedList<>();

		// 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		List<List<Integer>> tmpQ = new LinkedList<>();

		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			List<Integer> tmpList = new ArrayList<>();

			tmpList.add(r - 1);
			tmpList.add(c - 1);
			tmpList.add(s);

			tmpQ.add(tmpList);
		}

		for (int i = 0; i < tmpQ.size(); i++) {
			List<Integer> list = tmpQ.get(i);
			int r = list.get(0);
			int c = list.get(1);
			int s = list.get(2);

			List<Integer> rest = new ArrayList<>();
			int[][] tmpA = new int[N][M];
			copyArray(map, tmpA);

			// 배열 회전
			rotationArray(map, r, c, s);
			rest.add(i);
			totalQ.add(new Node(map, tmpQ, rest));
			copyArray(tmpA, map);

		}

		while (!totalQ.isEmpty()) {
			Node current = totalQ.poll();

			List<Integer> currentList = current.rest;
			List<Integer> tmpList = new ArrayList<>(currentList);
			int[][] tmpMap = new int[N][M];

			if (currentList.size() == C) {
				calculate(current.map);
				continue;
			}
			List<List<Integer>> currentQ = current.queue;

			for (int i = 0; i < currentQ.size(); i++) {
				if (!currentList.contains(i)) {
					List<Integer> lt = currentQ.get(i);
					int r = lt.get(0);
					int c = lt.get(1);
					int s = lt.get(2);

					copyArray(current.map, tmpMap);
					rotationArray(current.map, r, c, s);
					currentList.add(i);
					totalQ.add(new Node(current.map, currentQ, currentList));
					copyArray(tmpMap, current.map);
					currentList = new ArrayList<>(tmpList);

				}
			}

		}

		System.out.println(answer);
	}

	private static void calculate(int[][] map) {
		int idx = 0;
		for (int[] tmp : map) {
			int tmp1 = 0;
			for (int i = 0; i < tmp.length; i++) {
				tmp1 += tmp[i];
			}
			answer = Math.min(tmp1, answer);
		}

	}

	private static void rotationArray(int[][] map, int r, int c, int s) {
		int lx = r - s, ly = c - s;
		int rx = r + s, ry = c + s;

		// left to right
		while (lx != rx && ly != ry) {
			int llx = lx, lly = ly;
			int tmp = map[lx][ly];
			int ntmp = 0;

			
			while (true) {
				int ny = ly + 1;
				if (ny < 0 || ny > ry) {
					ly = ny - 1;
					break;
				}

				ntmp = map[lx][ny];

				map[lx][ny] = tmp;
				tmp = ntmp;
				ly = ny;
			}

			// down to up

			while (true) {
				int nx = lx + 1;
				if (nx < 0 || nx > rx) {
					lx = nx - 1;
					break;
				}

				ntmp = map[nx][ly];

				map[nx][ly] = tmp;
				tmp = ntmp;
				lx = nx;
			}

			// right to left
			while (true) {
				int ny = ly - 1;
				if (ny < lly || ny > ry) {
					ly = ny + 1;
					break;
				}

				ntmp = map[lx][ny];

				map[lx][ny] = tmp;
				tmp = ntmp;
				ly = ny;
			}

			// down to up
			while (true) {
				int nx = lx - 1;
				if (nx < llx || nx > rx) {
					nx = nx + 1;
					break;
				}

				ntmp = map[nx][ly];

				map[nx][ly] = tmp;
				tmp = ntmp;
				lx = nx;
			}

			lx += 1;
			ly += 1;

			rx -= 1;
			ry -= 1;

		}
	}

	private static void copyArray(int[][] src, int[][] dest) {
		int idx = 0;
		for (int tmp[] : src) {
			System.arraycopy(tmp, 0, dest[idx++], 0, tmp.length);
		}
	}

	private static class Node {
		int[][] map;
		List<List<Integer>> queue;
		List<Integer> rest;

		public Node(int[][] src, List<List<Integer>> q, List<Integer> rest) {
			this.map = new int[src.length][src[0].length];
			copyArray(src);
			this.queue = new ArrayList<>(q);
			this.rest = new ArrayList<>(rest);
		}

		private void copyArray(int[][] src) {
			int idx = 0;
			for (int tmp[] : src) {
				System.arraycopy(tmp, 0, this.map[idx++], 0, tmp.length);
			}
		}
	}
}
