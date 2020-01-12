package programmers1;

//나누어 떨어지는 수
import java.util.*;

public class problem_33 {
	public static void main(String[] args) {

	}

	public static int[] solution(int[] arr, int divisor) {
		List<Integer> list=  new ArrayList<>();
		for(int i = 0 ; i <arr.length ; i++) {
			if(arr[i] % divisor == 0)
				list.add(arr[i]);
		}
		if(list.isEmpty()) {
			int [] tmp = new int[1];
			tmp[0] = -1;
			return tmp;
		}
		int [] answer = new int[list.size()];
		for(int i =0 ; i < list.size() ; i++)
			answer[i] = list.get(i);

		Arrays.sort(answer);
		return answer;
	}
}
