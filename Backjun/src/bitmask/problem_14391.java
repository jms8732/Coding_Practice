package bitmask;

//종이 조각
import java.util.*;
import java.io.*;

public class problem_14391 {
	static char map[][];
	static boolean[][] combination;

	static int answer = -1;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		combination = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		makeCombination(0);
		System.out.println(answer);
	}
	private static void makeCombination(int depth) {
		if(depth == N) {
			boolean [][] visited = new boolean[N][M];
			int tmp = 0;
			for(int i = 0 ; i< N ; i++) {
				for(int j =0 ; j < M ; j++) {
					if(!visited[i][j]) {
						StringBuilder sb = new StringBuilder();
						makeInteger(sb,i,j,visited);
						tmp+= Integer.parseInt(sb.toString());
					}
				}
			}
			answer = Math.max(answer, tmp);
			return;
		}
		
		for(int i =0 ; i< (1<<M) ; i++) {
			checkCombination(depth,i);
			makeCombination(depth+1);
			Arrays.fill(combination[depth],false);
		}
		
	}
	
	private static void checkCombination(int depth, int bit) {
		for(int i =0 ; i< M ; i++) {
			if((bit & 1<<i) == 1<<i)
				combination[depth][i] = true;
		}
	}

	private static void makeInteger(StringBuilder sb , int x, int y,boolean[][] visited) {
		boolean cur = combination[x][y];
		if(!cur) {
			//방향이 가로방향인 경우
			for(int i = y ; i < M ; i++) {
				if(!visited[x][i] && cur == combination[x][i]) {
					visited[x][i] = true;
					sb.append(map[x][i]);
				}else
					break;
			}
		}
		else {
			//방향이 세로방향인 경우
			for(int i = x ; i < N ; i++) {
				if(!visited[i][y] && cur == combination[i][y]) {
					visited[i][y] = true;
					sb.append(map[i][y]);
				}else
					break;
			}
		}
	}
}
