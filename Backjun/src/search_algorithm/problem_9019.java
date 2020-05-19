package search_algorithm;

//DSLR
import java.util.*;
import java.io.*;

public class problem_9019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			bw.write(simulation(A, B) + "\n");
		}

		bw.flush();
	}

	private static String simulation(int a, int b) {
		String[] op = new String[10000];
		boolean[] check = new boolean[10000]; 
		String[] operation = { "D", "S", "L", "R" };
		Queue<Integer> q = new LinkedList<>();
		
		check[a] = true;
		Arrays.fill(op, "");
		q.add(a);

		String answer = null;
		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == b) {
				answer = op[now];
				break;
			}
			for (int i = 0; i < 4; i++) {
				int transform = activate(now, i);
				if (!check[transform]) {
					check[transform] = true;
					op[transform] = op[now] + operation[i];
					q.add(transform);
				}
			}
		}

		return answer;
	}


	private static int activate(int a, int i) {
		int ret = a;
		switch (i) {
		case 0:
			ret *= 2;
			ret %= 10000;
			break;

		case 1:
			if (ret == 0)
				ret= 9999;
			else
				ret -= 1;
			break;

		case 2:
			ret = (ret % 1000) * 10 + ret /1000;
			break;

		case 3:
			ret = (ret % 10) * 1000 + ret / 10;
			break;
		}

		return ret;
	}

}
