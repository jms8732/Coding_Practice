package greedy;

//ÀÒ¾î¹ö¸° °ýÈ£
import java.util.*;
import java.io.*;

public class problem_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		String [] split = line.split("\\-");
		
		Deque<Integer> total = new LinkedList<>();
		for(int i =0 ; i < split.length ; i++) {
			String [] sp = split[i].split("\\+");
			
			Deque<Integer> dq = new LinkedList<>();
			for(int j =0 ; j<sp.length;  j++)
				dq.add(Integer.parseInt(sp[j]));
			
			while(dq.size() != 1) {
				int opr1 = dq.poll();
				int opr2 = dq.poll();
				
				dq.addFirst(opr1+opr2);
			}
			total.add(dq.poll());
		}
		while(total.size() != 1) {
			int opr1 = total.poll();
			int opr2 = total.poll();
			
			total.addFirst(opr1-opr2);
		}
		
		System.out.println(total.poll());
	}
}
