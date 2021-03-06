package search_algorithm;

//나이트 이동
import java.util.*;
import java.io.*;

public class problem_7562 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < tc; i++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());

			int[][] map = new int[N][N];
			boolean [][] visited= new boolean[N][N];
			
			st = new StringTokenizer(br.readLine());
			int destX = Integer.parseInt(st.nextToken());
			int destY = Integer.parseInt(st.nextToken());
			
			visited[startX][startY] = true;
			moveNight(startX, startY, destX, destY, map,visited);
		}

	}

	private static void moveNight(int startX, int startY, int destX, int destY, int[][] map,boolean [][] visited) {
		int[] ud = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] rl = { 1, 2, 2, 1, -1, -2, -2, -1 };

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(startX, startY, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			
			int curX = cur.x;
			int curY = cur.y;
			int count = cur.count;

			if (curX == destX && curY == destY) {
				System.out.println(count);
				return;
			}
			
			
			for (int i = 0; i < ud.length; i++) {
				int nx = curX + ud[i];
				int ny = curY + rl[i];

				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length || visited[nx][ny])
					continue;
				
				visited[nx][ny] = true;
				queue.add(new Node(nx, ny, count + 1));
			}
		}

	}

	private static class Node {
		int x, y;
		int count;

		public Node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.count = c;
		}
	}
}
