package dfs;
import java.util.*;

public class problem_2583 {
	static int[][] map;
	static boolean [][] visited;
	static int [] lr = {-1,0,1,0};
	static int [] ud = {0,-1,0,1};
	static int total = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Vector<Integer> v = new Vector<>();
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		map = new int[y][x];
		visited = new boolean[y][x];
		int rc = scanner.nextInt();
		for (int i = 0; i < rc; i++) {
			int lx = scanner.nextInt();
			int ly = scanner.nextInt();
			int rx = scanner.nextInt();
			int ry = scanner.nextInt();

			int dy = ry - ly;
			int dx = rx - lx;

			for (int j = 0; j < dy; j++) {
				for (int k = 0; k < dx; k++) {
					map[lx + k][ly+j] = 1;
				}
			}
		}/*
		for(int i= 0 ; i < map.length; i++) {
			for(int j= 0 ; j< map[i].length;  j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}*/
		for(int i= 0 ; i < map.length; i++) {
			for(int j= 0 ; j< map[i].length;  j++) {
				if(!visited[i][j] && map[i][j] == 0)
				{
					visited[i][j] = true;
					total++;
					total = DFS(i,j);
					v.add(total);
					total = 0;
				}
			}
		}
		
		System.out.println(v.size());
		Object[] obj = v.toArray();
		Arrays.sort(obj);
		for(int i = 0 ; i< obj.length; i++) {
			System.out.print(obj[i] + " ");
		}
	}
	static int DFS(int x,int y) {
		for(int i =0 ; i < lr.length ; i++) {
			int nx = x + lr[i];
			int ny = y + ud[i];
			
			if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[nx].length) {
				continue;
			}else {
				if(!visited[nx][ny] && map[nx][ny] == 0)
				{
					visited[nx][ny] = true;
					total++;
					DFS(nx,ny);
				}
			}
		}
		
		return total;
	}
}
