package dfs;
import java.util.*;

public class problem_1012 {
	static int width, height;
	static Object ground[][];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalRound = scanner.nextInt();
		// 테스트 케이스 수
		for (int i = 0; i < totalRound; i++) {
			width = scanner.nextInt();
			height = scanner.nextInt();
			ground = new bc[width][height];
			int baeChu = scanner.nextInt();
			for (int j = 0; j < baeChu; j++) { // 배추 개수 만큼
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				ground[x][y] = new bc(x, y);
			}
			int count = calBug(ground);
			System.out.println(count);
		}

	}

	static int calBug(Object[][] ground) {
		int count = 0;
		for (int i = 0; i < ground.length; i++) { // 좌표 돌리면서 찾음
			for (int j = 0; j < ground[i].length; j++) {
				bc tmp = (bc) ground[i][j];
				if (tmp != null) {
					if (tmp.value == 1 && tmp.visited == false) {
						DFS(i, j);
						count++;
					}
				}
			}
		}
		return count;
	}

	static void DFS(int x, int y) {
		if (x >= width && x <= -1)
			return;
		if (y >= height && y <= -1)
			return;
		bc tmp = (bc) ground[x][y];
		tmp.visited = true; // 방문했음을 알림

		if (x + 1 < width) {
			tmp = (bc) ground[x + 1][y];
			if (tmp != null) {
				if (tmp.value == 1 && tmp.visited == false) // 좌
					DFS(x + 1, y);
			}
		}
		if (x - 1 >= 0) {
			tmp = (bc) ground[x - 1][y];
			if (tmp != null) {
				if (tmp.value == 1 && tmp.visited == false) // 우
					DFS(x - 1, y);
			}
		}
		if (y - 1 >= 0) {
			tmp = (bc) ground[x][y - 1];
			if (tmp != null) {
				if (tmp.value == 1 && tmp.visited == false) // 상
					DFS(x, y - 1);
			}
		}
		if (y + 1 < height) {
			tmp = (bc) ground[x][y + 1];
			if (tmp != null) {
				if (tmp.value == 1 && tmp.visited == false)// 하
					DFS(x, y + 1);
			}
		}

	}
}

class bc {
	int value;
	boolean visited;

	bc(int x, int y) {
		this.value = 1;
		this.visited = false;
	}
}
