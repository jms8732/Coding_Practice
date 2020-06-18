package others;

//전화번호 목록
import java.util.*;
import java.io.*;

public class problem_5052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int N = Integer.parseInt(br.readLine());
			Trie[] number = new Trie[10];
			List<String> list = new ArrayList<>();
			for (int k = 0; k < number.length; k++) {
				number[k] = new Trie(k);
			}

			boolean check = false;
			for (int j = 0; j < N; j++) {
				list.add(br.readLine());
			}
			if (!make_Trie(list, number))
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}

	private static boolean make_Trie(List<String> list, Trie[] number) {
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if (o1.length() < o2.length())
					return -1;
				else if (o1.length() == o2.length())
					return 0;
				else
					return 1;
			}

		});

		for (int i = 0; i < list.size(); i++) {
			Trie cur = number[list.get(i).charAt(0) - '0'];

			if (cur.finish && list.get(i).length() >= 1)
				return false;

			for (int j = 1; j < list.get(i).length(); j++) {
				int n = list.get(i).charAt(j) - '0';

				if (cur.children[n] == null) {
					if (cur.finish)
						return false;
					cur.children[n] = new Trie(n);
				}
				cur = cur.children[n];
			}

			cur.finish = true;
		}
		return true;
	}

	private static class Trie {
		int current;
		Trie[] children;
		boolean finish;

		public Trie(int c) {
			current = c;
			children = new Trie[10];
			finish = false;
		}
	}
}
