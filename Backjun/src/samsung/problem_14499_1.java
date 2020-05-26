package samsung;

//주사위 굴리기
import java.util.*;
import java.io.*;

public class problem_14499_1 {
	// 바닥,앞,위,뒤,왼,오 순으로
	static int[] dice = { 0, 0, 0, 0, 0, 0 };
	static int[] ud = { 0, 0, -1, 1 };
	static int[] rl = { 1, -1, 0, 0};
	static int startX, startY;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			move_dice(dir, map,N,M);
		}
	}

	private static void move_dice(int dir, int[][] map, int N, int M) {
		int nx = startX + ud[dir-1];
		int ny = startY + rl[dir-1];
		
		//배열의 밖을 벗어난 경우
		if(nx < 0 || nx >= N || ny <0 || ny>= M)
			return;
		
		//다음 칸
		startX = nx;
		startY = ny;
		
		//서쪽인 경우
		if(dir == 2) {
			//바닥, 왼, 위, 오
			int [] move = { dice[0], dice[4], dice[2],dice[5]};
			rotate(move);
			dice[0] = move[0];
			dice[4] = move[1];
			dice[2] = move[2];
			dice[5] = move[3];
			
		}else if(dir == 1) {
			int [] move= {dice[0],dice[5],dice[2],dice[4]};
			rotate(move);
			dice[0] = move[0];
			dice[5] = move[1];
			dice[2] = move[2];
			dice[4] = move[3];
			
		}else if(dir== 4) {
			//남쪽인 경우
			int move[] = {dice[0],dice[1], dice[2],dice[3]};
			rotate(move);
			dice[0] = move[0];
			dice[1] = move[1];
			dice[2] = move[2];
			dice[3] = move[3];
			
			
		}else {
			//북쪽
			int move[] = {dice[0],dice[3],dice[2],dice[1]};
			rotate(move);
			dice[0] = move[0];
			dice[3] = move[1];
			dice[2] = move[2];
			dice[1] = move[3];
			
		}
		
		if(map[startX][startY] == 0) {
			map[startX][startY] = dice[0];
		}else {
			dice[0] = map[startX][startY];
			map[startX][startY] = 0;
		}
		
		System.out.println(dice[2]);
	}
	
	private static void rotate(int move[]) {
		int tmp = move[0];
		
		for(int i = 1 ; i < move.length ; i++) {
			move[i-1] = move[i];
		}
		
		move[3] = tmp;
	}
}
