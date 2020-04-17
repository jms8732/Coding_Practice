package bruteForce;

//¹ÌÄ£ ·Îº¿
import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class problem_1405 {
	static double simple;
	static double percent [];
	static int ud [] = {0,0,1,-1};
	static int rl [] = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		percent = new double[4];

		for (int i = 0; i < 4; i++) {
			percent[i] = Double.parseDouble(st.nextToken()) / 100.0;
		}

		simulation(N);
		System.out.print(simple);
	}

	private static void simulation(int N) {
		boolean[][] visited = new boolean[30][30];
		
		search(15,15,1.0,0,N,visited);
	}
	
	
	private static void search(int x, int y,double value, int depth ,int N, boolean[][] visited) {
		if(depth == N) {
			simple += value;
			return; 
		}
		
		visited[x][y] = true;
		for(int i =0; i < 4 ; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];
			
			if(nx < 0 || nx >= 30 || ny < 0 || ny>= 30 || visited[nx][ny])
				continue;
			
			search(nx,ny, value * percent[i],depth+1,N,visited);
			
		}
		
		visited[x][y]= false;
	}

}
