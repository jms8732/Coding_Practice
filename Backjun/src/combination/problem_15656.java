package combination;

//N�� M(7)
import java.io.*;
import java.util.*;

public class problem_15656 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] value = new int[N];
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int i = 0; i < value.length; i++)
			value[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(value);
		int depth = 0;
		dfs(depth ,M,value, sb,bw);
		bw.close();
		br.close();
	}

	private static void dfs(int depth,int M, int[] value, StringBuilder sb, BufferedWriter bw) throws IOException {
		if (depth == M) {
			print(sb.toString(),bw);
			return;
		}

		for (int i = 0; i < value.length; i++) {
			String tmp = Integer.toString(value[i]);
			sb.append(tmp + " ");
			dfs(depth+1,M,value,sb,bw);
			sb.delete(sb.length()-tmp.length()-1, sb.length());
		}
	}

	private static void print(String sb, BufferedWriter bw) throws IOException {
		bw.write(sb + "\n");
		bw.flush();
	}
}
