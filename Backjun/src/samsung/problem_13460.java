package samsung;
//구슬 탈출2
import java.util.*;

public class problem_13460 {
	static char[][] board;
	static int[] ud = { -1, 0, 1, 0 };
	static int[] rl = { 0, 1, 0, -1 };
	static boolean[][][][] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		visited = new boolean[N][M][N][M]; // R의 x,y 좌표, B의 x,y 좌표
		int rx = 0, ry = 0, bx = 0, by = 0, count = 0;
		int gx, gy;
		scanner.nextLine();
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String tmp = scanner.nextLine();
			for (int j = 0; j < tmp.length(); j++) {
				if (tmp.charAt(j) == 'R') {
					rx = i;
					ry = j;
				} else if (tmp.charAt(j) == 'B') {
					bx = i;
					by = j;
				} else if (tmp.charAt(j) == 'O') {
					gx = i;
					gy = j;
				}
				board[i][j] = tmp.charAt(j);
			}
		} // 좌표 설정 및 보드판에 채워 넣기
		System.out.println(bfs(rx,ry,bx,by,count));
	}

	static int bfs(int rx,int ry ,int bx, int by, int count) {
		int tmpRX = rx, tmpRY = ry;
		int tmpBX = bx, tmpBY = by;
		List<Pair> list = new Vector<Pair>();
		Pair p = new Pair(rx, ry, bx, by, count);
		list.add(p);
		while (!list.isEmpty()) {
			p = list.get(0);
			list.remove(0);
			if (p.count > 10) {
				return -1;
			}
			//System.out.println("rX : " + p.rx + " rY : " + p.ry + " bX : " + p.bx + " bY : " + p.by + " count : " + p.count);
		
			if (board[p.rx][p.ry] == 'O') {
				if (board[p.bx][p.by] != 'O') {
					return p.count;
				}
			}

			visited[p.rx][p.ry][p.bx][p.by] = true;
			for (int i = 0; i < 4; i++) {
				tmpRX = p.rx;
				tmpRY = p.ry;
				tmpBX = p.bx;
				tmpBY = p.by;
				boolean rc = false, bc = false;
				int ix = ud[i];
				int iy = rl[i];
				while (true) {
					// 빨간색 구슬
					if (board[tmpRX][tmpRY] == '#') {
						tmpRX -= ix;
						tmpRY -= iy;
						break;
					} else if (board[tmpRX][tmpRY] == 'O') {
						rc = true;
						break;
					}

					tmpRX += ix;
					tmpRY += iy;
				}
				while (true) {
					// 파란색 구슬
					if (board[tmpBX][tmpBY] == '#') {
						tmpBX -= ix;
						tmpBY -= iy;
						break;
					} else if (board[tmpBX][tmpBY] == 'O') {
						bc = true;
						break;
					}

					tmpBX += ix;
					tmpBY += iy;
				}

				// 위치 변경
				if (!rc && !bc) {
					if (tmpRX == tmpBX && tmpBY == tmpRY) {
						int diffBX = Math.abs(p.bx - tmpBX);
						int diffBY = Math.abs(p.by - tmpBY);
						int diffRX = Math.abs(p.rx - tmpRX);
						int diffRY = Math.abs(p.ry - tmpRY);
						if (diffBY == 0 && diffRY == 0) {
							if (diffRX > diffBX) {
								tmpRX -= ix;
							} else
								tmpBX -= ix;
						} else if (diffBX == 0 && diffRX == 0) {
							if (diffRY > diffBY) {
								tmpRY -= iy;
							} else
								tmpBY -= iy;
						}

					}
				}
				if (!visited[tmpRX][tmpRY][tmpBX][tmpBY]) // 안갔던 곳일 경우
				{
					//System.out.println("rX : " + tmpRX + " rY : " +tmpRY + " bX : " +tmpBX + " bY : " +tmpBY + " count : " + p.count);
					int tmpC = p.count;
					tmpC++;
					Pair pp = new Pair(tmpRX, tmpRY, tmpBX, tmpBY, tmpC);
					list.add(pp);
				}
			}
		}
		return-1;
	}
}

class Pair {
	int rx, ry, bx, by, count;

	Pair(int rx, int ry, int bx, int by, int count) {
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.count = count;
	}
}
