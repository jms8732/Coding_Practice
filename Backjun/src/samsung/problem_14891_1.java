package samsung;

//Åé´Ï ¹ÙÄû
import java.util.*;
import java.io.*;

public class problem_14891_1 {
	static int gear[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		gear = new int[4];

		for (int i = 0; i < 4; i++) {
			String tmp = br.readLine();
			int bit = 0;

			for (int j = tmp.length() - 1; j >= 0; j--) {
				if (tmp.charAt(j) == '1')
					bit |= 1 << (tmp.length() - 1 - j);
			}

			gear[i] = bit;
		}

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int cur = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());

			boolean[] visited = new boolean[4];
			simulation(cur, dir,visited);
		
		}
		
		int answer =0 ;

		for(int j =0 ; j  < 4;  j++) {
			if((gear[j] & 1<<7) == 1<<7) {
				answer += (int)Math.pow(2, j);
			}
		}
		System.out.println(answer);
	}

	private static void simulation(int cur, int dir, boolean[] visited) {
		int left = cur - 1;
		int right = cur + 1;

		visited[cur] = true;

		// ¿ŞÂÊ ±â¾î
		if (left >=0 && !visited[left] && (Integer.bitCount(gear[cur] & 1 << 1) != Integer.bitCount(gear[left] & 1 << 5))) {
			simulation(left, dir * -1, visited);
		}

		if (right < 4 && !visited[right] && (Integer.bitCount(gear[cur] & 1 << 5) != Integer.bitCount(gear[right] & 1 << 1))) {
			simulation(right, dir * -1, visited);
		}
		
		rotate(cur,dir);
	}
	
	private static void rotate(int cur ,int dir) {
		int mask = 0;
		
		for(int i =0 ; i < 8 ;i++)
			mask |= 1<<i;

		int bit = gear[cur];
		if(dir == -1) {
			//¹İ½Ã°è
			int last = bit & 1<<7;
			last = last >> 7;
			bit = bit << 1;
			bit |= last;
			
		}else {
			//½Ã°è
			int first = bit & 1<<0;
			bit = bit >> 1;
			first = first << 7;
			bit |= first;
		}
	
		bit &= mask;
		gear[cur] =bit;
	}
}
