package others;

//바이러스
import java.util.*;
import java.io.*;

public class problem_2606 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[] computer = new int[N];

		// 초기화 과정
		for (int i = 0; i < N; i++) {
			computer[i] = i;
		}

		int M = Integer.parseInt(br.readLine());

		// 네트워크 개수만큼 union-find 수행
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int p1 = Integer.parseInt(st.nextToken()) - 1;
			int p2 = Integer.parseInt(st.nextToken()) - 1;

			union_find(computer, p1, p2);
		}

		int ans = 0;
		for (int i = 1; i < computer.length; i++)
			if (find(0,computer) == find(i,computer))
				ans++;

		System.out.println(ans);
	}

	private static void union_find(int[] computer, int v1, int v2) {
		int p1 = find(v1, computer);
		int p2 = find(v2, computer);
		
		if (p1 == p2)
			return;

		if (p1 < p2) {
			computer[p2] = p1;
		} else
			computer[p1] = p2;
	}

	private static int find(int v1, int[] computer) {
		if (v1 == computer[v1]) {
			return v1;
		} else
			return find(computer[v1], computer);
	}
}
