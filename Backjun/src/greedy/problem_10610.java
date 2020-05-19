package greedy;

//30
import java.util.*;

public class problem_10610 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String number = sc.nextLine();
		PriorityQueue<Character> pq= new PriorityQueue<>(Collections.reverseOrder());
		
		
		for(int i =0 ; i < number.length() ; i++) {
			pq.add(number.charAt(i));
		}

		int ret = 0;
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			int cur = pq.poll() -'0';
			ret = ((ret * 10) + cur) % 30;
			sb.append(cur);
		}
		
		if(ret != 0)
			System.out.println(-1);
		else
			System.out.println(sb.toString());
	}
}
