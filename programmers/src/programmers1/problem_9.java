package programmers1;

//같은 숫자는 싫어

import java.util.*;
public class problem_9 {
	public static void main(String[] args) {
		int [] tmp = {1,1,3,3,0,1,1};
		int [] result = solution(tmp);
		for(int i : result)
			System.out.print(i + " ");
	}
	public static int[] solution(int []arr) {
		Set<Integer> set = new LinkedHashSet<>(); //순서를 유지하기 위해서
		Vector<Integer> v = new Vector<>();
		
		for(int i =0 ; i < arr.length ; i++) {
			if(!set.contains(arr[i])) {
				v.add(arr[i]);
				set.clear();
				set.add(arr[i]);
			}	
		}
		int t [] = new int[v.size()];
		for(int i =0 ; i< v.size();  i++) {
			t[i] = v.get(i);
		}
		return t;
	}
}
