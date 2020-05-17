package others;

//카드 2
import java.util.*;
import java.io.*;

public class problem_2164 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i =0 ; i < N ; i++) {
			q.add(i+1);
		}
		
		while(q.size() != 1) {
			q.poll(); //맨 위의 카드를 버린다.
			
			int top = q.poll();
			q.add(top);
		}
		
		System.out.println(q.poll());
	}
}
