package dp;

//ÆÓ¸° µå·Ò?
import java.util.*;
import java.io.*;

public class problem_10942 {
	static int cache[][], N, array[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		array = new int[N];
		cache = new int[N + 1][N + 1];

		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		for (int c[] : cache)
			Arrays.fill(c, -1);

		int tc = Integer.parseInt(br.readLine());


		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;

			bw.write(palindrom(s, e) + "\n");
		}
		bw.flush();
	}

	private static int palindrom(int s, int e) {
		if (s >= e)
			return 1;

		if (cache[s][e] != -1)
			return cache[s][e];

		cache[s][e] = 0;

		if (array[s] == array[e])
			cache[s][e] = palindrom(s + 1, e - 1);

		return cache[s][e];
	}
}
