package others;

//스택 수열
import java.util.*;
import java.io.*;

public class problem_1874 {
	public static void main(String[] args) throws IOException{
		BufferedReader br  =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		List<Character> answer = new ArrayList<>();

		int top = 0;
		for(int i =0 ; i <N ; i++) {
			int target = Integer.parseInt(br.readLine());
			
			while(stack.isEmpty() || stack.peek() < target) {
				answer.add('+');
				stack.push(++top);
			}
			
			if(!stack.isEmpty() && stack.peek() == target) {
				answer.add('-');
				stack.pop();
				continue;
			}
			
			System.out.println("NO");
			System.exit(0);
		}
		
		for(Character c : answer) {
			bw.write(c + "\n");
		}
		bw.flush();

	}
}
