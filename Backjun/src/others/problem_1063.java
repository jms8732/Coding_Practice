package others;

//킹
import java.util.*;
import java.io.*;

public class problem_1063 {
	static String king_coord = "", stone_coord = "";
	static int ud[] = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static int rl[] = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		king_coord = st.nextToken();
		stone_coord = st.nextToken();

		int move = Integer.parseInt(st.nextToken());

		for (int i = 0; i < move; i++) {
			String op = br.readLine();
			int idx = index(op);
			move(idx);	
		}
		
		System.out.println(king_coord);
		System.out.println(stone_coord);
	}
	
	private static void move(int idx) {
		char col = king_coord.charAt(0);
		int row = king_coord.charAt(1) - '0';
		
		row += ud[idx];
		col += rl[idx];
		
		//범위를 벗어난 경우
		if(row <= 0 || row > 8 || col < 'A' || col > 'H')
			return;
		
		StringBuilder sb = new StringBuilder();
		sb.append(col);
		sb.append(row);
		
		//돌이 존재하는 경우
		if(sb.toString().equals(stone_coord)) {
			col = stone_coord.charAt(0);
			row = stone_coord.charAt(1) -'0';
			
			row += ud[idx];
			col += rl[idx];
			
			if(row <= 0 || row > 8 || col < 'A' || col > 'H')
				return;

			StringBuilder tmp = new StringBuilder();
			tmp.append(col);
			tmp.append(row);
			
			stone_coord = tmp.toString();
		}
		
		king_coord = sb.toString();
		
	}

	private static int index(String op) {
		int idx =-1 ;
		switch(op) {
		case "R":
			idx = 0;
			break;
		case "L":
			idx =1;
			break;
		case "B":
			idx = 2;
			break;
		case "T":
			idx = 3;
			break;
		case "RT":
			idx = 4;
			break;
		case "LT":
			idx = 5;
			break;
		case "RB":
			idx = 6;
			break;
		case "LB":
			idx = 7;
			break;
		}
		
		return idx;
	}
}
