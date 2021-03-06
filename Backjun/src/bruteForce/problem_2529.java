package bruteForce;

//�ε�ȣ
import java.util.*;
import java.io.*;

public class problem_2529 {
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		String op = br.readLine().replaceAll(" ", "");
		visited = new boolean[10];
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <= 9; i++) {
			visited[i] = true;
			sb.append(i);
			if(make(i, 0, op, sb))
				break;
			sb.delete(sb.length() - 1, sb.length());
			visited[i] = false;
		}
		
		String min = sb.toString();
		Arrays.fill(visited, false);
		
		sb = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			visited[i] = true;
			sb.append(i);
			if(make(i, 0, op, sb))
				break;
			sb.delete(sb.length() - 1, sb.length());
			visited[i] = false;
		}

		String max = sb.toString();
		
		System.out.println(max);
		System.out.println(min);
	}

	private static boolean make(int opr, int idx, String op, StringBuilder sb) {
		if (idx == op.length()) {
			return true;
		}

		char tmp = op.charAt(idx);

		if (tmp == '>') {
			for (int i = opr - 1; i >=0; i--) {
				if (!visited[i]) {
					visited[i]= true;
					sb.append(i);
					if(make(i, idx + 1, op, sb))
						return true;
					
					sb.delete(sb.length() - 1, sb.length());
					visited[i]= false;
				}
			}
		} else {
			for (int i = opr + 1; i <= 9; i++) {
				if (!visited[i]) {
					visited[i]= true;
					sb.append(i);
					if(make(i, idx + 1, op, sb))
						return true;
					sb.delete(sb.length() - 1, sb.length());
					visited[i]= false;
				}
			}
		}
		
		return false;
	}
}
