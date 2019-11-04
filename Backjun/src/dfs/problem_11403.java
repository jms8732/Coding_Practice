package dfs;
import java.util.*;

public class problem_11403 {
	static int[][] map;
	static int[][] result;
	static int x;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		map = new int[N][N];
		result = new int[N][N];
		for(int i =0 ; i < N ; i++) {
			for (int j =0 ;  j< N ; j++) {
				int tmp = scanner.nextInt();
				map[i][j]  = tmp;
			}
		}
		for(int i = 0 ; i < map.length; i++) {
			for(int j = 0 ; j< map[i].length ; j++) {
				if(map[i][j] == 1) {
					result[i][j] = 1;
					x = i;
					DFS(j);
				}
			}
		}
		for(int[] tmp : result) {
			for(int t : tmp) {
				System.out.print(t + " ");
			}
			System.out.println();
		}
	}
	static void DFS(int y) {
		for(int i = 0 ; i< map[y].length;i++) {
			if(map[y][i] == 1 && result[x][i] == 0) {
				result[x][i]= 1;
				DFS(i);
			}
		}
	}
}
