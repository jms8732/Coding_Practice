package search_algorithm;

//양
import java.util.*;
import java.io.*;

public class problem_3184 {
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();

			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		simulation(N, M, map);
	}

	private static void simulation(int N, int M, char[][] map) {
		boolean[][] visited = new boolean[N][M];

		List<Point> s = new ArrayList<>();
		List<Point> w = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'v' && !visited[i][j]) {
					visited[i][j] = true;
					calculate(map,i,j,N,M,visited);
				}
			}
		}
		
		int w_c = 0 , s_c= 0;
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < M ; j++) {
				if(map[i][j] == 'v')
					w_c++;
				
				if(map[i][j] == 'o')
					s_c++;
			}
		}
		
		System.out.println(s_c + " " + w_c);
	}

	private static void calculate(char[][] map, int x, int y, int N, int M, boolean[][] visited) {
		List<Point> w = new ArrayList<>();
		List<Point> s = new ArrayList<>();

		w.add(new Point(x, y));

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || map[nx][ny] == '#')
					continue;

				visited[nx][ny] = true;

				if (map[nx][ny] == 'v')
					w.add(new Point(nx, ny));

				if (map[nx][ny] == 'o')
					s.add(new Point(nx, ny));
				
				q.add(new Point(nx,ny));
			}
		}

		// 늑대가 양보다 많은 경우
		if (w.size() >= s.size()) {
			for (Point p : s) {
				map[p.x][p.y] = '.';
			}
		} else {
			for (Point p : w) {
				map[p.x][p.y] = '.';
			}
		}
	}
	
	private static void print(char [][] map) {
		for(int i =0 ; i < map.length ; i++) {
			for(int j =0 ; j < map[i].length ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
