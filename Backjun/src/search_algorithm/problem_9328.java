package search_algorithm;

//열쇠
import java.util.*;
import java.io.*;

public class problem_9328 {
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			char[][] map = new char[N+2][M+2];
			
			for(char [] tmp : map) {
				Arrays.fill(tmp, '.');
			}
			
			for (int k = 1; k <= N; k++) {
				String tmp = br.readLine();
				for (int j = 1; j <= tmp.length(); j++) {
					map[k][j] = tmp.charAt(j-1);
				}
			}

			int key = 0;

			String k = br.readLine();
			if (k.length() != 1 && k.charAt(0) != '0') {
				for (int j = 0; j < k.length(); j++) {
					key |= 1 << (k.charAt(j) - 'a');
				}
			}

			simulation(map, N, M, key);
		}
	}

	private static void simulation(char[][] map, int N, int M, int key) {
		boolean[][] visited = new boolean[N+2][M+2];
		
		Queue<Point> q = new LinkedList<>();
		
		//기존에 가지고 있는 키를 이용하여 문을 연다.
		openDoor(map, N, M, key);

		q.add(new Point(0, 0));
		int answer = 0;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];
				
				// 배열 범위 밖이면서 방문한 곳, 벽인 곳
				if (nx < 0 || nx >= N+2 || ny < 0 || ny >= M+2 || visited[nx][ny] || map[nx][ny] == '*') {
					continue;
				}

				// 위치에 열쇠가 있는 경우
				if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
					//없는 열쇠만 처리한다.
					if ((key & 1 << (map[nx][ny] - 'a')) != 1 << (map[nx][ny] - 'a')) {
						key |= 1 << (map[nx][ny] - 'a');
						openDoor(map, N, M, key);
						visited =new boolean[N+2][M+2];
					}
					map[nx][ny] = '.';
				}

				//다음 위치에 문서가 있는 경우
				if (map[nx][ny] == '$') {
					map[nx][ny] = '.';
					answer++;
				}

				//다음 위치에 문이 있는 경우
				if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
					//키가없으면 통과
					if ((key & 1 << (map[nx][ny] - 'A')) != 1 << (map[nx][ny] - 'A')) 
						continue;
				}

				visited[nx][ny] = true;
				q.add(new Point(nx, ny));

			}

		}

		System.out.println(answer);
	}

	private static void print(char[][] map, int N, int M, int x, int y) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (x == i && y == j)
					System.out.print("3");
				else
					System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}


	private static void openDoor(char[][] map, int N, int M, int key) {
		for (int i = 1; i < N +2; i++) {
			for (int j = 1; j < M + 2; j++) {
				if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
					// 열쇠에 맞춰서 문을 연다
					if ((key & 1 << (map[i][j] - 'A')) == 1 << (map[i][j] - 'A')) {
						map[i][j] = '.';
					}
				}
			}
		}
	}

	private static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
