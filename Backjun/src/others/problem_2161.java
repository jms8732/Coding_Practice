package others;

//Ä«µå1
import java.util.*;
import java.io.*;

public class problem_2161 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<>();
		
		for(int i= 1; i <= N ; i++)
			dq.add(i);
		
		while(dq.size() != 1) {
			int top = dq.poll();
			System.out.print(top + " ");
			int second_top = dq.poll();
			
			dq.addLast(second_top);
		}
		
		System.out.print(dq.poll());
	}
}
