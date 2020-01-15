package backTracking;

//알파벳

import java.util.*;
import java.io.*;
public class problem_1987 {
	static int ud[] = {-1,0,1,0};
	static int rl[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean [] visited = new boolean[26]; //대문자 알파벳의 중복 유무를 판단
		char[][] map = new char[R][C];
		
		//초기화
		for(int i =0 ; i < map.length ; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < map[i].length ; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
		
		br.close();
		visited[map[0][0] % 'A'] = true;
		int result = dfs(0,0,1,visited,map);
		System.out.println(result);
	}
	
	private static int dfs(int x,int y,int count ,boolean[] visited, char[][] map) {
		int tmpCount = count;
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];
			
			//범위를 벗어나는 경우
			if(nx <0 || nx >= map.length || ny < 0 || ny >= map[nx].length)
				continue;
			
			if(!visited[map[nx][ny] % 'A']) {
				//아직 방문하지 않은 곳이라면
				visited[map[nx][ny] % 'A' ] = true;
				tmpCount = Math.max(tmpCount,dfs(nx,ny,count+1,visited,map));
				visited[map[nx][ny] % 'A']= false;
				
			}
		}
		
		return tmpCount;
	}
}
