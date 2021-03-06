package samsung_Atype;

//캐슬 디펜스
import java.util.*;
import java.io.*;

public class problem_17135 {
	static int big = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
 
		int[][] map = new int[N + 1][M];

		// 초기화
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0, next = 0;
		dfs(N, M, D, next, count, map);
		System.out.println(big);
	}

	private static void copyMap(int[][] src, int[][] dest) {
		int idx = 0;
		for (int[] tmp : src) {
			System.arraycopy(tmp, 0, dest[idx++], 0, tmp.length);
		}
	}

	private static void dfs(int N, int M, int D, int next, int count, int[][] map) {
		int ec = 0;
		if (count == 3) {
			int[][] tmpMap = new int[N + 1][M];
			boolean[] archers = new boolean[M];
			copyMap(map, tmpMap);
			// 3개의 아처가 자리 잡은 경우
			while (true) {
				if (isEnd(N, map))
					break;
				ec += attack(N, M, D, map, archers);
				downEnemy(N, map);
				Arrays.fill(archers, false);
			}
			big = Math.max(big, ec);
			copyMap(tmpMap, map); // 맵을 원상 복귀 시킨다.
			return;
		}

		// 아처의 위치
		for (int i = next; i < M; i++) {
			if (map[N][i] == 0) {
				map[N][i] = 2;
				dfs(N, M, D, i + 1, count + 1, map);
				map[N][i] = 0;
			}
		}

	}

	private static int attack(int N, int M, int D, int[][] map, boolean[] archers) {
		int count = 0;
		List<Node> list = new ArrayList<>();
		List<Node> totalList = new ArrayList<>();
		for (int k = 0; k < archers.length; k++) {
			if (!archers[k] && map[N][k] == 2) {
				// 현재 아처가 공격하지 않았다면
				for (int i = N - 1; i >= 0; i--) {
					for (int j = 0; j < M; j++) {
						if (map[i][j] == 1) { // 적 위치
							int dtc = Math.abs(i - N) + Math.abs(j - k);
							if (dtc <= D) {
								list.add(new Node(i, j, dtc));
							}
						}
					}
				}

				list.sort(new Comparator<Node>() {

					@Override
					public int compare(Node o1, Node o2) {
						// TODO Auto-generated method stub
						if (o1.distance < o2.distance)
							return -1;
						else if (o1.distance == o2.distance) {
							if (o1.y < o2.y)
								return -1;
							else
								return 1;
						} else
							return 1;
					}

				});

				if (!list.isEmpty()) {
					totalList.add(list.get(0));
					list.clear();
				}
			}
		}

		for (int i = 0; i < totalList.size(); i++) {
			Node tmp = totalList.get(i);
			if (map[tmp.x][tmp.y] == 1) {
				map[tmp.x][tmp.y] = 0;
				count++;
			}
		}
		return count;
	}

	private static boolean isEnd(int N, int[][] map) {
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1)
					return false;
			}
		}

		return true;
	}

	private static void downEnemy(int N, int[][] map) {
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1) {
					if (i + 1 <= N && (map[i + 1][j] == 0 || map[i + 1][j] == 2)) {
						if (i + 1 != N) {
							// 적이 내려옴
							map[i + 1][j] = map[i][j];
						}
						map[i][j] = 0;
					}
				}
			}
		}
	}

	private static class Node {
		int x, y, distance;

		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.distance = d;
		}
	}
}
