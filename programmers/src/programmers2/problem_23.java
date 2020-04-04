package programmers2;

//가사 검색
import java.util.*;

public class problem_23 {
	static List<Trie>[] word;

	public static void main(String[] args) {
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "?" };

		for (int i : solution(words, queries))
			System.out.print(i + " ");
	}

	public static int[] solution(String[] words, String[] queries) {
		word = new ArrayList[10000];
		for (int i = 0; i < word.length; i++)
			word[i] = new ArrayList<>();

		for (int i = 0; i < words.length; i++) {
			int idx = words[i].length() - 1;
			StringBuilder sb = new StringBuilder(words[i]);
			if (word[idx].isEmpty()) {
				Trie head = new Trie(' ');
				Trie tail = new Trie(' ');

				buildTree(words[i], head);
				buildTree(sb.reverse().toString(), tail);

				word[idx].add(head);
				word[idx].add(tail);

			} else {
				Trie head = word[idx].get(0);
				Trie tail = word[idx].get(1);

				buildTree(words[i], head);
				buildTree(sb.reverse().toString(), tail);
			}
		}

		int[] answer = new int[queries.length];

		for (int i = 0; i < queries.length; i++) {
			int idx = queries[i].length() - 1;
			int count = 0;

			for (int j = 0; j < queries[i].length(); j++) {
				if (queries[i].charAt(j) == '?')
					count++;
			}

			if (count == queries[i].length()) {
				if (!word[idx].isEmpty()) {
					Trie head = word[idx].get(0);
					int tmp = 0;

					for (int j = 0; j < head.children.size(); j++) {
						tmp += head.children.get(j).count;
					}

					answer[i] = tmp;
				}
				continue;

			}

			if (queries[i].charAt(0) == '?') {
				if (!word[idx].isEmpty()) {
					StringBuilder sb = new StringBuilder(queries[i]);
					Trie tail = word[idx].get(1);
					answer[i] = search(sb.reverse().toString(), tail);
				}
			} else {
				if (!word[idx].isEmpty()) {
					Trie head = word[idx].get(0);
					answer[i] = search(queries[i], head);
				}
			}
		}

		return answer;
	}

	private static int search(String query, Trie parent) {
		int idx = 0;

		Trie tmp = null;
		while (query.charAt(idx) != '?') {
			char t = query.charAt(idx);
			int index = parent.isContain(t);
			if (index == -1)
				return 0;

			tmp = parent.children.get(index);

			parent = tmp;
			idx++;
		}

		int answer = tmp.count;
		return answer;

	}

	private static void buildTree(String target, Trie parent) {
		int idx = 0;
		Trie tmp = null;
		while (idx < target.length()) {
			int index = parent.isContain(target.charAt(idx));
			if (index == -1) {
				// 현재 문자가 없는 경우
				tmp = new Trie(target.charAt(idx));
				parent.children.add(tmp);
			} else {
				tmp = parent.children.get(index);
				tmp.count += 1;
			}

			parent = tmp;
			idx++;
		}
	}

	private static class Trie {
		char value;
		int count;
		List<Trie> children;

		Trie(char c) {
			this.value = c;
			this.count = 1;
			this.children = new ArrayList<>();
		}

		public int isContain(char c) {
			for (int i = 0; i < children.size(); i++) {
				if (children.get(i).value == c)
					return i;
			}

			return -1;
		}
	}

}
