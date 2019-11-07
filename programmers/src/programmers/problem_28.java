package programmers;
import java.util.*;
//네트워크 => 15.4
public class problem_28 {
	static boolean visited[][];

	public static void main(String[] args) {
		int tmp [][] = {{1,0,0,1},{0,1,1,1},{0,1,1,0},{1,1,0,1}};
		int result = solution(4,tmp);
		System.out.println(result);
	}

	public static int solution(int n, int[][] computers) {
		visited = new boolean[n][n];
		int count = 0;
		for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers[i].length; j++) {
				if (!visited[i][j] && computers[i][j] != 0) {
					//visited[i][j] = true;
					dfs(computers,i,j);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int[][] computers, int nextX,int nextY) {
		if(visited[nextY][nextX])
			return ;
		visited[nextY][nextX] = true;
		Queue<Integer> queue = new LinkedList<>();
		for(int i =0 ; i< computers.length ; i++) {
			if(computers[nextY][i] !=0 && !visited[nextY][i])
				queue.add(i);
		}
		int x = nextY;
		while(!queue.isEmpty()) {
			int y = queue.poll();
			if(!visited[x][y] && computers[x][y] != 0)
			{
				visited[x][y] = true;
				dfs(computers,x,y);
			}
		}
		
	}
}
