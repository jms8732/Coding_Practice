package samsung;

//사다리 조작
import java.util.*;
import java.io.*;

public class problem_15684_1 {
	static int ladder[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ladder = new int[M][N];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());

			int row = Integer.parseInt(st.nextToken()) - 1;
			int col = Integer.parseInt(st.nextToken()) - 1;

			ladder[row][col] = 1;
			ladder[row][col + 1] = -1;
		}

		for (int i = 0 ; i <= 3; i++) {
			simulation(0, 0, i, M, N);
		}
		
		System.out.println(-1);
	}
	private static void print(int M , int N) {
		for(int i= 0 ; i < M ; i++) {
			for(int j = 0 ; j < N ; j++) {
				System.out.print(ladder[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void simulation(int depth, int next, int size, int M, int N) {
		if (depth == size) {
			//print(M,N);
			if(go_down(M,N)) {
				System.out.println(depth);
				System.exit(0);
			}
			
			return;
		}

		for (int i = next; i < M * N; i++) {
			int x = i / N;
			int y = i % N;

			if (y + 1 < N && ladder[x][y] == 0 && ladder[x][y + 1] == 0) {
				ladder[x][y] = 1;
				ladder[x][y + 1] = -1;

				simulation(depth + 1, i+1, size, M, N);

				ladder[x][y] = 0;
				ladder[x][y + 1] = 0;
			}
		}
	}
	
	private static boolean go_down(int M, int N) {
		for(int i =0 ; i < N ; i++) {
			int cur_x = 0;
			int cur_y= i;
			
			while(cur_x < M) {
				//현재 위치가 가로줄이 있는 경우
				if(ladder[cur_x][cur_y] == 1) {
					cur_y++;
				}else if(ladder[cur_x][cur_y] == -1)
					cur_y--;
				
				cur_x++;
			}
			
			if(i != cur_y)
				return false;
		}
		
		return true;
	}
	
}
