package search_algorithm;

//두 동전
import java.util.*;
import java.io.*;

public class problem_16197 {
	static boolean[][][][] visited;
	static char[][] board;
	static int M, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		visited = new boolean[M][N][M][N];
		List<List<Integer>> totalList = new ArrayList<>();

		board = new char[M][N];

		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				if (tmp.charAt(j) == 'o') {
					List<Integer> coin = new ArrayList<>();
					coin.add(i);
					coin.add(j);

					totalList.add(coin);

					board[i][j] = '.';
				} else
					board[i][j] = tmp.charAt(j);
			}
		}

		DropOneCoin(totalList);
	}

	private static void DropOneCoin(List<List<Integer>> totalList) {
		Queue<Board> queue = new LinkedList<>();
		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };

		visited[totalList.get(0).get(0)][totalList.get(0).get(1)][totalList.get(1).get(0)][totalList.get(1).get(1)]= true;
		
		queue.add(new Board(totalList.get(0), totalList.get(1), 0, 2));

		int answer = -1;
		while (!queue.isEmpty()) {
			Board cur = queue.poll();

			if (cur.coinCount == 1) {
				System.out.println(cur.count);
				System.exit(0);
			}

			if(cur.count >= 10)
				continue;
			
			
			int coinCount = cur.coinCount;
			int count = cur.count;

			for (int i = 0; i < 4; i++) {
				int fnx = cur.firstCoin.get(0)+ ud[i];
				int fny = cur.firstCoin.get(1) + rl[i];

				int snx = cur.secondCoin.get(0) + ud[i];
				int sny = cur.secondCoin.get(1) + rl[i];

				// 첫 번째 코인이 밖으로 떨어진 경우
				if (fnx < 0 || fnx >= M || fny < 0 || fny >= N) {
					coinCount--;
				}

				// 두 번째 코인이 밖으로 떨어진 경우
				if (snx < 0 || snx >= M || sny < 0 || sny >= N) {
					coinCount--;
				}

				// 첫 번째 코인의 다음 위치가 벽이 있는 경우
				if ((fnx >= 0 && fnx < M) && (fny >= 0 && fny < N) && board[fnx][fny] == '#') {
					fnx = cur.firstCoin.get(0);
					fny = cur.firstCoin.get(1);
				}

				// 두 번쨰 코인의 다음 위치가 벽이 있는 경우
				if ((snx >= 0 && snx < M) && (sny >= 0 && sny < N) && board[snx][sny] == '#') {
					snx = cur.secondCoin.get(0);
					sny = cur.secondCoin.get(1);
				}

				if (coinCount >= 1) {
					if (coinCount == 2) {
						if (!visited[fnx][fny][snx][sny])
							visited[fnx][fny][snx][sny] = true;
						else //이미 방문한 곳이기 때문에
							continue;
					}

					List<Integer> fnc = new ArrayList<>();
					fnc.add(fnx);
					fnc.add(fny);

					List<Integer> snc = new ArrayList<>();
					snc.add(snx);
					snc.add(sny);

					queue.add(new Board(fnc, snc, count + 1, coinCount));
				}
				coinCount = cur.coinCount;
			}
		}

		System.out.println(answer);
	}

	private static class Board {
		List<Integer> firstCoin, secondCoin;
		int count;
		int coinCount;

		public Board(List<Integer> fc, List<Integer> sc, int c, int cc) {
			this.count = c;
			this.firstCoin = fc;
			this.secondCoin = sc;
			this.coinCount = cc;
		}
	}
}
