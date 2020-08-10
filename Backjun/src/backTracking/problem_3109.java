package backTracking;

//»§Áý
import java.util.*;
import java.io.*;

public class problem_3109 {
	static char[][] map;
	static int [] ud = {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String temp = br.readLine();

			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		int answer = 0;
		for (int i = 0; i < R; i++) {
			if (backtracking(i, 0, R, C)) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	private static boolean backtracking(int startX, int startY, int R, int C) {
		if (startY == C - 1)
			return true;

		for(int i= 0 ; i < ud.length; i++) {
			int nx = startX + ud[i];
			int ny = startY + 1;
			
			if(nx < 0 || nx >= R || map[nx][ny] == '*' || map[nx][ny] == 'x')
				continue;
			
			map[startX][startY] = '*';
			map[nx][ny] = '*';
			if(backtracking(nx,ny,R,C)) {
				return true;
			}
		}
		
		return false;
	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
