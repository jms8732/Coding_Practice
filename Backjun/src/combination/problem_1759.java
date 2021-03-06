package combination;

//암호 만들기
import java.util.*;
import java.io.*;

public class problem_1759 {
	static boolean[] visited;
	static Set<Character> set; //모음 집합
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		visited = new boolean[r];
		set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');
		
		char[] alphabet = new char[r];
		char[] value = new char[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < r; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(alphabet);

		dfs(alphabet, value, 0,0,0, n, r);
	}

	private static void dfs(char[] alp, char[] val, int depth,int search,int count, int n, int r) {
		if (depth == n) {
			//최소 한개의 모음과 최소 두개의 자음일 경우
			if(count >= 1 && (val.length - count) >= 2)
				print(val);
			return;
		}
		for (int i = search; i < r; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if(set.contains(alp[i]))
					count+= 1;
				val[depth] = alp[i];
				dfs(alp, val, depth + 1,i+1, count, n, r);
				if(set.contains(alp[i]))
					count -= 1;
				visited[i] =false;
			}
		}
	}

	private static void print(char[] val) {
		for (char c : val)
			System.out.print(c);
		System.out.println();
	}
}
