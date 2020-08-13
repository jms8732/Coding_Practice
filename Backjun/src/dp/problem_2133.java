package dp;

//타일 채우기
import java.util.*;
import java.io.*;

public class problem_2133 {
	static int cache[][];
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		cache = new int[31][8];

		if (N % 2 == 0) {
			cache[0][6] = cache[0][3] = cache[0][0] = 1;
			
			for(int i =1 ; i < N ; i++) {
				cache[i][0] = cache[i-1][7];
				cache[i][1] = cache[i-1][6];
				cache[i][3] = cache[i-1][4] + cache[i-1][7];
				cache[i][6] = cache[i-1][1] + cache[i-1][7];
				cache[i][4] = cache[i-1][3];
				cache[i][7] = cache[i-1][6] + cache[i-1][3] + cache[i-1][0];
			}
			
			System.out.println(cache[N-1][7]);
		}else
			System.out.println(0);

	}

}
