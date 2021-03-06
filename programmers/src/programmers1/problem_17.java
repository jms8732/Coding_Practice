package programmers1;

//리틀 프랜즈

import java.util.*;

public class problem_17 {
	static int ud[] = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		String[] s = { "B.A","..*","B.*" };
		String result = solution(3, 3, s);
		System.out.println(result);
	}

	public static String solution(int m, int n, String[] board) {
		char[][] map = new char[m][n];
		Queue<Character> queue = null;
		Set<Character> set = new TreeSet<>(); // 문자를 오름차순으로 정렬
		// map 초기화
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
				if (map[i][j] >= 'A' && map[i][j] <= 'Z')
					set.add(map[i][j]);
			}
		}

		queue = new LinkedList<>(set);
		Queue<Character> queue1= new LinkedList<>(queue);
		StringBuilder sb = new StringBuilder();
		boolean check = false;
		char first = queue.peek();
		int count = 0; //중복 채크
		while (!queue.isEmpty()) {
			char target = queue.poll();
			first = target;
			outter: for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == target) {
						// 발견했을 경우 이동
						if(!check(i,j,map)) {
							queue.add(target);
							count++;
						}else {
							queue = sort(queue);
							sb.append(target);
							count = 0;
						}
						break outter;
					}
				}
			}
			
			if(count > queue.size())
				return "IMPOSSIBLE";
		
		}
		return sb.toString();
	}
	

	private static boolean check(int x, int y, char[][] map) {
		int tmpX = x, tmpY = y;

		for (int i = 0; i < 4; i++) {
			while (true) {
				int nx = x + ud[i];
				int ny = y + rl[i];

				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length || map[nx][ny] == '*')
					break;

				if (map[nx][ny] == '.') {
					if (move(tmpX, tmpY, nx, ny, i, map))
						return true;
				} else {
					// 벽 혹은 타일이 있는 경우
					if (map[nx][ny] == map[tmpX][tmpY]) { // 다음좌표가 같은 경우
						map[nx][ny] = '.';
						map[tmpX][tmpY] = '.';
						return true;
					}
					else
						break;
				}

				x = nx;
				y = ny;
			}
			x = tmpX;
			y = tmpY;
		}

		return false;
	}

	private static boolean move(int px, int py, int x, int y, int direction, char[][] map) {
		direction = (direction + 1) % 4;
		int tmpX = x, tmpY = y;
		for (int i = 0; i < 2; i++) {
			// 위,아래 혹은 왼쪽, 오른쪽으로 비교하기 위해
			while (true) {
				int nx = x + ud[direction];
				int ny = y + rl[direction];

				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length || map[nx][ny] == '*')
					break;

				if (map[nx][ny] != '.') {
					x = nx;
					y = ny;
					break;
				}

				x = nx;
				y = ny;
			}

			if (map[x][y] == map[px][py]) {
				map[x][y] = '.';
				map[px][py] = '.';
				return true;
			}
			direction = (direction + 2) % 4;
			x = tmpX;
			y = tmpY;
		}

		return false;
	}

	private static Queue<Character> sort(Queue<Character> queue) {
		TreeSet<Character> set = new TreeSet<>(queue); // 현재 문자 오름차순으로 정렬
		queue = new LinkedList<>(set); // 정렬된 문자를 다시 큐에 삽입
		return queue;
	}
}
