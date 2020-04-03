package programmers2;

import java.util.*;

public class test {
	public static void main(String[] args) {
		String[] tmp = { "word", "war" };

		Trie head = new Trie(' ');

		for (int i = 0; i < tmp.length; i++) {
			buildTree(tmp[i], head);
		}

		int answer =0 ;
		for (int i = 0; i < tmp.length; i++) {
			answer += findMin(tmp[i], head);
		}
		
		System.out.println(answer);

	}

	private static int findMin(String target, Trie parent) {
		int idx = 0;
		Trie tmp = null;
		
		while (!parent.isFinish) {
			int index = parent.isContain(target.charAt(idx));

			tmp = parent.children.get(index);
			if(tmp.count == 1)
				break;
			
			parent = tmp;
			idx++;
		}
		
		return idx+1;
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

		parent.isFinish = true;
	}

	private static class Trie {
		boolean isFinish;
		char value;
		List<Trie> children;
		int count;

		Trie(char c) {
			this.value = c;
			this.count = 1;
			this.children = new ArrayList<>();

		}

		public void isFinsih(int idx, String target) {
			if (idx >= target.length())
				this.isFinish = true;

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
