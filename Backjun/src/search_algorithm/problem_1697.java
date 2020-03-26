package search_algorithm;

//���� ����
import java.util.*;

public class problem_1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int [] count = new int[100001];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(cur == K) {
				System.out.println(count[cur]);
				break;
			}
			
			int minus = cur- 1;
			int plus = cur+1;
			int tele = 2*cur;
			
			if(0<=minus && minus <= 100000 && count[minus] == 0 && minus != N) {
				count[minus] = count[cur]+1;
				queue.add(minus);
			}
			
			if(0<=plus && plus <= 100000 &&count[plus] ==0 && plus != N) {
				count[plus] = count[cur]+1;
				queue.add(plus);
			}
			
			if(0<=tele && tele <= 100000 &&count[tele] == 0  && tele != N) {
				count[tele] = count[cur]+1;
				queue.add(tele);
			}
			
		}
	}
	
}
