package samsung;

//연구소
import java.util.*;
import java.io.*;

public class problem_14502_1 {
	static List<Point> virus;
	static int[] ud = { -1, 0, 1, 0 };
	static int rl[] = { 0, 1, 0, -1 };
	static int answer =0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		virus = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 2) {
					virus.add(new Point(i, j));
				}

				map[i][j] = tmp;
			}
		}

		simulation(0, map, N, M, 0);
		System.out.println(answer);
	}

	private static void simulation(int depth, int[][] map, int N, int M, int start) {
		if (depth == 3) {
			// 벽을 다 세운 경우, 바이러스를 퍼뜨린다.
			int tmp[][] = new int[N][M];
			copyArray(map,tmp);
			spread_virus(map, N, M);
			//print(map,N,M);
			answer = Math.max(answer, count_safety_space(map,N,M));
			copyArray(tmp,map);
			return;
		}

		for (int i = start; i < N * M; i++) {
			int x = i / M;
			int y = i % M;

			if (map[x][y] == 0) {
				map[x][y] = 1;
				simulation(depth + 1, map, N, M, i + 1);
				map[x][y] = 0;
			}
		}
	}
	
	private static void print(int [][] map ,int N , int M) {
		for(int i=0 ; i < N ; i++) {
			for(int j =0 ; j < M ; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static int count_safety_space(int [][] map, int N ,int M) {
		int count =0 ;
		for(int i =0 ; i < N ; i++) {
			for(int j =0  ; j < M ; j++) {
				if(map[i][j] == 0)
					count++;
			}
		}
		
		return count;
	}
	
	private static void copyArray(int [][] src ,int [][] dest) {
		int idx =0 ;
		
		for(int [] tmp : src) {
			System.arraycopy(tmp, 0, dest[idx++], 0, tmp.length);
		}
	}

	private static void spread_virus(int[][] map, int N, int M) {
		Queue<Point> q = new LinkedList<>(virus);

		while (!q.isEmpty()) {
			Point cur = q.poll();
			 
			for(int i =0 ; i < 4;  i++) {
				int nx = cur.x + ud[i];
				int ny = cur.y + rl[i];
				
				if(nx < 0 || nx>= N || ny <0 || ny >= M || map[nx][ny] != 0)
					continue;
				
				map[nx][ny] = 2;
				q.add(new Point(nx,ny));
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
