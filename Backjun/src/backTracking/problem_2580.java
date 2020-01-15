package backTracking;

//������
import java.util.*;
import java.io.*;

public class problem_2580 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[9][9];
		List<Node> list = new LinkedList<>();
		StringTokenizer st = null;

		// �ʱⰪ �Ҵ�
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < map[i].length; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 0)
					list.add(new Node(i, j)); // ���� 0�� ��ǥ�� ����
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
		//���� ��ǥ
		int i = tmp.x;
		int j = tmp.y;

		// 1. ������ �����ٰ� �����ٿ��� 1���� 9������ ���ڰ� �� ������ ��Ÿ���� �Ѵ�.
		vertical(j, visited, map); // ����
		horizental(i, visited, map); // ����
		// 2. ���� ������ ���еǾ� �ִ� 3x3���簢�� �ȿ����� 1���� 9������ ���ڰ� �� ������ ��Ÿ���� �Ѵ�.
		square(i, j, visited, map);
		boolean tmpVisited[] = new boolean[9];
		boolean check = false;
		System.arraycopy(visited, 0, tmpVisited, 0, 9);
		for (int k = 0; k < visited.length; k++) {
			if (!visited[k]) {
				map[i][j] = k + 1; // ���õ� �� ����
				Arrays.fill(visited, false); // �ʱ�ȭ	
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
