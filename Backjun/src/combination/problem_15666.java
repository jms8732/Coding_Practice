package combination;

//N�� M(12)
import java.util.*;
import java.io.*;

public class problem_15666 {
	static Set<String> doubleCheck;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] value = new int[N];
		st = new StringTokenizer(br.readLine());
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < value.length; i++)
			value[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(value);
		StringBuilder sb = new StringBuilder();
		doubleCheck = new HashSet<>();
		int depth = 0, next = 0;
		dfs(depth,next, M, N, value, sb);
		
		bw.close();
		br.close();
	}

	private static void dfs(int depth,int next, int M, int N, int[] value, StringBuilder sb) {
		if (depth == M) {
			String tmp = sb.toString().trim();
			if (!doubleCheck.contains(tmp)) {
				doubleCheck.add(tmp);
				print(tmp);
			}
			return;
		}

		for (int i = next; i < N; i++) {
			String tmp = Integer.toString(value[i]);
			sb.append(tmp + " ");
			dfs(depth + 1, i,M, N, value, sb);
			sb.delete(sb.length() - tmp.length() - 1, sb.length());

		}
	}

	private static void print(String s) {
		try {
			bw.write(s + "\n");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
