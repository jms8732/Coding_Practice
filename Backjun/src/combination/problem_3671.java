package combination;

//산업 스파이의 편지
import java.util.*;
import java.io.*;

public class problem_3671 {
	static int answer = 0;
	static boolean[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		prime = new boolean[10000000];

		prime[0] =true;
		prime[1]=true;
		for (int i = 2; i < 10000000; i++) {
			if (!prime[i]) {
				for (int j = i+i; j < 10000000; j += i) {
					prime[j] = true;
				}
			}
		}

		for (int i = 0; i < tc; i++) {
			char[] numbers = br.readLine().toCharArray();
			StringBuilder sb = new StringBuilder();
			boolean[] visited = new boolean[numbers.length];
			Set<Integer> doubleCheck = new HashSet<>();
			combination( sb, numbers, visited, doubleCheck);
			System.out.println(answer);
			answer = 0;
		}
	}

	private static void combination( StringBuilder sb, char[] numbers, boolean[] visited, Set<Integer> dc) {
		if (numbers.length == sb.length()) {
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sb.append(numbers[i]);
				int n = Integer.parseInt(sb.toString());
				
				if (!prime[Integer.parseInt(sb.toString())] && !dc.contains(n)) {
					dc.add(n);
					answer++;
				}

				combination(sb, numbers, visited, dc);

				visited[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
}
