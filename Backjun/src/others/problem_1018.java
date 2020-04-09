package others;

//체스판 다시 칠하기 1:30 -> 47:01(43분 소요)
import java.util.*;
import java.io.*;

public class problem_1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}

		simulation(map, N, M);
	}

	private static void simulation(char[][] map, int N, int M) {
		int answer= Integer.MAX_VALUE ;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 8x8 체스판이 되는 경우에만 체스판을 자른다.
				if (i + 8 <= N && j + 8 <= M) {
					char[][] chessBoard = getBoard(i, j, map);
					answer = Math.min(count(chessBoard, N, M),answer);
				}
			}
		}
		
		System.out.println(answer);
	}


	
	private static int count(char[][] chessBoard, int N, int M) {
		int white = 0;

		boolean[][] visited = new boolean[8][8];

		// 맨 처음이 흰색인 경우
		char[] tmp = { 'W', 'B' };
		for (int i = 0; i < 8; i++) {
			int startIdx = i % 2;
			for (int j = 0; j < 8; j++) {
				if (!visited[i][j])
					white += goDown(chessBoard, visited, i, j,N,M,tmp[startIdx + j % 2]);
			}
		}
		
		//맨 처음이 검정색인 경우
		int black = 0;
		visited = new boolean[8][8];
		char[] tmp1 = {'B','W'};
		for (int i = 0; i < 8; i++) {
			int startIdx = i % 2;
			for (int j = 0; j < 8; j++) {
				if (!visited[i][j])
					black += goDown(chessBoard, visited, i, j,N,M,tmp1[startIdx + j % 2]);
			}
		}

		int answer = Math.min(black, white);
		return answer;
	}

	private static int goDown(char[][] chessBoard, boolean[][] visited, int x, int y, int N, int M, char color) {
		int count = 0;
		if(chessBoard[x][y] != color)
			count++;
		
		visited[x][y] = true;
		while (true) {
			int nx = x + 1;
			int ny = y + 1;

			if(nx >= 8 || ny >= 8)
				break;
			
			if (color != chessBoard[nx][ny]) {
				count++;
			}

			visited[nx][ny] = true;
			x = nx;
			y = ny;
		}

		return count;
	}

	private static char[][] getBoard(int x, int y, char[][] map) {
		char[][] tmp = new char[8][8];

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tmp[i][j] = map[x+i][y+j];
			}
		}

		return tmp;
	}
}
