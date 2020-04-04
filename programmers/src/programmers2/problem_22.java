package programmers2;

import java.util.ArrayList;
import java.util.List;

public class problem_22 {
	public static void main(String []args) {
		String[] words = {"go","gone","guild"};
		
		System.out.println(solution(words));
	}
	public static int solution(String[] words) {
		Trie head = new Trie(' ');
		for(int i =0 ; i< words.length ; i++) {
			buildTree(words[i],head);
		}
		
		int answer = 0;
		for(int i =0 ; i < words.length ; i++) {
			answer += findMin(words[i],head);
		}
		
		return answer;
	}

	private static int findMin(String target, Trie parent) {
		int idx = 0;
		Trie tmp = null;

		while (idx < target.length()) {
			int index = parent.isContain(target.charAt(idx));

			tmp = parent.children.get(index);
			if (tmp.count == 1) {
				idx++;
				break;
			}

			parent = tmp;
			idx++;
		}

		return idx;
	}

	private static void buildTree(String target, Trie parent) {
		int idx = 0;
		while (idx < target.length()) {
			Trie tmp = null;
			int index = parent.isContain(target.charAt(idx));

			// 가지고 있지 않음
			if (index == -1) {
				tmp = new Trie(target.charAt(idx));
				parent.insert(tmp);
			} else {
				tmp = parent.children.get(index);
				tmp.setCount();
			}

			parent = tmp;
			idx++;
		}
	}

	private static class Trie {
		char value;
		List<Trie> children;
		int count;

		Trie(char c) {
			this.value = c;
			this.count = 1;
			this.children = new ArrayList<>();

		}


		public int isContain(char c) {
			int idx = -1;
			for (int i = 0; i < children.size(); i++) {
				if (children.get(i).value == c)
					return i;
			}

			return idx;
		}

		public void insert(Trie child) {
			children.add(child);
		}

		public void setCount() {
			this.count += 1;
		}
	}

}
