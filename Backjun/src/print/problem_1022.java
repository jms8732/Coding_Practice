package print;

//소용돌이 예쁘게 출력하기
import java.util.*;
import java.io.*;

public class problem_1022 {
	static int ud[] = { 0, -1, 0, 1 };
	static int rl[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());

		int row = Math.abs(r2 - r1);
		int col = Math.abs(c2 - c1);

		row += 1;
		col += 1;

		int[][] array = new int[row][col];
		simulation(array, r1, c1, r2, c2);

	}

	private static void simulation(int[][] array, int r1, int c1, int r2, int c2) {
		int val = 1;
		int dir = 0;
		int count = 1;

		int zero_count = array.length * array[0].length;

		int x = 5000;
		int y = 5000;

		r1 = x + r1;
		c1 = y + c1;
		r2 = x + r2;
		c2 = y + c2;

		if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
			array[x - r1][y - c1] = val;
			zero_count--;
		}

		val++;
		while (zero_count > 0) {
			for (int i = 0; i < count; i++) {
				int nx = x + ud[dir];
				int ny = y + rl[dir];

				if (nx >= r1 && nx <= r2 && ny >= c1 && ny <= c2) {
					array[nx - r1][ny - c1] = val;
					zero_count--;
				}

				val++;
				x = nx;
				y = ny;
			}

			if (dir == 3)
				dir = 0;
			else
				dir++;

			if (dir == 0 || dir == 2)
				count++;
		}

		print(array);

	}

	private static void print(int[][] array) {
		String [][] val = new String[array.length][array[0].length];
		
		int long_len = 0;
		for(int i =0 ; i  <array.length ; i++) {
			for(int j =0 ; j < array[i].length ; j++) {
				String tmp = String.valueOf(array[i][j]);
				long_len = Math.max(long_len, tmp.length());
				
				val[i][j] = tmp;
			}
		}
		
		for(int i =0 ; i < array.length ; i++) {
			for(int j =0 ; j < array[i].length ; j++) {
				if(long_len > val[i][j].length()) {
					StringBuilder sb = new StringBuilder(val[i][j]);
					int diff = long_len - val[i][j].length();
					
					for(int k =0 ; k< diff ; k++)
						sb.insert(0, " ");
					
					val[i][j] = sb.toString();
				}
				System.out.print(val[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
