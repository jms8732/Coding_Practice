package search_algorithm;

//¼º°û
import java.util.*;
import java.io.*;

public class problem_2234 {
	static int ud[] = { 0, -1, 0, 1 };
	static int rl[] = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		simulation(map, N, M);
	}

	private static void simulation(int[][] map, int N, int M) {
		Map<Integer,Integer> book = new HashMap<>();
		boolean[][] visited = new boolean[M][N];
		int[][] board = new int[M][N];
		int number = 1;
		
		int size = Integer.MIN_VALUE;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					
					visited[i][j] = true;
					board[i][j] = number;
					int temp = bfs(map, board, number, visited, i, j, N, M);
					size = Math.max(temp,size);
					book.put(number, temp);
					number++;
				}
			}
		}
		System.out.println(number-1);
		System.out.println(size);
		System.out.println(delete_wall_big_size(board,book,N,M));
		
	}
	
	private static int delete_wall_big_size(int [][] board, Map<Integer,Integer> book,int N ,int M ) {
		boolean [][] visited = new boolean[M][N];
		
		int total_size = Integer.MIN_VALUE;
		for(int i =0 ; i < M ; i++) {
			for(int j= 0 ; j <  N ;j++) {
				if(!visited[i][j]) {
					visited[i][j]= true;
					int cur = board[i][j];
					int size = book.get(cur);
					for(int k =0 ; k < 4;  k++) {
						int nx = i+ ud[k];
						int ny = j + rl[k];
						
						if(nx < 0|| nx>= M || ny <0 || ny>=N || visited[nx][ny] || board[nx][ny] == cur)
							continue;
						
						size += book.get(board[nx][ny]);
						break;
					}
					
					total_size = Math.max(total_size, size);
				}
			}
		}
		
		return total_size;
	}

	private static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int bfs(int[][] map, int[][] board, int num, boolean[][] visited, int x, int y, int N, int M) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));

		int ret = 1;
		while (!q.isEmpty()) {
			Point cur = q.poll();

			int wall = map[cur.x][cur.y];
		
			for (int i = 0; i < 4; i++) {
				if ((wall & (1 << i)) != (1 << i)) {
					int nx = cur.x + ud[i];
					int ny = cur.y + rl[i];

					if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny])
						continue;

					visited[nx][ny] = true;
					board[nx][ny] = num;
					ret++;
					q.add(new Point(nx, ny));
				}
			}
		}

		return ret;
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
