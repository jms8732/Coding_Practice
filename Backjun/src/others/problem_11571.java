package others;

/*
 * 분수를 소수로
 * 구현 + 나머지 연산을 이용해서 문제를 해결한다.
 * 순환소수의 Key 포인트는 한번 방문한 나머지를 다시 방문할 경우, 순환이 발생한다는 점이다.
 * 분자의 범위가 0<= <= 1024이므로 방문 채크를하기 위해 배열의 크기를 1024로 설정하여 진행한다.
 */
import java.util.*;
import java.io.*;

public class problem_11571 {
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int c = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			simulation(c, p); //분자가 0일 때의 문제가 아님
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static void simulation(int c, int p) throws IOException {
		StringBuilder sb = new StringBuilder();
		int[] visited = new int[1025];
		Arrays.fill(visited, -1);

		sb.append(c / p + ".");

		c = c % p; // 나머지

		int seq = sb.indexOf(".");
		visited[c] = seq++;

		while (true) {
			c *= 10;

			int div = c / p;
			int mod = c % p;

			sb.append(div);

			if (visited[mod] != -1) {
				// 순환되는 지점
				sb.insert(visited[mod] + 1, "(");
				sb.append(")");
				bw.write(sb.toString());
				bw.newLine();
				break;
			}

			visited[mod] = seq++;
			c = mod;
		}

	}

}
