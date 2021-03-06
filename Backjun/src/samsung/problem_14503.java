package samsung;
//로봇 청소기

import java.util.*;
import java.io.*;

public class problem_14503 {
	static int map[][];
	static int rl[] = { 0, 1, 0, -1 }; // 동쪽 서쪽
	static int ud[] = { -1, 0, 1, 0 }; // 북쪽 남쪽
	static boolean visited[][]; // 로봇이 청소했는가를 판단하는 이차원 배열
	static int count; // 로봇이 청소한 구역
	static int tmpX, tmpY;
	static int M, N;

	static boolean disactivate;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		try {
			st = new StringTokenizer(br.readLine()); // 읽어들임
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[M][N]; // 맵 생성
			visited = new boolean[M][N];

			st = new StringTokenizer(br.readLine()); // 다음 라인 읽어드림
			int robotX = Integer.parseInt(st.nextToken());
			int robotY = Integer.parseInt(st.nextToken());

			//북:0, 동:1, 남:2,서:3
			int direction = Integer.parseInt(st.nextToken()); // 방향

			// 맵 값 넣기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(robotX, robotY, direction);
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private static int dfs(int x, int y, int direction) {
		int initialDirection = direction; // 초기 위치
		direction = (direction + 3) % 4;
		while (true) {
			if(disactivate)
				return 0;
			
			if (!visited[x][y]) {
				// 현재 좌표가 방문을 안했을 경우
				count++;
				visited[x][y] = true;
			}

			// 다음 좌표 설정
			int nx = x + ud[direction];
			int ny = y + rl[direction];

			if (nx < 0 || nx >= M || ny < 0 || ny >= N) // 다음 좌표값이 범위를 넘어가는 경우
				continue;

			if (!visited[nx][ny] && map[nx][ny] != 1) {
				// 다음 좌표값이 방문하지 않았을 경우
				initialDirection = dfs(nx, ny, direction);

				// 이전 좌표
				x = tmpX;
				y = tmpY;
				direction = (initialDirection + 3) % 4;
			} else if (initialDirection == direction) {
				// 네 방향을 다 돌았을 경우
				if (which(x, y, direction)) {
					// 네 방향이 모두 방문했거나 벽이 존재하고, 뒤에 벽이 없을 경우
					return direction; // 해당 방향 return
				} else {
					disactivate = true;
				}
			} else
				direction = (direction + 3) % 4;// 방향 전환
		}
	}

	private static boolean which(int x, int y, int direction) {
		switch (direction) {
		case 0: { // 방향이 북쪽인 경우, 남쪽에 벽이 있는지 판단
			if (map[x + 1][y] == 0) {
				tmpX = x + 1;
				tmpY = y;
				return true;
			}
			break;
		}
		case 1: { // 방향이 동쪽인 경우, 서쪽에 벽이 있는지 판단
			if (map[x][y -1] == 0) {
				tmpX = x;
				tmpY = y -1;
				return true;
			}
			break;
		}
		case 2: { // 방향이 남쪽인 경우, 북쪽에 벽이 있는지 판단
			if (map[x - 1][y] == 0) {
				tmpX = x - 1;
				tmpY = y;
				return true;
			}
			break;
		}
		case 3: { // 방향이 서쪽인 경우, 동쪽에 벽이 있는지 판단
			if (map[x][y + 1] == 0) {
				tmpX = x;
				tmpY = y + 1;
				return true;
			}
			break;
		}
		}

		return false;
	}
}
