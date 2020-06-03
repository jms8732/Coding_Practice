package samsung;

//원판 돌리기
import java.util.*;
import java.io.*;

public class problem_17822 {
	static int[][] round;
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int T = Integer.parseInt(st.nextToken());

		round = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				round[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if (dir == 0) {
				r_Shift(dir,k,N,M,target);
			} else {
				l_Shift(dir,k,N,M,target);
			}

			boolean[][] visited = new boolean[N][M];
			for (int j = 0; j < N; j++) {
				for (int l = 0; l < M; l++) {
					if (!visited[j][l] && round[j][l] != -1 && round[j][l] !=0 ) {
						find_same(N, M, j, l, round[j][l], visited);
					}
				}
			}
			
			if (check_same(N, M)) {
				change_val(N,M);
			}else {
				cal_avg(N,M);
			}
			
		}
		
		int answer =0 ;
		for(int i= 0; i <N ; i++) {
			for(int j= 0 ; j <M ; j++) {
				if(round[i][j] != -1)
					answer += round[i][j];
			}
		}
		System.out.println(answer);
	}
	
	private static void change_val(int N, int M) {
		for(int i =0 ; i <N ; i++) {
			for(int j =0 ; j< M ; j++) {
				if(round[i][j] == -1)
					round[i][j] = 0;
			}
		}
	}

	private static void cal_avg(int N, int M) {
		int sum = 0;
		int count = 0;
		for (int[] r : round) {
			for (int i = 0; i < M; i++) {
				if (r[i] != 0) {
					sum += r[i];
					count++;
				}
			}
		}

		double avg = (double)sum / (double)count;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (round[i][j] != 0) {
					if ((double)round[i][j] > avg)
						round[i][j] -= 1;
					else if((double)round [i][j] < avg)
						round[i][j] += 1;
				}
			}
		}
		
	}

	private static boolean check_same(int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (round[i][j] == -1)
					return true;
			}
		}
		return false;
	}

	private static void print(int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(round[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void find_same(int N, int M, int x, int y, int num, boolean[][] visited) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + ud[i];
			int ny = Math.floorMod(y + rl[i],M);

			if (nx < 0 || nx >= N || round[nx][ny] != num || visited[nx][ny])
				continue;

			round[x][y] = -1;
			round[nx][ny] = -1;
			find_same(N, M, nx, ny, num, visited);
		}
	}

	private static void l_Shift(int dir, int k, int N, int M, int target) {
		for (int i = 0; i < N; i++) {
			if ((i + 1) % target == 0) {
				int[] tmp = new int[M];
				for (int j = 0; j < M; j++) {
					int n_idx = Math.floorMod(j - k, M);
					tmp[n_idx] = round[i][j];
				}
				System.arraycopy(tmp, 0, round[i], 0, M);
			}
		}
	}

	private static void r_Shift(int dir, int k, int N, int M, int target) {
		for (int i = 0; i < N; i++) {
			if ((i + 1) % target == 0) {
				int[] tmp = new int[M];
				for (int j = 0; j < M; j++) {
					int n_idx = Math.floorMod(j + k, M);
					tmp[n_idx] = round[i][j];
				}
				System.arraycopy(tmp, 0, round[i], 0, M);
			}
		}
	}

}
