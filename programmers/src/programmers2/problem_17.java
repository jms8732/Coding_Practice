package programmers2;

import java.util.*;
//프로그래밍 2
public class problem_17 {
	public static void main(String[] args) {
		String tmp = "{{20,111},{111}}";
		System.out.println(solution(tmp));
	}

	public static int[] solution(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb = sb.delete(0,1);
		sb = sb.delete(sb.length()-1, sb.length());
		
		List<String> list = new ArrayList();
		for(int i =0 ; i <sb.length();  i++) {
			StringBuilder tmp = new StringBuilder();
			if(sb.charAt(i) == '{') {
				i++;
				while(sb.charAt(i) != '}') {
					tmp.append(sb.charAt(i));
					i++;
				}
				list.add(tmp.toString());
			}
		}
		
		list.sort(new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				if(arg0.length() < arg1.length())
					return -1;
				else
					return 1;
			}
			
		});
		
		
		Set<Integer> set = new LinkedHashSet<>();
		
		for(int i =0 ; i < list.size() ; i++) {
			String tmp = list.get(i);
			String[] split = tmp.split(",");
			for(int j = 0 ; j< split.length ; j++) {
				set.add(Integer.parseInt(split[j]));
			}
			
		}
		
		
		int [] answer = new int[set.size()];
		Iterator<Integer> it = set.iterator();
		int idx =0 ;
		while(it.hasNext()) {
			answer[idx++] = it.next();
		}
		
		return answer;
	}
}
