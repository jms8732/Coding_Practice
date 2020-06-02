package samsung;

//미세먼지 안녕!
import java.util.*;
import java.io.*;

public class problem_17144_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int [][] room = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int t = Integer.parseInt(st.nextToken());
				room[i][j] = t;
			}
		}

		for (int i = 0; i < T; i++)
			simulation(room, R, C);

		int answer = sum_dust(room,R,C);
		System.out.println(answer);
	}

	private static void simulation(int[][] room, int R, int C) {
		// 먼지 확산
		expand_dust(room, R, C);
		clear_air(room, R, C);
	}
	
	private static void copyArray(int [][] src, int[][] dest) {
		int idx =0 ;
		for(int [] s : src) {
			System.arraycopy(s, 0,dest[idx++],0, s.length);
		}
	}
	private static int sum_dust(int [][] room, int R, int C) {
		int answer =0 ;
		for(int i =0 ; i< R ; i++) {
			for(int j =0 ; j < C ; j++) {
				if(room[i][j] != -1)
					answer += room[i][j];
			}
		}
		
		return answer;
	}

	private static void clear_air(int[][] room, int R, int C) {
		boolean up = true;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] == -1) {
					cleaner(room, i, j + 1, R, C, up);
					up = false;
				}
			}
		}
	}

	private static void print(int[][] room, int R, int C) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(room[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void cleaner(int[][] room, int x, int y, int R, int C, boolean c) {
		int[] ud = new int[4];
		int[] rl = new int[4];

		if (c) {
			ud[0] = 0;
			ud[1] = -1;
			ud[2] = 0;
			ud[3] = 1;
			
			rl[0] = 1;
			rl[1] = 0;
			rl[2] = -1;
			rl[3] = 0;
		} else {
			ud[0] = 0;
			ud[1] = 1;
			ud[2] = 0;
			ud[3] = -1;

			rl[0] = 1;
			rl[1] = 0;
			rl[2] = -1;
			rl[3] = 0;
		}

		int next = room[x][y];
		int tmp = 0;
		room[x][y] = 0;

		for (int i = 0; i < 4; i++) {
			while (true) {
				int nx = x + ud[i];
				int ny = y + rl[i];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C || room[nx][ny] == -1) {
					break;
				}

				tmp = room[nx][ny];
				room[nx][ny] = next;
				next = tmp;

				x = nx;
				y = ny;
			}
		}

	}

	private static void expand_dust(int[][] room, int R, int C) {
		int[][] tmp = new int[R][C];
		int[] ud = { -1, 0, 1, 0 };
		int[] rl = { 0, 1, 0, -1 };

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (room[i][j] != 0) {
					int count = 0;
					for (int k = 0; k < 4; k++) {
						int nx = i + ud[k];
						int ny = j + rl[k];

						if (nx < 0 || nx >= R || ny < 0 || ny >= C || room[nx][ny] == -1)
							continue;
						count++;
						tmp[nx][ny] += room[i][j] / 5;
					}
					tmp[i][j] += room[i][j] - (room[i][j] / 5) * count;
				}
			}
		}

		copyArray(tmp,room);
	}
}
