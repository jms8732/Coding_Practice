package programmers1;

//이중우선순위 큐
import java.util.*;

public class problem_5 {
	public static void main(String[] args) {
		String[] tmp = {"I 16","I -5643","D -1","D 1","D 1","I 123","D -1"};
		int[] result = solution(tmp);
		for(int i : result)
			System.out.print(i + " ");
	}

	public static int[] solution(String[] operations) {
		List<Integer> list = new LinkedList<>();
		for(int i =0 ; i< operations.length ; i++) {
			StringTokenizer st =new StringTokenizer(operations[i]); //빈칸을 대상으로 문자열을 자른다.
			switch(st.nextToken()) {
			case "I":
			{
				//숫자 삽입
				int tmp = Integer.parseInt(st.nextToken());
				list.add(tmp);
				break;
			}
			case "D":
			{
				if(list.isEmpty())
					break;
				
				list.sort(Collections.reverseOrder());
				if(st.nextToken().equals("1")) {
					//최댓값 삭제
					list.remove(0);
				}
				else {
					//최솟값 삭제
					list.remove(list.size()-1);
				}
				break;
			}
			}
		}
		
		int [] tmp = new int[2];
		Arrays.fill(tmp, 0);
		if(list.isEmpty())
			return tmp;
		
		list.sort(Collections.reverseOrder());
		tmp[0] = list.get(0);
		tmp[1] = list.get(list.size()-1);
		
		return tmp;
	}
}
