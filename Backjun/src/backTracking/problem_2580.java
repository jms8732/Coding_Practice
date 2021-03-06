package backTracking;

//스도쿠
import java.util.*;
import java.io.*;

public class problem_2580 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[9][9];
		List<Node> list = new LinkedList<>();
		StringTokenizer st = null;

		// 초기값 할당
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < map[i].length; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 0)
					list.add(new Node(i, j)); // 현재 0인 좌표를 저장
				map[i][j] = tmp;
			}
		}
		boolean visited[] = new boolean[9];
		int depth = 0;
		dfs(depth,list, visited, map);
		for(int i =0 ; i< 9 ; i++) {
			for(int j =0 ; j< 9 ; j++)
				System.out.print(map[i][j] + " " );
			System.out.println();
		}
	}

	private static boolean dfs(int depth, List<Node>list, boolean[] visited, int[][] map) {
		if(depth == list.size()) {
			return true;
		}

		Node tmp = list.get(depth);
		//현재 좌표
		int i = tmp.x;
		int j = tmp.y;

		// 1. 각각의 가로줄과 세로줄에는 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
		vertical(j, visited, map); // 세로
		horizental(i, visited, map); // 가로
		// 2. 굵은 선으로 구분되어 있는 3x3정사각형 안에서도 1부터 9까지의 숫자가 한 번씩만 나타나야 한다.
		square(i, j, visited, map);
		boolean tmpVisited[] = new boolean[9];
		boolean check = false;
		System.arraycopy(visited, 0, tmpVisited, 0, 9);
		for (int k = 0; k < visited.length; k++) {
			if (!visited[k]) {
				map[i][j] = k + 1; // 선택된 값 대입
				Arrays.fill(visited, false); // 초기화	
				check = dfs(depth+1,list, visited, map);
				if(check)
					break;
				System.arraycopy(tmpVisited, 0, visited, 0, 9);
				map[i][j] = 0;
			}
		}
		
		return check;

	}

	private static void print(int[][] map) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void square(int x, int y, boolean[] visited, int[][] map) {
		int row = x / 3;
		int col = y / 3;

		row *= 3;
		col *= 3;

		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (map[i][j] != 0 && !visited[map[i][j] - 1])
					visited[map[i][j] - 1] = true;
			}
		}
	}

	private static void horizental(int x, boolean[] visited, int[][] map) {
		for (int i = 0; i < 9; i++) {
			if (map[x][i] != 0 && !visited[map[x][i] - 1])
				visited[map[x][i] - 1] = true;
		}
	}

	private static void vertical(int y, boolean[] visited, int[][] map) {
		for (int i = 0; i < 9; i++) {
			if (map[i][y] != 0 && !visited[map[i][y] - 1])
				visited[map[i][y] - 1] = true;
		}
	}

	private static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
