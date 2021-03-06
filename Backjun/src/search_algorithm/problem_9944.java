package search_algorithm;

import java.util.*;
import java.io.*;

public class problem_9944 {
	static boolean[][] visited;
	static char[][] map;
	static int N, M;
	static int answer = -1;
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };
	static int totalCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int step = 1;
		String line = "";
		
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			visited = new boolean[N][M];
			map = new char[N][M];

			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < M; j++) {
					char t = tmp.charAt(j);
					if (t == '*') {
						visited[i][j] = true;
					} else
						totalCount++;

					map[i][j] = t;
				}
			}

			for(int i =0 ; i< N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(map[i][j] != '*') {
						visited[i][j] = true;
						searchMin(i,j,-1,0,1);
						visited[i][j] = false;
					}
				}
			}
			
			System.out.println("Case " + step + ": " + answer);
			step++;
			answer = -1;
			totalCount = 0;
		}
	}

	private static void searchMin(int x, int y, int dir, int count, int dotCount) {
		if (dotCount == totalCount) {
			if (answer == -1)
				answer = count;
			else
				answer = Math.min(answer, count);

			return;
		}

		// 방향으로 공을 움직인다.
		int nx = 0, ny = 0;
		int tmpCount = dotCount;
		for (int i = 0; i < 4; i++) {
			boolean moveCheck = false;
			while (true) {
				nx = x + ud[i];
				ny = y + rl[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == '*')
					break;

				moveCheck = true;
				visited[nx][ny] = true;
				dotCount++;
				x = nx;
				y = ny;
			}
			
			if(!moveCheck)
				continue;
			
			if(dir == i) {
				searchMin(x,y,i,count,dotCount);
			}else
				searchMin(x,y,i,count+1,dotCount);
			
			int diff = dotCount - tmpCount;
			for(int j = 0 ; j < diff; j++) {
				visited[x][y] = false;
				dotCount--;
				
				x -= ud[i];
				y -= rl[i];
			}
		}
	}
}
