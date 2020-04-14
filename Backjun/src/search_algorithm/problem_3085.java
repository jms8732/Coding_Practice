package search_algorithm;

import java.util.*;
import java.io.*;

public class problem_3085 {
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };
	static int answer = 0 ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char[][] map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();

			for (int j = 0; j < N; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}

		simulation(map, N);
		System.out.println(answer);
	}

	private static void simulation(char[][] map, int N) {
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					List<Point> list = new ArrayList<>();
					list.add(new Point(i,j));
					findCandy(1, i, j, map, N, visited,list);
				}
			}
		}

	}

	private static void findCandy(int depth, int x, int y, char[][] map, int N, boolean[][] visited,List<Point> list) {
		if (depth == 2) {
			searchLongCandy(map,N,list);
			return;
		}

		visited[x][y] = true;
		// 인접한 4방향
		for (int i = 0; i < 4; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
				continue;

			// 캔디가 달라야 한다.
			if (map[x][y] == map[nx][ny])
				continue;

			list.add(new Point(nx,ny));
			findCandy(depth + 1, nx, ny, map, N, visited,list);
			list.remove(list.size()-1);
		}
	}
	
	private static void searchLongCandy(char[][] map,int N, List<Point>list) {
		swap(map,list);
	
		boolean[][] visited=  new boolean[N][N];
		
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < N ; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					search(i,j,map,visited);
				}
			}
		}
		
		swap(map,list);
	}
	
	private static void print(char[][] map) {
		for(int i =0 ; i < map.length ; i++) {
			for(int j =0 ; j < map[i].length ; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void search(int x, int y , char[][] map, boolean [][] visited) {
		int tmpX = x, tmpY = y;
		//열
		int colCount = 1;
		while(true) {
			int ny = tmpY + 1;
			
			//범위를 벗어난 경우
			if(ny < 0 || ny >= map.length)
				break;
			
			//인접한 캔디가 갖지 않을 경우
			if(map[x][tmpY] != map[x][ny])
				break;
			
			colCount++;
			visited[x][ny] = true;
			tmpY = ny;
		}
		
		
		//행
		int rowCount = 1;
		while(true) {
			int nx = tmpX + 1;
			
			//범위를 벗어난 경우
			if(nx < 0 || nx >= map.length)
				break;
			
			//인접한 캔디가 갖지 않을 경우
			if(map[tmpX][y] != map[nx][y])
				break;
			
			rowCount++;
			tmpX = nx;
		}
		
		int ans = Math.max(rowCount, colCount);
		answer = Math.max(answer, ans);
	}
	
	private static void swap(char[][] map, List<Point> list) {
		Point p1 = list.get(0);
		Point p2 = list.get(1);
		
		char tmp1 = map[p1.x][p1.y];
		
		map[p1.x][p1.y] = map[p2.x][p2.y];
		map[p2.x][p2.y] = tmp1; 
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
