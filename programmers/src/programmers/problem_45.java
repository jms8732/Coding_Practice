package programmers;
//단어 변환

import java.util.*;

public class problem_45 {
	public static void main(String[] args) {
		String [] tmp = {"hot", "dot", "dog", "lot", "log", "cog"};
		int result = solution("hit","cog",tmp);
		System.out.println(result);
	}

	public static int solution(String begin, String target, String[] words) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < words.length; i++) {
			set.add(words[i]); // 집합에 값 넣음
		}

		if(!set.contains(target)) //해당 값이 없을 경우
			return 0;
		
		Queue<Node> queue = new LinkedList<>();
		boolean check = false; // 문자가 한개만 다른지 판단
		int count = 0;

		Iterator it = set.iterator();

		//첫 부분
		while (it.hasNext()) {
			String value = (String) it.next();
			for (int i = 0; i < begin.length(); i++) {
				if (value.charAt(i) != begin.charAt(i))
					count++; // 다른 문자 개수 판단.
			}
			if (count == 1) {
				// 한개가 다른 경우
				Set<String> tmpOriginal = new HashSet<>(set);
				Set<String> tmpSet = new HashSet<>();
				tmpSet.add(value);
				tmpOriginal.removeAll(tmpSet); // 차집합
				
				queue.add(new Node(tmpOriginal, value,1));
			}
			count = 0;
		}
		while(!queue.isEmpty()) {
			Node tmp = queue.poll();
			begin = tmp.current; //현재 시작하는 문자열
			it = tmp.set.iterator();

			if(target.equals(begin))
				return tmp.count;
			while (it.hasNext()) {
				String value = (String) it.next();
				for (int i = 0; i < begin.length(); i++) {
					if (value.charAt(i) != begin.charAt(i))
						count++; // 다른 문자 개수 판단.
				}
				if (count == 1) {
					// 한개가 다른 경우
					Set<String> tmpOriginal = new HashSet<>(tmp.set);
					Set<String> tmpSet = new HashSet<>();
					tmpSet.add(value);
					tmpOriginal.removeAll(tmpSet); // 차집합
					int tmpCount = tmp.count;
					queue.add(new Node(tmpOriginal, value, tmpCount+1));
				}
				count = 0;
			}
		}
		return -1;
	}

	public static class Node {
		Set<String> set; // 다음 넘어가야될 목록들
		String current;
		int count =0 ;
		public Node(Set<String> set, String c, int count) {
			this.current = c;
			this.set = new HashSet<>(set);
			this.count =count;
		}
	}
}
