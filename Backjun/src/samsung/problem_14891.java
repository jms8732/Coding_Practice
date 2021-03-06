package samsung;

//톱니 바퀴
import java.util.*;
import java.io.*;

public class problem_14891 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Gear[] g = new Gear[4];

		for (int i = 0; i < 4; i++) {
			String tmp = br.readLine();
			int[][] tmpG = new int[3][3];

			int row = 0, col = 1;
			int up = 1, right = 1;
			for (int j = 0; j < tmp.length(); j++) {
				tmpG[row][col] = tmp.charAt(j) - '0';

				if (row == 0 && col < 2) {
					col += right;
				} else if (row < 2 && col == 2) {
					row += up;
				} else if (row == 2 && col > 0) {
					col -= right;
				} else if (row >= 0 && col == 0)
					row -= up;

			}

			g[i] = new Gear(tmpG);
		}

		int K = Integer.parseInt(br.readLine());

		boolean [] visited =new boolean[4];
		StringTokenizer st = null;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int number = Integer.parseInt(st.nextToken()) - 1;
			int direction = Integer.parseInt(st.nextToken());

			activate(g, number, direction,visited);
		}

		int answer = 0;
		
		for (int i = 0; i < 4; i++) {
			if (g[i].gear[0][1] == 1)
				answer += (int) Math.pow(2, i);
		}

		System.out.println(answer);

	}

	private static void activate(Gear[] g, int number, int direction, boolean[] visited) {
		if(number <0 || number > g.length)
			return;
		
		// 현재 톱니바퀴가 반시계방향으로 이동할 경우,
		// 현재 톱니바퀴의 극을 확인한다.
		int left = g[number].gear[1][0];
		int right = g[number].gear[1][2];
		
		visited[number] = true;
		
		if(number - 1>=0) {
			//왼쪽이 가능한 경우
			int previous = g[number-1].gear[1][2];
			
			if(left != previous && !visited[number-1])
				activate(g,number-1,direction*-1,visited);
		}
		
		if(number + 1 < g.length) {
			int next = g[number+1].gear[1][0];
			
			if(next != right && !visited[number+1])
				activate(g,number+1,direction*-1,visited);
		}
		
		rotation(g[number].gear,direction);
		visited[number] = false;
		
	}

	private static void rotation(int[][] gear, int direction) {
		if (direction == -1) {
			// 반시계 방향으로 회전
			int x = 0, y = 1, startX = x, startY = y;
			int nx = 0, ny = 1;
			int current = gear[x][y];
			int next = 0;
			while (true) {
				if (x == 0 && y > 0)
					ny = y - 1;
				else if (x < 2 && y == 0)
					nx = x + 1;
				else if (x == 2 && y < 2) {
					ny = y + 1;
				} else
					nx = x - 1;

				next = gear[nx][ny];
				gear[nx][ny] = current;
				current = next;

				x = nx;
				y = ny;

				if (startX == x && startY == y)
					break;
			}
		} else {
			int x = 0, y = 1, startX = x, startY = y;
			int nx = 0, ny = 1;
			int current = gear[x][y];
			int next = 0;
			while (true) {
				if (x == 0 && y < 2) {
					ny = y + 1;
				} else if (x < 2 && y == 2)
					nx = x + 1;
				else if (x == 2 && y > 0)
					ny = y - 1;
				else
					nx = x - 1;

				next = gear[nx][ny];
				gear[nx][ny] = current;
				current = next;

				x = nx;
				y = ny;

				if (startX == x && startY == y)
					break;
			}
		}
	}

	private static class Gear {
		int[][] gear;

		public Gear(int[][] g) {
			this.gear = new int[3][3];
			int idx = 0;
			for (int tmp[] : g) {
				System.arraycopy(tmp, 0, this.gear[idx++], 0, tmp.length);
			}
		}
	}
}
