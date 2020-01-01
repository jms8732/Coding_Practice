package programmers1;

//영어 끝말잇기

import java.util.*;

public class problem_26 {
	public static void main(String[] args) {
		String[] tmp = {"tank","kick","know","wheel","land","dream","mother","robot","tank"};
		int [] result = solution(3,tmp);
		System.out.println(result[0] +" " + result[1]);
	}

	public static int[] solution(int n, String[] words) {
		Set<String> set = new HashSet<>();
		Stack<String> stack = new Stack<>();
		int step = 1; // 단계
		int idx = 1; // 번호
		int[] answer = new int[2];

		for (int i = 0; i < words.length; i++) {
			String target = words[i];
			if (!set.contains(target)) {
				if (stack.isEmpty()) {
					stack.add(target);
					set.add(target);
				} else {
					String tmp = stack.pop();
					int last = tmp.charAt(tmp.length()-1);
					int first = target.charAt(0);
					if(last == first) {
						set.add(target);
						stack.add(target);
					}
					else {
						//번호, 차례
						answer[0] = idx;
						answer[1] = step;
						break;
					}
				}
			}
			else {
				answer[0] = idx;
				answer[1] = step;
				break;
			}
			if(idx % n ==0) //단계가 증가할 경우
			{
				step +=1;
				idx =0;
			}
			idx++;
		}

		return answer;
	}
}
