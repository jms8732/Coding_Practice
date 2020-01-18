package backTracking;

//�����峭
import java.util.*;
import java.io.*;

public class problem_10597 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] array = new int[50];
		boolean[] visited = new boolean[50]; // �ߺ� ����

		String s = br.readLine();

		int depth = 0, next = 0;
		dfs(depth, next, s, array, visited);
		br.close();
	}

	private static void dfs(int depth, int next, String s, int[] array, boolean[] visited) {
		if (next >= s.length()) {
			int max = 50;

			for (int i = 0; i < visited.length; i++) {
				if (visited[i])
					max = i + 1;
			}
			int cnt = 0;
			for (int i = 0; i < array.length; i++) {
				if (array[i] != 0) {
					cnt++;
				}
			}

			if (max != cnt)
				return;

			print(array);
			System.exit(0);
		}

		for (int i = 1; i <= 2; i++) {
			if (next + i <= s.length()) {
				String tmp = s.substring(next, next + i);// ���� ����
				int value = Integer.parseInt(tmp);
				if (value == 0) // �ܵ����� 0�� �� ���
					break;
				if (value >= 1 && value <= 50 && !visited[value - 1]) {
					// �ּ� 1���� 50������ �����̹Ƿ� 50�� �ִ� �����̴�
					visited[value - 1] = true;
					array[depth] = value;
					dfs(depth + 1, next + i, s, array, visited);
					array[depth] = 0;
					visited[value - 1] = false;
				}
			}
		}
	}

	private static void print(int[] array) {
		for (int i : array) {
			if (i != 0)
				System.out.print(i + " ");
		}
		System.out.println();
	}
}
