package greedy;

/*
 * ������ ���ġ
 * 1�� �۾��� ���� ������ ���� ���� �����ε��� 2�� �۾����� �������Ѵ�.
 */
import java.util.*;
import java.io.*;

public class problem_13413 {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i =0 ; i < tc ; i++) {
			int n = Integer.parseInt(br.readLine());
			
			String tar1 = br.readLine();

			String tar2 = br.readLine();
			
			System.out.println(greedy(tar1,tar2));
		}
	}
	
	private static int greedy(String t1 ,String t2) {
		int ret = 0;
		
		Stack<Character> stack = new Stack<>();
		for(int i =0 ; i < t1.length() ; i++) {
			if(t1.charAt(i) == t2.charAt(i))
				continue; //���� ���ڰ� ������ ���
			
			if(stack.isEmpty())
				stack.push(t1.charAt(i));
			else {
				if(stack.peek() != t1.charAt(i)) {
					stack.pop();
					ret++;
				}else
					stack.push(t1.charAt(i));
			}
		}
		
		return ret += stack.size();
	}
}
