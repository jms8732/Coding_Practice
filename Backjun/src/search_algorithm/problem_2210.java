package search_algorithm;

//숫자판 점프
import java.util.*;
import java.io.*;

public class problem_2210 {
	static int map[][];
	static Set<String> set;
	static StringBuilder sb;
	static int ud[] = {-1,0,1,0};
	static int rl[] = {0,1,0,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		set = new HashSet<>();
		
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < 5 ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i =0 ; i < 5 ; i++) {
			for(int j =0 ; j < 5 ; j++) {
				sb = new StringBuilder();
				sb.append(map[i][j]);
				makeInteger(i,j);
				sb.delete(sb.length()-1, sb.length());
			}
		}
		
		System.out.println(set.size());
	}

	private static void makeInteger(int x,int y) {
		if(sb.length() == 6) {
			if(!set.contains(sb.toString())) {
				//해당 숫자가 없을 경우
				set.add(sb.toString());
			}

			return;
		}
		
		for(int i =0 ; i< 4 ; i++) {
			int nx = x + ud[i];
			int ny = y + rl[i];
			
			if(nx < 0 || nx >= 5 || ny <0 || ny>=5)
				continue;
			
			sb.append(map[nx][ny]);
			makeInteger(nx,ny);
			sb.delete(sb.length()-1, sb.length());
		}
	}
}
