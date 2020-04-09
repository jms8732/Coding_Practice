package others;

//Puyo Puyo, 42분 소요
import java.util.*;
import java.io.*;

public class problem_11559 {
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] map = new char[12][6];

		for (int i = 0; i < map.length; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < tmp.length(); j++) {
				map[i][j] = tmp.charAt(j);
			}
		}

		simulation(map);
	}

	private static void simulation(char[][] map) {
		List<List<Point>> totalList = new ArrayList<>();

		int count = 0;
		while (true) {
			searchPuyo(map, totalList);
			if (totalList.isEmpty())
				break;

			bombPuyo(map, totalList);
			downPuyo(map);
			totalList.clear();
			count++;
		}

		System.out.println(count);
	}
	
	private static void downPuyo(char[][] map) {
		for (int i = map.length - 1; i >= 0; i--) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != '.') {
					down(i, j, map);
				}
			}
		}
	}

	private static void down(int x, int y, char[][] map) {
		char tmp = map[x][y];
		map[x][y] = '.';
		
		while(true) {
			x += 1;
			
			if(x == map.length) {
				x -=1;
				break;
			}
			
			if(map[x][y] != '.') {
				x -= 1;
				break;
			}
		}
		
		map[x][y] = tmp;
		
	}

	// 찾은 4개 이상의 뿌요들을 터트린다.
	private static void bombPuyo(char[][] map, List<List<Point>> totalList) {

		for (int i = 0; i < totalList.size(); i++) {
			List<Point> cur = totalList.get(i);

			for (Point tmp : cur) {
				int x = tmp.x;
				int y = tmp.y;
				map[x][y] = '.';
			}
		}
	}

	// map을 탐색하면서 같은 색깔의 뿌요를 찾는다.
	private static void searchPuyo(char[][] map, List<List<Point>> totalList) {

		boolean[][] visited = new boolean[12][6];
		for (int i = map.length - 1; i >= 0; i--) {
			for (int j = 0; j < map[i].length; j++) {
				if (!visited[i][j] && map[i][j] != '.') {
					List<Point> value = new ArrayList<>();
					value.add(new Point(i, j));
					search(i, j, map[i][j], map, visited, value);

					// 4개 이상의 뿌요들이 모인 경우
					if (value.size() >= 4)
						totalList.add(value);
				}

			}
		}
	}

	private static void search(int x, int y, char color, char[][] map, boolean[][] visited, List<Point> value) {

		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];

			// 방문한 곳이거나 배열 범위 밖인 경우
			if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || visited[nx][ny])
				continue;

			// 상하 좌우에 같은 색깔의 뿌요를 찾은 경우
			if (color == map[nx][ny]) {
				value.add(new Point(nx, ny));
				search(nx, ny, color, map, visited, value);
			}
		}
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
