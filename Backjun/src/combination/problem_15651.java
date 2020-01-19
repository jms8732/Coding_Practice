package combination;

//N°ú M (3)
import java.io.*;
import java.util.*;

public class problem_15651 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int depth = 0;
		dfs(depth, N,M,sb,bw);
		bw.close();
	}

	private static void dfs(int depth, int N,int M, StringBuilder sb,BufferedWriter bw) throws IOException {
		if (depth == M) {
			print(sb.toString().trim(),bw);
			return;
		}

		for(int i =1 ; i <= N ; i++) {
			sb.append(i);
			sb.append(" ");
			dfs(depth+1,N,M,sb,bw);
			sb.delete(sb.length()-2 , sb.length());
		}
	}

	private static void print(String s,BufferedWriter bw) throws IOException {
		bw.write(s + "\n");
		bw.flush();
	}
}
